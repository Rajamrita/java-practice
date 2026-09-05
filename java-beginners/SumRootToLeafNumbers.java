public class SumRootToLeafNumbers {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public static int helper(TreeNode root, int currentNumber) {

        if (root == null) {
            return 0;
        }

        currentNumber = currentNumber * 10 + root.val;

        if (root.left == null && root.right == null) {
            return currentNumber;
        }

        return helper(root.left, currentNumber)
             + helper(root.right, currentNumber);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(sumNumbers(root));
    }
}