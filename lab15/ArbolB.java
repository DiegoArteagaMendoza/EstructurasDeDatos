class ArbolB {
  NodoArbolB root;
  int t;// grado mínimo
  // Constructor--CREATE()

  ArbolB(int gradoMinimo) {
    t = gradoMinimo;
    root = new NodoArbolB(t); // ALLOCATE-NODE()
    // DISK-WRITE(root);
  }

  // ---------
  // Busqueda
  result Search(int k) {
    return search(root, k);
  }

  // -----------------------
  // Inserción de una clave
  void Insert(int k) {
    NodoArbolB r = root;
    if (r.n == 2 * t - 1) {
      NodoArbolB s = new NodoArbolB(t);
      root = s;
      s.leaf = false;
      s.n = 0;
      s.c[0] = r;
      splitChild(s, 0, r);
      insertnotFull(s, k);
    } else
      insertnotFull(r, k);
  }

  // -------------------------
  // Eliminación de una clave
  // Suponemos que la clave existe en el arbol B
  public void Delete(int k) {
    root = delete(root, k);
  }

  public void Imprimir() {
    if (root == null)
      System.out.println("Arbol Vacio");
    else
      imprimir(" ", root);
  }

  public int Minimo() {
    if (root == null)
      return -1; // Suponemos las claves positivas
    else
      return minimo(root);
  }

  // ---- metodos privados-------------
  // -----------------------------------
  private int minimo(NodoArbolB n) {
    if (n.c[0] == null)
      return n.key[0];
    else
      return minimo(n.c[0]);
  }

  private result search(NodoArbolB x, int k) {
    int i = 0;
    while (i < x.n && k > x.key[i])
      i++;
    if (i <= x.n && k == x.key[i])
      return search(x, i);
    if (x.leaf)
      return search(null, -1);
    else {
      // DISK-READ(x.c[i])
      return search(x.c[i], k);
    }
  }

  void insertnotFull(NodoArbolB x, int k) {
    int i = x.n - 1;
    if (x.leaf) {
      while (i >= 0 && k < x.key[i]) {
        x.key[i + 1] = x.key[i];
        i--;
      }
      x.key[i + 1] = k;
      x.n++;
      // DISK-WRITE(x)
    } else {
      while (i >= 0 && k < x.key[i])
        i--;
      i++;
      // DISK-READ(x.c[i])
      if (x.c[i].n == 2 * t - 1) {
        splitChild(x, i, x.c[i]);
        if (k > x.key[i])
          i++;
      }
      insertnotFull(x.c[i], k);
    }
  }

  // ---SPLIT de un nodo
  private void splitChild(NodoArbolB x, int i, NodoArbolB y) {
    NodoArbolB z = new NodoArbolB(t);
    z.leaf = y.leaf;
    z.n = t - 1;
    for (int j = 0; j < t - 1; j++)
      z.key[j] = y.key[j + t];
    if (!y.leaf)
      for (int j = 0; j < t; j++)
        z.c[j] = y.c[j + t];
    y.n = t - 1;
    for (int j = x.n; j == i + 1; j--)
      x.c[j + 1] = x.c[j];
    x.c[i + 1] = z;
    for (int j = x.n - 1; j == i; j--)
      x.key[j + 1] = x.key[j];
    x.key[i] = y.key[t - 1];
    x.n++;
    // DISK-WRITE(y)
    // DISK-WRITE(X)
    // DISK-WRITE(Y)
  }

  private void imprimir(String d, NodoArbolB p) {
    if (p != null) {
      int i;
      p.Imprimir(d);
      System.out.println();
      for (i = 0; i <= p.n; i++)
        imprimir(" " + d, p.c[i]);
    }
  }

  private NodoArbolB delete(NodoArbolB x, int k) {
    int i = 0;
    while (i < x.n && k > x.key[i])
      i++;
    if (i <= x.n && k == x.key[i]) {
      if (x.leaf) {
        System.out.println("Hoja");
        for (int j = i; j < x.n - 1; j++)
          x.key[j] = x.key[j + 1];
        x.n--;
        return x;
      } else
        return x;
    }
    return x;
  }

  // Funcion que define el % de utilizssacion del arbol
  /*
   * 1. saber cuantos nodos totales tiene el arbol
   * 2. saber cuantos nodos estan siendo utilizados
   * 3. realizar el calculo con regla de 3
   */
  public double utilizacion() {
    int totalNodes = t;
    int usedNodes = root.key.length;
    double porcentUsed = 0;
    porcentUsed = (usedNodes * 100) / totalNodes;
    return porcentUsed;
  }

  //Funcion size que retorna la cantidad de valores que el arbol B contiene
  public int size() {
    int size = 0;
    for (int i = 0; i < root.c.length; i++) {
      if (root.c[i] != null) {
        size += root.c[i].key.length;
      }
    }
    return size;
  }

}// end clase ArbolB
