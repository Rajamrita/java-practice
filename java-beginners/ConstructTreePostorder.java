public class ConstructTreePostorder {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int postorderIndex;

    public static TreeNode buildTree(
            int[] inorder,
            int[] postorder) {

        postorderIndex = postorder.length - 1;

        return build(
                inorder,
                postorder,
                0,
                inorder.length - 1
        );
    }

    public static TreeNode build(
            int[] inorder,
            int[] postorder,
            int left,
            int right) {

        if (left > right) {
            return null;
        }

        // Last element = root
        int rootValue = postorder[postorderIndex--];

        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int rootIndex = left;

        while (inorder[rootIndex] != rootValue) {
            rootIndex++;
        }

        // Build RIGHT first
        root.right = build(
                inorder,
                postorder,
                rootIndex + 1,
                right
        );

        // Build LEFT
        root.left = build(
                inorder,
                postorder,
                left,
                rootIndex - 1
        );

        return root;
    }

    // Print preorder to check tree
    public static void printPreorder(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {

        int[] inorder = {9, 3, 15, 20, 7};

        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = buildTree(inorder, postorder);

        printPreorder(root);
    }
}