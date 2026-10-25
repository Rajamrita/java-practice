import java.util.*;

public class SmallestPairs {

    public static List<List<Integer>> kSmallestPairs(
            int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums1 == null || nums1.length == 0 ||
            nums2 == null || nums2.length == 0 || k <= 0) {
            return result;
        }

        // Min-heap: stores sum, index in nums1, index in nums2
        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a, b) ->
                        Integer.compare(a[0], b[0]));

        // Add the first pair for each of the first k elements of nums1
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{
                    nums1[i] + nums2[0], i, 0
            });
        }

        while (k > 0 && !minHeap.isEmpty()) {

            int[] curr = minHeap.poll();

            int u = curr[1];
            int v = curr[2];

            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[u]);
            pair.add(nums2[v]);

            result.add(pair);

            // Add the next pair from nums2
            if (v + 1 < nums2.length) {
                minHeap.offer(new int[]{
                        nums1[u] + nums2[v + 1], u, v + 1
                });
            }

            k--;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;

        List<List<Integer>> result =
                kSmallestPairs(nums1, nums2, k);

        System.out.println("K Smallest Pairs:");

        for (List<Integer> pair : result) {
            System.out.println(pair);
        }
    }
}