public class ConstructBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    static int preorderIndex = 0;
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int[] inorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex =  left;
        while (inorder[rootIndex] != rootValue) {
            rootIndex++;
        }
        root.left = build(preorder, inorder, left, rootIndex - 1);
        root.right = build(preorder, inorder, rootIndex + 1, right);
        return root;
    }
    public static void printPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        printPreorder(root);
    }
}
