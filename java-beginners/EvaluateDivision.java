import java.util.*;

public class EvaluateDivision {

    // Edge class
    static class Edge {
        String node;
        double weight;

        Edge(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // DFS function
    public static double dfs(
            Map<String, List<Edge>> graph,
            String current,
            String target,
            double value,
            Set<String> visited) {

        // Target found
        if (current.equals(target)) {
            return value;
        }

        visited.add(current);

        for (Edge edge : graph.get(current)) {

            if (visited.contains(edge.node)) {
                continue;
            }

            double result = dfs(
                    graph,
                    edge.node,
                    target,
                    value * edge.weight,
                    visited
            );

            if (result != -1.0) {
                return result;
            }
        }

        return -1.0;
    }

    // Main function
    public static double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        // Create graph
        Map<String, List<Edge>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {

            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            double value = values[i];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            // a / b = value
            graph.get(a).add(new Edge(b, value));

            // b / a = 1 / value
            graph.get(b).add(new Edge(a, 1.0 / value));
        }

        double[] answer = new double[queries.size()];

        // Solve each query
        for (int i = 0; i < queries.size(); i++) {

            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);

            // Variable doesn't exist
            if (!graph.containsKey(start) ||
                !graph.containsKey(end)) {

                answer[i] = -1.0;
                continue;
            }

            Set<String> visited = new HashSet<>();

            answer[i] = dfs(
                    graph,
                    start,
                    end,
                    1.0,
                    visited
            );
        }

        return answer;
    }

    public static void main(String[] args) {

        // Example 1
        List<List<String>> equations = new ArrayList<>();

        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();

        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        double[] result = calcEquation(
                equations,
                values,
                queries
        );

        System.out.println("Answers:");

        System.out.println(Arrays.toString(result));
    }
}