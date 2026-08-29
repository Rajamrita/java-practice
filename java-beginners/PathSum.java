public class PathSum {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean hasPathSum(
            TreeNode root,
            int targetSum) {

        if (root == null) {
            return false;
        }

        // Check leaf
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return hasPathSum(
                root.left,
                targetSum - root.val
        )
        ||
        hasPathSum(
                root.right,
                targetSum - root.val
        );
    }

    public static void main(String[] args) {

        /*
                5
               / \
              4   8
             /
            11
           /  \
          7    2
        */

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);

        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        int targetSum = 22;

        System.out.println(
            hasPathSum(root, targetSum)
        );
    }
}