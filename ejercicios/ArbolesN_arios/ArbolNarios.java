import java.util.LinkedList;

public class ArbolNarios {
    private class Nodo {
        String val;
        LinkedList<Nodo> hojas;
        public Nodo(String val) {
            this.val = val;
            hojas = new LinkedList<Nodo>();
        }
    }

    private Nodo raiz;
    private ArbolNarios[] hojas;

    public ArbolNarios() {
        raiz = new Nodo(null);
    }

    int cantNodos = 0;

    public boolean make(String val) {
        if (raiz == null) {
            raiz = new Nodo(val);
            cantNodos++;
            return true;
        } else {
            raiz.hojas.add(new Nodo(val));
            cantNodos++;
            return true;
        }
    }

    public int grade() {
        int max = maxgrade(raiz);
        return max;
    }
    private int maxgrade(Nodo raiz) {
        
    }

    public int cant() {
        return cantNodos;
    }
}
