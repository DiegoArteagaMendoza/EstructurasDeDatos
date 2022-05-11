public class testArbolNario {
    public static void main(String[] args) {
        ArbolNarios ar = new ArbolNarios();
        
        boolean chek = ar.make("a");
        if (chek == true) System.out.println("Nodo agregado");
        chek = ar.make("b");
        if (chek == true) System.out.println("Nodo agregado");
        System.out.println(ar.cant());
        System.out.println(ar.grade());
    }
}
