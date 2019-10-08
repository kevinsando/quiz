package graphs;

public interface Vertex<V> {

    public int getOrder();

    public int getWidth();

    public int getHeight();

    public int getDepth();

    public Vertex<V> getVertex(V v);

    public void add(V v);

    public V getInfo();

}
