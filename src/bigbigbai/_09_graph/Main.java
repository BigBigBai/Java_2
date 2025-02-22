package bigbigbai._09_graph;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Graph<String, Integer> graph = new ListGraph<>();
        graph.addEdge("v1", "v0", 9);
        graph.addEdge("v1", "v2", 3);
        graph.addEdge("v0", "v4", 6);
        graph.addEdge("v2", "v0", 2);
        graph.addEdge("v2", "v3", 5);
        graph.addEdge("v3", "v4", 1);
        graph.removeVertex("v0");
        System.out.println();
    }

    @Test
    public void bfs() {
        Graph<String, Integer> graph = new ListGraph<>();
        graph.addEdge("v1", "v0", 9);
        graph.addEdge("v1", "v2", 3);
        graph.addEdge("v0", "v4", 6);
        graph.addEdge("v2", "v0", 2);
        graph.addEdge("v2", "v3", 5);
        graph.addEdge("v3", "v4", 1);
        graph.bfs("v1");
    }

    @Test
    public void dfs() {
        Graph<String, Integer> graph = new ListGraph<>();
        graph.addEdge("v1", "v0", 9);
        graph.addEdge("v1", "v2", 3);
        graph.addEdge("v0", "v4", 6);
        graph.addEdge("v2", "v0", 2);
        graph.addEdge("v2", "v3", 5);
        graph.addEdge("v3", "v4", 1);
        graph.dfs("v1");
    }

    @Test
    public void dfs2() {
        Graph<String, Integer> graph = new ListGraph<>();
        graph.addEdge("v1", "v0", 9);
        graph.addEdge("v1", "v2", 3);
        graph.addEdge("v0", "v4", 6);
        graph.addEdge("v2", "v0", 2);
        graph.addEdge("v2", "v3", 5);
        graph.addEdge("v3", "v4", 1);
        graph.dfs2("v1");
    }

    @Test
    public void topo() {
        Graph<String, Integer> graph = new ListGraph<>();
        graph.addEdge("v1", "v0");
        graph.addEdge("v0", "v2");
        graph.addEdge("v3", "v1");
        graph.addEdge("v3", "v5");
        graph.addEdge("v3", "v7");
        graph.addEdge("v5", "v7");
        graph.addEdge("v2", "v5");
        graph.addEdge("v2", "v6");
        graph.addEdge("v7", "v6");
        graph.addEdge("v6", "v4");
        List<String> list = graph.topologicalSort("v0");
        System.out.println(list);
    }

    @Test
    public void mst() {
        Graph<Object, Double> unDirectedGraph = unDirectGraph(Data.MST_02);
        Set<Graph.EdgeInfo<Object, Double>> mst = unDirectedGraph.mst();
        System.out.println(mst);
    }

    @Test
    public void dijkstra() {
        Graph<Object, Double> directGraph = directGraph(Data.SP);
        Map<Object, Double> paths = directGraph.shortestPathWithoutPathInfo("A");
        System.out.println(paths);
    }





    public static Graph.WeightManager<Double> weightManager = new Graph.WeightManager<>() {
        @Override
        public int compare(Double w1, Double w2) {
            return w1.compareTo(w2);
        }

        @Override
        public Double add(Double w1, Double w2) {
            return w1 + w2;
        }

        @Override
        public Double zero() {
            return 0.0;
        }
    };

    private static Graph<Object, Double> unDirectGraph(Object[][] data) {
        Graph<Object, Double> graph = new ListGraph<>(weightManager);
        for (Object[] edge : data) {
            if (edge.length == 1) {
                graph.addVertex(edge[0]);//离散的点
            } else if (edge.length == 2) {
                graph.addEdge(edge[0], edge[1]);
                graph.addEdge(edge[1], edge[0]);
            } else if (edge.length == 3) {
                double weight = Double.parseDouble(edge[2].toString());

                graph.addEdge(edge[0], edge[1], weight);
                graph.addEdge(edge[1], edge[0], weight);
            }
        }
        return graph;
    }

    private static Graph<Object, Double> directGraph(Object[][] data) {
        Graph<Object, Double> graph = new ListGraph<>(weightManager);
        for (Object[] edge : data) {
            if (edge.length == 1) {
                graph.addVertex(edge[0]);
            } else if (edge.length == 2) {
                graph.addEdge(edge[0], edge[1]);
            } else if (edge.length == 3) {
                double weight = Double.parseDouble(edge[2].toString());

                graph.addEdge(edge[0], edge[1], weight);
            }
        }
        return graph;
    }

}
