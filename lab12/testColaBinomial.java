//Diego Arteaga
//Sebastian Jouannet

// ------ EXPLICACION MINHEAP TO MAXHEAP ------
/*
Al usar la funcion BinomialHeapUnion (Clase ColaBinomial.java), 
en el primer else (linea 73), se ve la comparación de valores 
entre las claves del presente y el siguiente, la cual dice que si 
el presente es menor, el hermano de este pasa a ser el
siguiente, probocando un minHeap, en cambio, para realizar
un maxHeap, tenemos que validar si el presente es mayor que 
el siguiente, si se da esto, el presente queda primero,
y en caso contrario el siguiente queda primero, de esta manera
el arbol en ves de quedar con el menor dato en la parte 
superior, queda el mayor en esta.
*/ 

class testColaBinomial{
	public static void main(String[] args)
	{
		int a[] = {12, 17,2,4,5,6,22,21,29,32, 40, 45,3, 54, 65};
		ColaBinomial b = new ColaBinomial();
		for (int i=0; i < a.length;  i++) b.Insert(a[i]);
		b.Print();
		int max = b.Max();
		System.out.println(max);
	} 
}
