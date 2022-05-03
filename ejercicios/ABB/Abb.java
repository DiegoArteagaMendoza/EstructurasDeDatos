import java.util.LinkedList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carola
 */
public class Abb {
	class NodoAbb {
		int elemento;
		NodoAbb lchild;
		NodoAbb rchild;

		NodoAbb(int elemento, NodoAbb lchild, NodoAbb rchild) {
			this.elemento = elemento;
			this.lchild = lchild;
			this.rchild = rchild;
		}

		void Print() {
			System.out.println(elemento);
		}
	}

	private NodoAbb laRaiz;

	public Abb() {
		laRaiz = null;
	}

	//funcion de busqueda
	public boolean busqueda(NodoAbb laRaiz, int x) {
		if (laRaiz==null) return false;
		if (laRaiz.elemento == x) return true;
		
		//if(laRaiz != null) {
        if (x < laRaiz.elemento) {
			busqueda(laRaiz.lchild, x);
		} else {
			busqueda(laRaiz.rchild, x);
				// if (x > laRaiz.elemento) {
				// 	busqueda(laRaiz.rchild, x);
				// }
		}
        //}
		return false;
	}

	//inorder
	LinkedList<Integer> nodoList = new LinkedList<Integer>();
    
    public void inorder(NodoAbb node) {
        if(node != null) {
            inorder(node.lchild);
            nodoList.add(node.elemento);
            inorder(node.rchild);
        }
    }
	
	 /* Verifica si existen dos enteros a, b en el ABB tal que a+b =0. 
	  */
	public boolean Complemento() {
		if (comple(laRaiz) == true) return true;
		if (comple(laRaiz) == false) return false;
		return false;
		//return comple(laRaiz);
	}

	private boolean comple(NodoAbb n) {
		NodoAbb x = laRaiz;
		// for(NodoAbb a: ) {
		// 	boolean chek = busqueda(laRaiz, -n.elemento);
		// 	if (chek == true) return true;
		// }
		while (laRaiz != null) {
			boolean chek = busqueda(laRaiz, -n.elemento);
			if (chek == true) return true;
			//if (chek == false) return false;
		}
		return false;
	}
	
	//--- Supone que no existe un nodo con valor = elemento----//
	public void Insertar(int elemento) {
		laRaiz = InsertaenAbb(laRaiz, elemento);
	}
	
	private NodoAbb InsertaenAbb(NodoAbb nodo, int elemento) {
		if (nodo == null)
			return new NodoAbb(elemento, null, null);
		else if (elemento < nodo.elemento)
			nodo.lchild = InsertaenAbb(nodo.lchild, elemento);
		else
			nodo.rchild = InsertaenAbb(nodo.rchild, elemento);
		return nodo;
	}
	
	// -- Supone que el elemento esta en el arbol----//
	public void Eliminar(int elemento) {
		laRaiz = EliminaenAbb(laRaiz, elemento);
	}
	
	private NodoAbb EliminaenAbb(NodoAbb nodo, int elemento) {
		if (nodo.elemento == elemento) {
			if (nodo.lchild == null && nodo.rchild == null)
				return null;
			else if (nodo.lchild == null)
				return nodo.rchild;
			else if (nodo.rchild == null)
				return nodo.lchild;
			else {
				nodo.elemento = MayorElemento(nodo.lchild);
				nodo.lchild = EliminaenAbb(nodo.lchild, nodo.elemento);
			}
		} else if (nodo.elemento > elemento)
			nodo.lchild = EliminaenAbb(nodo.lchild, elemento);
		else
			nodo.rchild = EliminaenAbb(nodo.rchild, elemento);
		return nodo;
	}

	private int MayorElemento(NodoAbb nodo) {
		if (nodo.rchild == null)
			return nodo.elemento;
		else
			return MayorElemento(nodo.rchild);
	}

	public void Imprimir() {
		ImprimeAbb(laRaiz, " ");
	}

	private void ImprimeAbb(NodoAbb n, String tab) {
		if (n != null) {
			System.out.println(tab + n.elemento);
			ImprimeAbb(n.lchild, tab + "  ");
			ImprimeAbb(n.rchild, tab + "  ");
		}
	}

	

	

	
}
