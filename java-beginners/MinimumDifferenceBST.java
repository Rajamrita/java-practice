public class MinimumDifferenceBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    static int min = Integer.MAX_VALUE;
    static Integer prev = null;
    public static int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }
    public static void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (prev != null) {
            min = Math.min(min, node.val - prev);
        }
        prev = node.val;
        inorder(node.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(getMinimumDifference(root));
    }   
}
