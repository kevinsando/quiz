package graphs;

import lists.AbstractList;
import lists.Iterator;
import lists.List;
import lists.SimpleLinkedList;

public class TVertex<V> implements Vertex<V> {

    public TVertex(V info, TVertex<V> antecessor) {
        this.info = info;
        this.antecessor = antecessor;
        this.successors = new SimpleLinkedList<>();
    }

    public TVertex(V info) {
        this(info, null);
    }

    public TVertex<V> getAntecessor() {
        return antecessor;
    }

    @Override
    public int getOrder() {
        int resultado = 0;
        Iterator<TVertex<V>> i = successors.getIterator();
        while (i.hasNext()) {
            TVertex<V> t = i.getNext();
            if (resultado <= t.getChildrenCount()) {
                resultado = t.getChildrenCount();
            }
        }
        return resultado;
    }

    @Override
    public int getWidth() {

        return getWidth(0);
    }

    public int getWidth(int w) {
        if (this.getChildrenCount() == 0) {
            w++;
        } else {
            List<Vertex<V>> children = this.getChildren();
            for (int i = 0; i < this.getChildrenCount(); i++) {
                w += children.get(i).getWidth();
            }
        }
        return w;
    }

    @Override
    public int getHeight() {
        return getHeight(0);
    }

    public int getHeight(int w) {

//        if(this.getChildrenCount()==0){
//           return w;
//        }else{
//            List<Vertex<V>> children = this.getChildren();
//            for(int i=0;i<this.getChildrenCount();i++){
//                if(w<children.get(i).getWidth())
//                {
//                    w = children.get(i).getWidth();
//                }
//                
//            }
//        }
//        return w+1;
        List<Vertex<V>> children = this.getChildren();
        int auxHeight=w;
        w++;
        for(int i=0;i<this.getChildrenCount();i++){
            auxHeight +=children.get(i).getHeight();
            if(auxHeight>w){
                w = auxHeight;
            }
        }
        return w;
    }

    @Override
    public int getDepth() {
        TVertex<V> cursor = this;
        int resultado = 0;
        while (cursor.antecessor != null) {
            resultado += 1;
            cursor = cursor.antecessor;
        }
        return resultado;
    }

    @Override
    public Vertex<V> getVertex(V v) {
        TVertex<V> r = null;
        if (getInfo().equals(v)) {
            r = this;
        } else {
            Iterator<TVertex<V>> i = successors.getIterator();
            while (i.hasNext()) {
                TVertex<V> t = i.getNext();
                TVertex<V> z = (TVertex<V>) t.getVertex(v);
                if (z != null) {
                    r = z;
                    break;
                }
            }
        }
        return r;
    }

    public int getChildrenCount() {
        return successors.count();
    }

    public List<Vertex<V>> getChildren() {
        List<Vertex<V>> r = new SimpleLinkedList<>();
        Iterator<TVertex<V>> i = successors.getIterator();
        while (i.hasNext()) {
            r.addLast(i.getNext());
        }
        return r;
    }

    public List<Vertex<V>> getAllVertices(int n) {
        List<Vertex<V>> r = new SimpleLinkedList<>();
        r.addLast(this);

        if (n != 0) {

            Iterator<TVertex<V>> i = successors.getIterator();
            while (i.hasNext()) {
                TVertex<V> t = i.getNext();

                List<Vertex<V>> succv = t.getAllVertices(n > 0 ? n - 1 : n);

                Iterator<Vertex<V>> j = succv.getIterator();
                while (j.hasNext()) {
                    r.addLast(j.getNext());
                }

            }
        }

        return r;
    }

    public void add(TVertex<V> succ) {
        successors.addLast(succ);
    }

    public void add(V v) {
        add(new TVertex<>(v, this));
    }

    @Override
    public V getInfo() {
        return info;
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder("{");
        r.append(getInfo());
        if (!successors.isEmpty()) {
            r.append(String.format(", %s", successors.toString()));
        }
        r.append("}");
        return r.toString();
    }

    public String toString(int n) {
        StringBuilder r = new StringBuilder();
        String fmt = String.format("%%%ds%%s%%n", NODE_INDENT * n + 1);
        r.append(String.format(fmt, " ", getInfo()));
        Iterator<TVertex<V>> i = successors.getIterator();
        while (i.hasNext()) {
            r.append(i.getNext().toString(n + 1));
        }
        return r.toString();
    }

    private static final int NODE_INDENT = 4;

    private final V info;
    private TVertex<V> antecessor;
    private final AbstractList<TVertex<V>> successors;
}
