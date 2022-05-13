import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class TestMain {
	public static void main(String[] args) {
		
		BSTree b = new BSTree();
		AvlTree a = new AvlTree();
		int n = 10000; //no puede usarse 100.000, ya que da error stackOverflow


		//busqueda sin inserción
		/*

			se realiza primero la busqueda sin incersión, ya que asi no se tienen datos ingresados en BST o en AVL

		*/
		System.out.println("\nBusqueda sin inserción");

		long statTimeA3 = System.nanoTime();
		long statTimeB3 = System.nanoTime();

		for (int i = 0; i < n; i++) {
			a.search(i);
			b.search(i);
		}

		long finishTimeA3 = System.nanoTime() - statTimeA3;
		System.out.println("AvlTree: " + finishTimeA3 + " ns");
		long finishTimeb3 = System.nanoTime() - statTimeB3;
		System.out.println("BSTree: " + finishTimeb3 + " ns");

		//insercion
		/*

			se realiza primero el llenado de una matris con la cantidad de numeros indicados en n (10000) para luego ingresarlos mediante el insert

		*/
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i+1;
		}

		System.out.println("\nInserción");

		long StartTimeB = System.nanoTime();
		long StartTimeA = System.nanoTime();

		for (int i = 0; i < arr.length; i++) {
			a.insert(arr[i]);
			b.insert(arr[i]);
		}

		long finishTimeB = System.nanoTime() - StartTimeB;
		System.out.println("BSTree: " + finishTimeB + " ns");
		long finishTimeA = System.nanoTime() - StartTimeA;
		System.out.println("AvlTree: " + finishTimeA + " ns");


		//busqueda
		/*

			se realiza la busqueda con los datos ya ingresados al final par apoder tener el tiempo en cual ya estan ingresados

		*/
		System.out.println("\nBusqueda");

		long statTimeA2 = System.nanoTime();
		long statTimeB2 = System.nanoTime();

		for (int i = 0; i < n; i++) {
			a.search(i);
			b.search(i);
		}

		long finishTimeA2 = System.nanoTime() - statTimeA2;
		System.out.println("AvlTree: " + finishTimeA2 + " ns");
		long finishTimeb2 = System.nanoTime() - statTimeB2;
		System.out.println("BSTree: " + finishTimeb2 + " ns");
	}
}
