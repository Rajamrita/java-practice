public class LowestCommonAncestor {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode lowestCommonAncestor(
            TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);

        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        return right;
    }

    public static void main(String[] args) {

        /*
                 3
                / \
               5   1
              / \
             6   2
                / \
               7   4
        */

        TreeNode root = new TreeNode(3);

        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);

        root.left = p;
        root.right = q;

        p.left = new TreeNode(6);
        p.right = new TreeNode(2);

        p.right.left = new TreeNode(7);
        p.right.right = new TreeNode(4);

        TreeNode result = lowestCommonAncestor(root, p, q);

        System.out.println("LCA: " + result.val);
    }
}