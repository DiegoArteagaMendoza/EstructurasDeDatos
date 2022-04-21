import java.util.LinkedList;

public class ArbolBinario {
    int dato;
    ArbolBinario iz;
    ArbolBinario der;
    public ArbolBinario(int dato){
        this.dato=dato;
        iz=null;
        der=null;
    }

    public ArbolBinario(int dato, ArbolBinario iz, ArbolBinario der){
        this.dato=dato;
        this.iz=iz;
        this.der=der;
    }
    public void preOrden(){
        System.out.print(this.dato+" ");
        if(iz!=null) iz.preOrden();
        if(der!=null) der.preOrden();
    }

    public void inOrden(){
        if(iz!=null) iz.preOrden();
        System.out.print(this.dato+" ");
        if(der!=null) der.preOrden();
    }

    public void posOrden(){
        if(iz!=null) iz.preOrden();
        if(der!=null) der.preOrden();
        System.out.print(this.dato+" ");
    }

    //cantidad de nodos-1 del camino más largo de la raiz a sus hojas
    public int altura(){
        return altura(this);
    }

    private int altura(ArbolBinario raiz){
        if(raiz==null){
            return -1;
        }
        return 1 + Math.max(altura(raiz.iz),altura(raiz.der));
    }

    //size: cantidad de nodos del árbol
    public int size(){
        return size(this);
    }

    private int size(ArbolBinario raiz){
        if (raiz==null){
            return 0;
        }
        return 1 + size(raiz.iz) + size(raiz.der);
    }

    public void tree(){
        tree(this, "");
    }

    private void tree(ArbolBinario raiz, String tab) {
        if(raiz!=null){
            System.out.println(tab+"->"+raiz.dato);
            tree(raiz.iz, tab+"  |");
            tree(raiz.der, tab+"  ");
        }
    }

    LinkedList<ArbolBinario> NodosRango = new LinkedList<>();

    public LinkedList<ArbolBinario> rango(int i, int j) {
        if(this.dato >= i && this.dato <= j) {
            NodosRango.addLast(this);
        }
        if (iz != null) {
            if (iz.dato >= i && iz.dato <= j) {
                iz.NodosRango = this.NodosRango;
                iz.rango(i, j);
            }
        }
        if (der != null) {
            if (der.dato >= i && der.dato <= j) {
                der.NodosRango = this.NodosRango;
                der.rango(i, j);
            }
        }
        return NodosRango;
    }
}