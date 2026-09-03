public class FlattenBinaryTree {

    // TreeNode class
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        // Left aur right subtree ko flatten karo
        flatten(root.left);
        flatten(root.right);

        // Original right subtree ko save karo
        TreeNode temp = root.right;

        // Left subtree ko right side me lagao
        root.right = root.left;
        root.left = null;

        // Right side ke end tak jao
        TreeNode current = root;

        while (current.right != null) {
            current = current.right;
        }

        // Original right subtree ko end me lagao
        current.right = temp;
    }

    // Flattened tree print karne ke liye
    public static void printTree(TreeNode root) {

        while (root != null) {
            System.out.print(root.val + " ");

            // Right pointer se next node
            root = root.right;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Tree:
        //
        //        1
        //       / \
        //      2   5
        //     / \   \
        //    3   4   6

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        // Flatten
        flatten(root);

        // Print flattened tree
        System.out.print("Flattened Tree: ");
        printTree(root);
    }
}
