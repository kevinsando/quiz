package graphs;

import graphs.BasicTree;

public class mainmain {

    public static void main(String[] args) {

        BasicTree<String> a1 = new BasicTree<>("a");

        a1.add("a", "b");
        a1.add("a", "c");
        a1.add("c", "g");
        a1.add("b", "d");
        a1.add("b", "e");
        a1.add("b", "f");
        a1.add("e", "h");
        a1.add("e", "z");
        a1.add("z", "t");
        a1.add("z", "q");
        a1.add("h", "ñ");

        System.out.println(a1);
        System.out.println("Orden: "+a1.getOrder());
        System.out.println("Profundidad: "+a1.getDepth("f"));
        System.out.println("Ancho: "+a1.getWidth());
        System.out.println("Alto: "+a1.getHeight());

    }
}
