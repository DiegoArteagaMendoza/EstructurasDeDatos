import javax.print.attribute.standard.NumberOfDocuments;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Stack<ArbolBinario> nodos=new Stack<>();
        for (int i = 0; i < 10; i++) {
            nodos.add(new ArbolBinario(i));
        }
        //voy emparejando de a dos nodos para construir el árbol
        while(nodos.size()>1){
            ArbolBinario iz=nodos.pop();
            ArbolBinario der=nodos.pop();
            nodos.push(new ArbolBinario(iz.dato+der.dato,iz,der));
        }
        ArbolBinario raiz=nodos.pop();
        System.out.println("Altura del arbol: "+raiz.altura());
        System.out.println("Tamaño del arbol (total de nodos): "+ raiz.size());
        raiz.tree();

        ArbolBinario[] nodos2=new ArbolBinario[32];
        for (int i = 0; i < nodos2.length; i++) {
            nodos2[i]=new ArbolBinario(i);
        }
        ArbolBinario raiz2=generaBinario(nodos2, 0, 31);
        System.out.println("Altura del arbol: "+raiz2.altura());
        System.out.println("Tamaño del arbol (total de nodos): "+ raiz2.size());
        raiz2.tree();

        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese el rango i: "); int Rangoi = teclado.nextInt();
        System.out.print("Ingrese el rango j: "); int Rangoj = teclado.nextInt();

        LinkedList<ArbolBinario> nodosRango1 = raiz.rango(Rangoi,Rangoj);
        System.out.println("Nodos pretenecientes a la raiz del rango 1");
        for (ArbolBinario r : nodosRango1) {
            System.out.println(r.dato);
        }
        LinkedList<ArbolBinario> nodosRango2 = raiz2.rango(Rangoi,Rangoj);
        System.out.println("Nodos pretenecientes a la raiz del rango 2");
        for (ArbolBinario r : nodosRango2) {
            System.out.println(r.dato);
        }
    }

    public static ArbolBinario generaBinario(ArbolBinario[] nodos, int i, int j){
        if(i>j){
            //caso base
            return null;
        }
        int mitad=(i+j)/2;
        nodos[mitad].iz=generaBinario(nodos, i,mitad-1);
        nodos[mitad].der=generaBinario(nodos,mitad+1,j);
        return nodos[mitad];
    }
}
