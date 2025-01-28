package bigbigbai._09_graph;

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
}
