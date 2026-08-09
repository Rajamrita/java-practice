import java.util.*;
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        while (i < intervals.length &&
              intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
    public static void main(String[] args) {
        InsertInterval obj = new InsertInterval();
        int[][] intervals = {
           {1, 3},
           {3, 5},
           {6, 7},
           {8, 10},
           {12, 16}
        };
        int[] newInterval = {4, 8};
        int[][] answer = obj.insert(intervals, newInterval);
        for (int[] interval : answer) {
            System.out.println(
                 "[" + interval[0] + "," + interval[1] + "]"
            );
        }
    }
    
}
