import java.util.*;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        // Indegree of each course
        int[] indegree = new int[numCourses];

        // Graph
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] pair : prerequisites) {

            int course = pair[0];
            int prerequisite = pair[1];

            graph.get(prerequisite).add(course);

            indegree[course]++;
        }

        // Queue for courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int completed = 0;

        // Process courses
        while (!queue.isEmpty()) {

            int current = queue.poll();

            completed++;

            // Remove current course as prerequisite
            for (int next : graph.get(current)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // All courses completed?
        return completed == numCourses;
    }

    public static void main(String[] args) {

        // Example 1
        int numCourses1 = 2;

        int[][] prerequisites1 = {
            {1, 0}
        };

        boolean answer1 = canFinish(numCourses1, prerequisites1);

        System.out.println("Example 1: " + answer1);


        // Example 2
        int numCourses2 = 2;

        int[][] prerequisites2 = {
            {1, 0},
            {0, 1}
        };

        boolean answer2 = canFinish(numCourses2, prerequisites2);

        System.out.println("Example 2: " + answer2);
    }
}