import java.util.*;

public class DFS {

    static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                dfs(nei, visited, graph);
            }
        }
    }

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
        dfs(0, visited, graph);
    }
}
