package bigbigbai._09_graph;

import java.util.List;

public abstract class Graph<V, E> {
    public Graph() {
    }

    public abstract int verticesSize();
    public abstract int edgesSize();

    public abstract void addVertex(V v);
    public abstract void removeVertex(V v);

    public abstract void addEdge(V fromV, V toV);
    public abstract void addEdge(V fromV, V toV, E weight);
    public abstract void removeEdge(V fromV, V toV);

    public abstract void bfs(V begin);
    public abstract void bfs(V begin, VertexVisitor<V> visitor);

    public abstract void dfs(V begin);
    public abstract void dfs(V begin, VertexVisitor<V> visitor);
    public abstract void dfs2(V begin);

    public abstract class VertexVisitor<V> {
        public abstract boolean visit(V val);
    }

    public abstract List<V> topologicalSort(V begin);
}
