import java.util.LinkedList;
import java.util.StringTokenizer;

public class ArbolAG {
    private class Nodo {
        String valor;
        LinkedList<Nodo> hojas;
        public Nodo(String valor) {
            this.valor = valor;
            hojas = new LinkedList<Nodo>();
        }
    }
    private Nodo Raiz;
    private ArbolAG[] hojas;
    
    public ArbolAG() {
        Raiz = new Nodo("Raiz");
    }

    private Nodo ir(String path) {
        StringTokenizer SPath = new StringTokenizer(path, "/");
        String nodoName;
        if(SPath.countTokens() == 1) return Raiz;
        SPath.nextToken();
        Nodo h = Raiz;
        boolean found = false;

        while (SPath.hasMoreTokens()) {
            nodoName = SPath.nextToken();
            found = false;
            for (Nodo n : h.hojas) {
                if (n.valor.equals(nodoName)) {
                    h = n;
                    found = true;
                    break;
                }
            }
            if (!found) return null;
        }
        return h;
    }

    public boolean crearNodo(String path, String dato) {
        if (ir(path) != null) {
            ir(path).hojas.add(new Nodo(dato));
            return true;
        }
        return false;
    }

    public int size() {
        int cont = 0;
        Nodo n = Raiz;
        for (Nodo h : n.hojas) {
            cont++;
            for(Nodo z : h.hojas) {
                cont++;
            }
        }
        return cont;
    }

    public void print() {
        System.out.println("==================");
		System.out.println(Raiz.valor);
		print(Raiz, 1);
		System.out.println("==================");
    }

    private void print(Nodo c, int nivel) {
        String l = "";
        for (int i = 0; i < nivel; i++) l += "-";
        for (Nodo h : c.hojas) {
            System.out.println(l+h.valor);
            print(h, nivel+1);
        }
    }
}
