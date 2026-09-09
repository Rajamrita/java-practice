public class KthSmallestBST {

    // TreeNode class
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int count = 0;
    static int answer = 0;

    public static int kthSmallest(TreeNode root, int k) {

        inorder(root, k);

        return answer;
    }

    public static void inorder(TreeNode root, int k) {

        if (root == null) {
            return;
        }

        // 1. Left
        inorder(root.left, k);

        // 2. Root
        count++;

        if (count == k) {
            answer = root.val;
            return;
        }

        // 3. Right
        inorder(root.right, k);
    }

    public static void main(String[] args) {

        /*
                 3
                / \
               1   4
                \
                 2
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.left.right = new TreeNode(2);

        int k = 1;

        int result = kthSmallest(root, k);

        System.out.println("Kth Smallest Element: " + result);
    }
}