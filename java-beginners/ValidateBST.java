public class ValidateBST {

    // TreeNode class
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Check whether tree is valid BST
    public static boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean check(TreeNode root, long min, long max) {

        // Empty tree is valid
        if (root == null) {
            return true;
        }

        // Value must be strictly between min and max
        if (root.val <= min || root.val >= max) {
            return false;
        }

        // Check left subtree
        boolean left = check(root.left, min, root.val);

        // Check right subtree
        boolean right = check(root.right, root.val, max);

        return left && right;
    }

    public static void main(String[] args) {

        /*
                2
               / \
              1   3
        */

        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        boolean result = isValidBST(root);

        System.out.println("Is Valid BST: " + result);
    }
}