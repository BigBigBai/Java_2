package bigbigbai._09_graph;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ListGraph<V, E> extends Graph<V, E> {
    private static class Vertex<V, E> {
        V value;
        Set<Edge<V, E>> inEdges = new HashSet<>();
        Set<Edge<V, E>> outEdges = new HashSet<>();

        public Vertex(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex<?, ?> vertex = (Vertex<?, ?>) o;
            return Objects.equals(value, vertex.value) && Objects.equals(inEdges, vertex.inEdges) && Objects.equals(outEdges, vertex.outEdges);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, inEdges, outEdges);
        }
    }

    private static class Edge<V, E> {
        Vertex<V, E> from;
        Vertex<V, E> to;
        E weight;

        public Edge(Vertex<V, E> from, Vertex<V, E> to) {
            this.from = from;
            this.to = to;
            weight = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge<?, ?> edge = (Edge<?, ?>) o;
            return Objects.equals(from, edge.from) && Objects.equals(to, edge.to) && Objects.equals(weight, edge.weight);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to, weight);
        }
    }

    @Override
    public int verticesSize() {
        return 0;
    }

    @Override
    public int edgesSize() {
        return 0;
    }

    @Override
    public void addVertex(Object o) {

    }

    @Override
    public void removeVertex(Object o) {

    }

    @Override
    public void addEdge(Object fromV, Object toV) {

    }

    @Override
    public void addEdge(Object fromV, Object toV, Object weight) {

    }

    @Override
    public void removeEdge(Object fromV, Object toV) {

    }
}
