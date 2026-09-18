public class ConvertSortedArrayToBST {

    // TreeNode
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Convert sorted array to BST
    public static TreeNode sortedArrayToBST(int[] nums) {

        return buildTree(nums, 0, nums.length - 1);
    }

    // Build tree recursively
    public static TreeNode buildTree(int[] nums, int left, int right) {

        // No elements
        if (left > right) {
            return null;
        }

        // Find middle
        int mid = left + (right - left) / 2;

        // Middle element becomes root
        TreeNode root = new TreeNode(nums[mid]);

        // Build left subtree
        root.left = buildTree(nums, left, mid - 1);

        // Build right subtree
        root.right = buildTree(nums, mid + 1, right);

        return root;
    }

    // Print tree in preorder
    public static void printPreorder(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        printPreorder(root.left);
        printPreorder(root.right);
    }

    public static void main(String[] args) {

        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode root = sortedArrayToBST(nums);

        System.out.print("BST Preorder: ");
        printPreorder(root);
    }
}