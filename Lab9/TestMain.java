import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		//definir arboles de AVL y BST
			//AVL
		AvlTree avlTree = new AvlTree();
			//BST
		BSTree bsTree = new BSTree();

		//definir las listas para los datos
			//datos ingresados
		List<Integer> datosIngresados = new ArrayList<>();
			//datos no ingresados
		List<Integer> datosNoIngresados = new ArrayList<>();

		//Almacenamiento de los tiempos
		long[][] tiempos = new long[3][2];

		//tiempos
		long StarTime = 0;
		long FinishTime = 0;

		//Agregar datos a la lista 
		for (int i = 0; i < 100000; i++) {
			datosIngresados.add(i);
			datosNoIngresados.add(i+1);
		}

		//Desordenar los datos ingresados
		Collections.shuffle(datosIngresados);
		Collections.shuffle(datosNoIngresados);


		//Insecion de 100 mil datos AVL
		StarTime = System.nanoTime();
		for (int i = 0; i < datosIngresados.size(); i++) {
			avlTree.insert(datosIngresados.get(i));
		}
		FinishTime = System.nanoTime() - StarTime;
		tiempos[0][0] = FinishTime;

		//Insecion de 100 mil datos BST
		StarTime = System.nanoTime();
		for (int i = 0; i < datosIngresados.size(); i++) {
			bsTree.insert(datosIngresados.get(i));
		}
		FinishTime = System.nanoTime() - StarTime;
		tiempos[0][1] = FinishTime;

		//Busqueda de datos ingresados AVL
		StarTime = System.nanoTime();
		for (int i = 0; i < datosIngresados.size(); i++) {
			avlTree.search(datosIngresados.get(i));
		}
		FinishTime = System.nanoTime() - StarTime;
		tiempos[1][0] = FinishTime;

		//Busqueda de datos ingesados en BST
		StarTime = System.nanoTime();
		for (int i = 0; i < datosIngresados.size(); i++) {
			bsTree.search(datosIngresados.get(i));
		}
		FinishTime = System.nanoTime() - StarTime;
		tiempos[1][1] = FinishTime;

		//Busqeuda de datos no ingresados en AVL
		StarTime = System.nanoTime();
		for (int i = 0; i < datosNoIngresados.size(); i++) {
			avlTree.search(datosNoIngresados.get(i));
		}
		FinishTime = System.nanoTime() - StarTime;
		tiempos[2][0] = FinishTime;

		//Busqueda de datos no ingresados BST
		StarTime = System.nanoTime();
		for (int i = 0; i < datosNoIngresados.size(); i++) {
			bsTree.search(datosNoIngresados.get(i));
		}
		FinishTime = System.nanoTime() - StarTime;
		tiempos[2][1] = FinishTime;


		System.out.println("Tiempo inserción \n\tAVL: " + tiempos[0][0] + "\n\tBST: " + tiempos[0][1]);
		System.out.println("Tiempo busqueda \n\tAVL: " + tiempos[1][0] + "\n\tBST: " + tiempos[1][1]);
		System.out.println("Tiempo busqueda sin datos \n\tAVL: " + tiempos[2][0] + "\n\tBST: " + tiempos[2][1]);
	}
}