package graphs;

import lists.List;

public class BasicTree<V> implements Tree<V> {

    public BasicTree(V info) {
        root = new TVertex<>(info);
    }

    @Override
    public int getOrder() {      
        return root.getOrder();
    }

    @Override
    public int getWidth() {     
        return root.getWidth();
    }

    @Override
    public int getHeight() {
        return root.getHeight()-1;
    }

    @Override
    public int getDepth() {

        return -1;
    }
    
    public int getDepth(V info) {
        Vertex<V> vertice = this.getVertex(info);
        
        return vertice.getDepth();
        
    }

    @Override
    public Vertex<V> getRoot() {
        return root;
    }

    @Override
    public Vertex<V> getVertex(V v) {
        return root.getVertex(v);
    }

    @Override
    public List<Vertex<V>> getChildren() {
        throw new UnsupportedOperationException();
    }

    public List<Vertex<V>> getAllVertices(int levels) {
        return root.getAllVertices(levels);
    }

    public List<Vertex<V>> getAllVertices() {
        return getAllVertices(-1);
    }

    public boolean add(V v0, V v1) {
        boolean success = true;
        try {
            root.getVertex(v0).add(v1);
        } catch (NullPointerException ex) {
            success = false;
        }
        return success;
    }

    @Override
    public String toString() {
        return String.format("T: (%s)", root);
    }

    public String toString(int n) {
        return root.toString(n);
    }

    private final TVertex<V> root;
}
