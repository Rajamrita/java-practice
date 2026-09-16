import java.util.*;

public class LevelOrderTraversal {

    // Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Level Order Traversal
    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                level.add(current.val);

                // Add left child
                if (current.left != null) {
                    queue.add(current.left);
                }

                // Add right child
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {

        /*
                3
               / \
              9   20
                 /  \
                15   7
        */

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> answer = levelOrder(root);

        System.out.println("Level Order Traversal: " + answer);
    }
}