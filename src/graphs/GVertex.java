package graphs;

public class GVertex<V> {

    public GVertex(V info) {
        this.info = info;
    }

    public V getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return String.format("%s", getInfo());
    }

    private final V info;
}
