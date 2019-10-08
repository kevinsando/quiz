package graphs;

import lists.Iterator;
import lists.List;
import lists.SimpleLinkedList;

public class Graph<V, E> {

    public Graph() {
        vertices = new SimpleLinkedList<>();
        edges = new SimpleLinkedList<>();
    }

    public GVertex<V> getVertex(V v) {
        GVertex<V> r = null;
        Iterator<GVertex<V>> i = vertices.getIterator();
        while (i.hasNext()) {
            GVertex<V> t = i.getNext();
            if (t.getInfo().equals(v)) {
                r = t;
                break;
            }
        }
        return r;
    }

    public void add(V v) {
        vertices.addLast(new GVertex<>(v));
    }

    public void add(GVertex<V> tail, GVertex<V> head, E w) {
        if ((tail == null) || (head == null)) {
            throw new NullPointerException("No existe el vértice.");
        }
        edges.addLast(new Edge<>(tail, head, w));
    }

    public void add(V t, V h, E w) {
        add(getVertex(t), getVertex(h), w);
    }

    public void add(V t, V h) {
        add(t, h, null);
    }

    @Override
    public String toString() {
        return String.format("G: (%n   V: %s,%n   E: %s%n)",
                vertices, edges);
    }

    private final List<GVertex<V>> vertices;
    private final List<Edge<V, E>> edges;

}
