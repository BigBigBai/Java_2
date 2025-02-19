package bigbigbai._09_graph;

import org.junit.Test;

import java.util.List;

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



}
