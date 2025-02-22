package bigbigbai._09_graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Graph<V, E> {
    protected WeightManager<E> weightManager;
    public Graph() {}
    public Graph(WeightManager<E> weightManager) {
        this.weightManager = weightManager;
    }

    // Graph1
    public abstract int verticesSize();
    public abstract int edgesSize();
    public abstract void addVertex(V v);
    public abstract void removeVertex(V v);
    public abstract void addEdge(V fromV, V toV);
    public abstract void addEdge(V fromV, V toV, E weight);
    public abstract void removeEdge(V fromV, V toV);

    // Graph2
    public abstract void bfs(V begin);
    public abstract void bfs(V begin, VertexVisitor<V> visitor);
    public abstract void dfs(V begin);
    public abstract void dfs(V begin, VertexVisitor<V> visitor);
    public abstract void dfs2(V begin);

    // Graph3
    public abstract List<V> topologicalSort(V begin);
    public abstract Set<EdgeInfo<V, E>> mst();

    // Graph4
    public abstract Map<V, E> shortestPathWithoutPathInfo(V begin);

    // Graph5
    public abstract Map<V, PathInfo<V, E>> shortestPath(V begin);
    public abstract Map<V, Map<V, PathInfo<V, E>>> shortestPath();



    public abstract static class VertexVisitor<V> {
        public abstract boolean visit(V val);
    }

    public static class EdgeInfo<V, E> {
        V from;
        V to;
        E weight;

        public EdgeInfo(V from, V to, E weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public V getFrom() {
            return from;
        }

        public void setFrom(V from) {
            this.from = from;
        }

        public V getTo() {
            return to;
        }

        public void setTo(V to) {
            this.to = to;
        }

        public E getWeight() {
            return weight;
        }

        public void setWeight(E weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "{from=" + from + ", to=" + to + ", weight=" + weight + "}\n";
        }
    }

    public interface WeightManager<E> {
        int compare(E w1, E w2);

        E add(E w1, E w2);

        E zero();
    }

    public static class PathInfo<V, E> {
        E weight;
        List<EdgeInfo<V, E>> edgeInfos = new LinkedList<>();

        public PathInfo() {}

        public PathInfo(E weight) {
            this.weight = weight;
        }

        public E getWeight() {
            return weight;
        }

        public void setWeight(E weight) {
            this.weight = weight;
        }

        public List<EdgeInfo<V, E>> getEdgeInfos() {
            return edgeInfos;
        }

        public void setEdgeInfos(List<EdgeInfo<V, E>> edgeInfos) {
            this.edgeInfos = edgeInfos;
        }

        @Override
        public String toString() {
            return "PathInfo{" +
                    "weight=" + weight +
                    ", edgeInfos=" + edgeInfos +
                    '}';
        }
    }
}
