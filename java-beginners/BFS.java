import java.util.*;

public class BFS {
    public static void main(String[] args) {

        int V = 4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(3);

        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");

            for (int nei : graph.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }
    }
}
