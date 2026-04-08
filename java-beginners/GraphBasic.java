import java.util.*;

public class GraphBasic {
    public static void main(String[] args) {

        int V = 4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(3);

        System.out.println(graph);
    }
}
