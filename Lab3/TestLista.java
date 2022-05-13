import java.util.Scanner;
public class TestLista {
    public static void main(String [] args) {
		Lista l = new Lista();
		Scanner tec = new Scanner(System.in);
		int date;
		do {
			System.out.print("Ingrese un numero para la lista o ponga 0 para salir: ");
			date = tec.nextInt();
			if (date != 0) {
				l.InsertaFinal(date);
				System.out.println("Tamaño de la lista: " + l.Size());
			}
		} while (date != 0);

		/*System.out.println("La lista esta vacia?: " + l.EstaVacia());
		System.out.println("Size: " + l.Size());
		l.InsertaInicio(1);
		System.out.println("La lista esta vacia?: " + l.EstaVacia());
		System.out.println("Size: " + l.Size());
		l.InsertaInicio(2);
		System.out.println("Size: " + l.Size());
		l.InsertaFinal(3);
		System.out.println("Size: " + l.Size());
		l.InsertaFinal(4);
		System.out.println("Size: " + l.Size());
		l.InsertaFinal(5);
		System.out.println("Size: " + l.Size());
		l.InsertaFinal(6);
		System.out.println("Size: " + l.Size());
		l.InsertaFinal(7);
		System.out.println("Size: " + l.Size());
		l.InsertaFinal(8);
		System.out.println("Size: " + l.Size());
		l.InsertaFinal(9);
		System.out.println("Size: " + l.Size());
		l.InsertaFinal(10);
		System.out.println("Size: " + l.Size());*/

		//enviar lista al promedio
		int prom = l.Promedio();
		System.out.println("\nEL PROMEDIO ES: " + prom + "\n");
		
		Lista lista = l.getMayores();
		lista.Print();

		/*int[] mayoresOrdenados = l.getMayores();
		if (mayoresOrdenados != null) {
			System.out.println("Lista ordenada");
			for (int i = 0; i < mayoresOrdenados.length; i++) {
				if (mayoresOrdenados[i] != 0) {
					System.out.println(mayoresOrdenados[i]);
				}
			}
		}*/

		/*l.Print();
		l.Eliminar(12);
		System.out.println("\nSize: " + l.Size());
		l.Print();
		l.Eliminar(32);
		System.out.println("\nSize: " + l.Size());
		l.Print();
		l.Eliminar(51);
		System.out.println("\nSize: " + l.Size());
		System.out.println("�Vac�a?: " + l.EstaVacia());*/
	}
}
