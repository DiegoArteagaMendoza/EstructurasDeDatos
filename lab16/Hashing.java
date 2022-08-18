public class Hashing {
	
	class Nodo{
		int key;
		public Nodo(int k) {
			key = k;
		}
	}

	Nodo [] T;
	
	public Hashing(int m) {
		T = new Nodo[m];
		for(int i = 0; i < m; i++) T[i] = null;
	}
	
	// Implementar
	// return true si fue posible insertar
	// false en otro caso
	public boolean insertar(int k) {
		int i = k % T.length;
		while(T[i] != null) {
			i = (i + 1) % T.length;
		}
		if (T[i] == null) {
			T[i] = new Nodo(k);
			return true;
		} else {
			return false;
		}
	}
	
	// Implementar
	// Si la clave no existe, return null
	public Nodo buscar(int key) {
		int i = key % T.length;
		while(T[i] != null) {
			if (T[i].key == key) {
				return T[i];
			}
			i = (i + 1) % T.length;
		}
		return null;
	}
	
	// Implementar
	// return true si fue posible eliminar
	// false en otro caso
	public boolean eliminar(int key) {
		int i = key % T.length;
		while(T[i] != null) {
			if (T[i].key == key) {
				T[i] = null;;
				return true;
			}
		}
		return false;
	}
	
	
	int h(int k, int i) {
		return (h1(k) + (i * h2(k))) % T.length;
	}
	
	int h1(int k) {
		return k % T.length;
	}
	
	int h2(int k) {
		return 1 + (k % (T.length-1));
	}
	
	public static void main(String[] args) {

		System.out.println("\n INSERTAR");

		Hashing h = new Hashing(10);
		boolean chek = h.insertar(1);
		boolean chek2 = h.insertar(2);
		boolean chek3 = h.insertar(3);

		if (chek && chek2 && chek3) {
			System.out.println("Se insertaron 3 elementos");
		} else {
			System.out.println("No se pudieron insertar 3 elementos");
		}

		System.out.println("\n BUSCANDO");

		Nodo n = h.buscar(1);
		System.out.println("Nodo: " + n.key);
		n = h.buscar(10);
		if (n == null) {
			System.out.println("No se encontro el nodo");
		} else {
			System.out.println("Nodo: " + n.key);
		}
		n = h.buscar(2);
		System.out.println("Nodo: " + n.key);
		n = h.buscar(3);
		System.out.println("Nodo: " + n.key);

		System.out.println("\n ELIMINANDO");

		boolean e = h.eliminar(1);
		if (e) {
			System.out.println("Se elimino el nodo");
		} else {
			System.out.println("No se pudo eliminar el nodo");
		}
	}

}
