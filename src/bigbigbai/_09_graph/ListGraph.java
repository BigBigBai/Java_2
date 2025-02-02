package bigbigbai._09_graph;

import java.util.*;

public class ListGraph<V, E> extends Graph<V, E> {
    private Set<Edge<V, E>> edges = new HashSet<>();
    private Map<V, Vertex<V, E>> vertices = new HashMap<>();

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
            return value != null ? value.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "vertex = " + value;
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
//            return from.hashCode() * 31 + to.hashCode() * 31 + weight.hashCode();

            return from.hashCode() * 31 + to.hashCode() * 31;
        }
    }

    @Override
    public int verticesSize() {
        return vertices.size();
    }

    @Override
    public int edgesSize() {
        return edges.size();
    }

    @Override
    public void addVertex(V v) {
        if (vertices.containsKey(v)) return;
        vertices.put(v, new Vertex<>(v));
    }

    @Override
    public void removeVertex(V v) {
        Vertex<V, E> vertex = vertices.remove(v);
        if (vertex == null) return;

        // for collection set deletion, cannot loop while deleting
        // has ConcurrentModificationException
        // Soln: use Iterator to iterate and remove!
//        for (Edge<V, E> edge : vertex.outEdges) {
//            removeEdge(edge.from.value, edge.to.value);
//        }
//
//        for (Edge<V, E> edge : vertex.inEdges) {
//            removeEdge(edge.from.value, edge.to.value);
//        }

        for (Iterator<Edge<V, E>> iterator = vertex.outEdges.iterator(); iterator.hasNext();) {
            Edge<V, E> edge = iterator.next();
            // 666!
            edge.to.inEdges.remove(edge);
            iterator.remove();
            edges.remove(edge);
        }

        for (Iterator<Edge<V, E>> iterator = vertex.inEdges.iterator(); iterator.hasNext();) {
            Edge<V, E> edge = iterator.next();
            // 666!
            edge.from.outEdges.remove(edge);
            iterator.remove();
            edges.remove(edge);
        }
    }

    @Override
    public void addEdge(V fromV, V toV) {
        addEdge(fromV, toV, null);
    }

    @Override
    public void addEdge(V fromV, V toV, E weight) {
        // 1. test if fromV, toV exist
        Vertex<V, E> fromVertex = vertices.get(fromV);
        if (fromVertex == null) {
            fromVertex = new Vertex<>(fromV);
            vertices.put(fromV, fromVertex);
        }

        Vertex<V, E> toVertex = vertices.get(toV);
        if (toVertex == null) {
            toVertex = new Vertex<>(toV);
            vertices.put(toV, toVertex);
        }

        // 2. code can come here, demonstrate that this edge's start vertex and end vertex must exist
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);
        edge.weight = weight;

        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }

        fromVertex.outEdges.add(edge);
        toVertex.inEdges.add(edge);
        edges.add(edge);
    }

    @Override
    public void removeEdge(V fromV, V toV) {
        // 1. test if fromV, toV exist
        Vertex<V, E> fromVertex = vertices.get(fromV);
        if (fromVertex == null) return;

        Vertex<V, E> toVertex = vertices.get(toV);
        if (toVertex == null) return;

        // 2. code can come here, demonstrate that this edge's start vertex and end vertex must exist
        Edge<V, E> edge = new Edge<>(fromVertex, toVertex);

        if (fromVertex.outEdges.remove(edge)) {
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
    }

    @Override
    public void bfs(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;

        Queue<Vertex<V, E>> queue = new LinkedList<>();
        Set<Vertex<V, E>> visited = new HashSet<>();
        queue.add(beginVertex);
        visited.add(beginVertex);

        while (!queue.isEmpty()) {
            Vertex<V, E> poll = queue.poll();
            System.out.println(poll);
            for (Edge<V, E> outEdge : poll.outEdges) {
                if (visited.contains(outEdge.to)) continue;
                queue.add(outEdge.to);
                visited.add(outEdge.to);
            }
        }
    }

    @Override
    public void bfs(V begin, VertexVisitor<V> visitor) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;

        Queue<Vertex<V, E>> queue = new LinkedList<>();
        Set<Vertex<V, E>> visited = new HashSet<>();
        queue.add(beginVertex);
        visited.add(beginVertex);

        while (!queue.isEmpty()) {
            Vertex<V, E> poll = queue.poll();
//            System.out.println(poll);
            if (visitor.visit(poll.value)) return;

            for (Edge<V, E> outEdge : poll.outEdges) {
                if (visited.contains(outEdge.to)) continue;
                queue.add(outEdge.to);
                visited.add(outEdge.to);
            }
        }
    }

    @Override
    public void dfs(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;

        dfs(beginVertex, new HashSet<>());
    }

    private void dfs(Vertex<V, E> beginVertex, Set<Vertex<V, E>> visited) {
        System.out.println(beginVertex.value);
        visited.add(beginVertex);

        for (Edge<V, E> outEdge : beginVertex.outEdges) {
            if (visited.contains(outEdge.to)) continue;
            dfs(outEdge.to, visited);
        }
    }

    @Override
    public void dfs(V begin, VertexVisitor<V> visitor) {

    }

    /**
     * Thought:
     * 1. push start vertex into stack and traverse (pop stack top), save into visited set
     * 2. if stack top's outEdge's points are not in visited set, push outEdge's from and to point into stack in order
     * 3. repeat traverse, save into visited set
     * @param begin
     */
    public void dfs2(V begin) {
        Vertex<V, E> beginVertex = vertices.get(begin);
        if (beginVertex == null) return;

        Set<Vertex<V, E>> visited = new HashSet<>();
        Stack<Vertex<V, E>> stack = new Stack<>();
        stack.push(beginVertex);//1
        visited.add(beginVertex);//1
        System.out.println(beginVertex.value);

        while (!stack.isEmpty()) {
            Vertex<V, E> vertex = stack.pop();//1 //3 //7
//            System.out.println(vertex.value);//1, 3
            for (Edge<V, E> outEdge : vertex.outEdges) {//vertex = 1, 3
                if (visited.contains(outEdge.to)) continue;
                stack.push(outEdge.from);//1, 3
                stack.push(outEdge.to);//3, 7
                visited.add(outEdge.to);//3. 7
                System.out.println(outEdge.to.value);

                // can let iteration go deep, visit deeper point
                break;
            }
        }
    }

    /**
     * Thought
     * 1.need to prepare a map(to store inDegree info), a queue(cached area), a list(save sorted result)
     * 2.put inDegree=0 vertex into queue, inDegree!=0 into map
     * 3.poll queue head element, put into list, update inDegree info in map
     * 4.in map, find inDegree=0 vertex and put into queue
     * 5.repeat3, 4, until queue becomes null
     * @author: Dal
     */
    public List<V> topologicalSort(V begin) {
        //1.need to prepare a map(to store inDegree info), a queue(cached area), a list(save sorted result)
        Map<Vertex<V, E>, Integer> map = new HashMap<>();
        Queue<Vertex<V, E>> queue = new LinkedList<>();
        List<V> list = new LinkedList<>();

        //2.put inDegree=0 vertex into queue, inDegree!=0 into map
        vertices.forEach((V v, Vertex<V, E> vertex)->{
            int size = vertex.inEdges.size();
            if (size == 0) queue.offer(vertex);
            else map.put(vertex, size);
        });

        //5.repeat3, 4, until queue becomes null
        while (!queue.isEmpty()) {
            //3.poll queue head element, put into list, update inDegree info in map
            Vertex<V, E> vertex = queue.poll();
            list.add(vertex.value);
            for (Edge<V, E> edge : vertex.outEdges) {
                int toIn = map.get(edge.to) - 1;
                //4.in map, find inDegree=0 vertex and put into queue
                if (toIn == 0) queue.offer(edge.to);
                else map.put(edge.to, toIn);
            }
        }

        return list;
    }
}
