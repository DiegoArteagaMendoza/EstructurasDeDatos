public class testAG {
    public static void main(String[] args) {
        ArbolAG ad = new ArbolAG();
        ad.print();
        System.out.println("Arbol size: " + ad.size());
        ad.crearNodo("Raiz", "a");
        ad.crearNodo("Raiz", "b");
        ad.crearNodo("Raiz", "c");
        System.out.println("Arbol size: " + ad.size());

        System.out.println("Arbol");
        ad.print();

        ad.crearNodo("Raiz/a", "d");
        ad.crearNodo("Raiz/a", "e");
        ad.crearNodo("Raiz/b", "f");
        ad.crearNodo("Raiz/c", "g");
        ad.crearNodo("Raiz/c", "h");
        System.out.println("Arbol size: " + ad.size());

        System.out.println("Arbol");
        ad.print();
    }
}
