public class TestLista {
    public static void main(String [] args) {
		Lista l = new Lista();
		System.out.println("�Vac�a?: " + l.EstaVacia());
		System.out.println("\nSize: " + l.Size());
		l.InsertaInicio(12);
		System.out.println("�Vac�a?: " + l.EstaVacia());
		System.out.println("\nSize: " + l.Size());
		l.Print();
		l.InsertaInicio(32);
		System.out.println("\nSize: " + l.Size());
		l.Print();
		l.InsertaFinal(51);
		System.out.println("\nSize: " + l.Size());
		l.Print();
		l.Eliminar(12);
		System.out.println("\nSize: " + l.Size());
		l.Print();
		l.Eliminar(32);
		System.out.println("\nSize: " + l.Size());
		l.Print();
		l.Eliminar(51);
		System.out.println("\nSize: " + l.Size());
		System.out.println("�Vac�a?: " + l.EstaVacia());
	}
}
