import java.util.*;

public class AverageOfLevels {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            long sum = 0;

            for (int i = 0; i < size; i++) {

                TreeNode current = queue.poll();

                sum += current.val;

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            double average = (double) sum / size;
            result.add(average);
        }

        return result;
    }

    public static void main(String[] args) {

        // Tree:
        //        3
        //       / \
        //      9   20
        //         /  \
        //        15   7

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> answer = averageOfLevels(root);

        System.out.println("Average of Each Level: " + answer);
    }
}