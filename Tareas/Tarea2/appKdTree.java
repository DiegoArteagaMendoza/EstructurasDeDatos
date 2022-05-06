import java.util.LinkedList;

public class appKdTree {

    private class Punto {
        int x = 0;
        int y = 0;
        Punto left;
        Punto right;
        LinkedList<Punto> puntos;
        Punto(int x, int y, Punto left, Punto right) {
            this.x = x;
            this.y = y;
            this.left = left;
            this.right = right;
            puntos = new LinkedList<>();
        }
    }
    private Punto raiz;

    public appKdTree() {
        raiz = null;
    }

    public void insert(int x, int y) {
        raiz = addPunto(raiz, x, y);
    }
    
    private Punto addPunto(Punto raiz, int x, int y) {
        if (raiz == null) {
            return new Punto(x, y, null, null);
        } else {
            if (x < raiz.x) {
                raiz.left = addPunto(raiz.left, x, y);
            }
            if (x > raiz.x) {
                raiz.right = addPunto(raiz.right, x, y);
            }
        }
        return raiz;
    }

    public void busca(int x, int y) {
        raiz = buscPunto(raiz, x, y);
        if (raiz != null) {
            System.out.println("El punto " + x + "," + y +  " fue encontrado");
        } else {
            System.out.println("No se pillo");
        }
    }

    private Punto buscPunto(Punto raiz, int x, int y) {
        if (raiz == null) {
            return null;
        } else {
            if (x < raiz.x) {
                raiz.left = buscPunto(raiz.left, x, y);
            }
            if (x > raiz.x) {
                raiz.right = buscPunto(raiz.right, x, y);
            }
        }
        return raiz;
    }

    public void Imprimir() {
        ImprimirKd(raiz, " ");
    }

    private void ImprimirKd(Punto n, String tab) {
		if (n != null) {
            ImprimirKd(n.left, tab + "  \t");
			System.out.println(tab + n.x + "," + n.y + "\n");
			ImprimirKd(n.right, tab + "  \t");
		}
	}
}
