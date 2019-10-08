package graphs;

import lists.List;

public interface Tree<V> {

    public int getOrder();

    public int getWidth();

    public int getHeight();

    public int getDepth();

    public Vertex<V> getRoot();

    public Vertex<V> getVertex(V v);

    public List<Vertex<V>> getChildren();

}
