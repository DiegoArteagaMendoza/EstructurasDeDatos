package hashing;

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
	public boolean insertar(int key) {
		return false;
	}
	
	// Implementar
	// Si la clave no existe, return null
	public Nodo buscar(int key) {
		return null;
	}
	
	// Implementar
	// return true si fue posible eliminar
	// false en otro caso
	public boolean eliminar(int key) {
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
	
}
