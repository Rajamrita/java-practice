import java.util.*;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (nextStart <= end) {

                end = Math.max(end, nextEnd);

            } else {

                result.add(new int[]{start, end});

                start = nextStart;
                end = nextEnd;
            }
        }

        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        MergeIntervals obj = new MergeIntervals();

        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        int[][] answer = obj.merge(intervals);

        for (int[] interval : answer) {
            System.out.println(
                "[" + interval[0] + "," + interval[1] + "]"
            );
        }
    }
}