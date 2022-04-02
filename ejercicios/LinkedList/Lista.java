public class Lista { 
    private Nodo header;
    Lista() { 
        header = null;
    } 
    //---Inserta un objeto(int) al comienzo de la lista
    public void InsertaInicio(int o) {
     if (EstaVacia()) header=new Nodo(o, null);
     else  header = new Nodo(o, header);
   }
   
   //---- Inserta al final ----
   public void InsertaFinal(int o) {
     if (EstaVacia()) header=new Nodo(o, null);
      else{
            Nodo t;
            for(t = header; t.next != null; t= t.next) ;;
            t.next = new Nodo(o,null);
        }
    }
   
   // ---cuenta la cantidad de nodos de la lista (Size)
   public int Size() {
    int tnodos=0;
    for(Nodo t = header; t !=null; t= t.next)  tnodos++;
    return tnodos;
   }
   
   //eliminar un nodo de la lista 
   // Elimina el primer nodo n tal que o.elObjeto==o 
   public void Eliminar(int o) { 
    if(!EstaVacia()) { 
     if(header.elObjeto==o) header = header.next;
      else { 
        Nodo p = header;
        Nodo t = header.next; 
        while (t !=null && t.elObjeto != o)  { 
         p = t ; t = t.next;
        } 
        if(t.elObjeto==o) p.next = t.next;
       }
    }
   }
   
   // Verifica si la lista está vacias;
   public boolean EstaVacia() {
   return header == null;
   }
   
   //-----Imprime la lista-----
   void Print() {
      if(header!=null) Imprimir(header);
       else System.out.println("Lista Vacia");
       }
   
    void Imprimir(Nodo m ) {
       if(m !=null) {m.Print(); Imprimir(m.next);}
     }
   
   //-----Clase Nodo--------- 
    private class Nodo { 
     public int elObjeto;
     public Nodo next;
     public Nodo(int nuevoObjeto, Nodo next)
     {this.elObjeto=nuevoObjeto; this.next = next;} 
     void Print(){ System.out.print("- " + elObjeto);}
    }
   
}