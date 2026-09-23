import java.util.*;

public class CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        // Step 1: Store indegree of every course
        int[] indegree = new int[numCourses];

        // Step 2: Create graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 3: Build graph and indegree
        for (int[] pair : prerequisites) {

            int course = pair[0];
            int prerequisite = pair[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        // Step 4: Put courses with 0 prerequisites into queue
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 5: Store answer
        int[] answer = new int[numCourses];
        int index = 0;

        // Step 6: Topological Sort
        while (!queue.isEmpty()) {

            int current = queue.poll();

            answer[index] = current;
            index++;

            // Check courses depending on current course
            for (int next : graph.get(current)) {

                indegree[next]--;

                // No prerequisites left
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // Step 7: Check if all courses were completed
        if (index == numCourses) {
            return answer;
        }

        // Cycle exists
        return new int[0];
    }

    public static void main(String[] args) {

        // Example 1
        int numCourses1 = 2;
        int[][] prerequisites1 = {
            {1, 0}
        };

        int[] result1 = findOrder(numCourses1, prerequisites1);

        System.out.println("Example 1:");
        System.out.println(Arrays.toString(result1));


        // Example 2
        int numCourses2 = 4;
        int[][] prerequisites2 = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        int[] result2 = findOrder(numCourses2, prerequisites2);

        System.out.println("Example 2:");
        System.out.println(Arrays.toString(result2));


        // Example 3
        int numCourses3 = 1;
        int[][] prerequisites3 = {};

        int[] result3 = findOrder(numCourses3, prerequisites3);

        System.out.println("Example 3:");
        System.out.println(Arrays.toString(result3));
    }
}