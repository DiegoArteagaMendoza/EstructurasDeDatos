import java.util.Arrays;

public class MaxHeap {

	private int length = 10;
	private int size = 0;
	private int [] items = new int[length];
	
	public MaxHeap() {
		
	}
	
	public MaxHeap(int [] A) {
		// Build heap
		items = A;
		size = A.length;
		length = A.length;
		buildHeap();
		
		duplicateCapacity();
	}
	
	public void printHeap() {
		for(int i = 0; i< size; i++) {
			System.out.print(items[i] + " ");
		}
		System.out.println();
	}
	
	public void insert(int item) {
		// insert a new element
		duplicateCapacity();
		items[size] = item;
		size++;
		heapifyUp(size-1);
	}
	
	public int top() {
		// get items[0]
		if(size > 0)	return items[0];
		else return -1;
	}
	
	public int delete() {
		// get items[0] and delete it
		if(size > 0) {
			int item = items[0];
			items[0] = items[size-1];
			size--;
			heapify(0);
			return item;
		}
		return -1;
	}
	
	private void duplicateCapacity(){
		// duplicate the capacity of the array
		if(size == length) {
			items = Arrays.copyOf(items, length*2);
			length *= 2;
		}
	}
	
	private void heapifyUp(int i) {
		int parent = parent(i);
		if (items[i] > items[parent]) {
			swap(i, parent);
			heapifyUp(parent);
		}
		// Adjust element i to the correspond pos
		// Implementar esta función
	}
	
	private void heapify(int i) {
		if (esHoja(i) == true) {
			return;
		}
		int left = leftChild(i), right = rightChild(i);
		if (items[i] < items[left] || items[i] < items[right]) {
			int largest = 0;
			if(left<= size && items[left] > items[i]){
				largest = left;
			}else{
				largest = i;
			}
			if(right<= size && items[right] > items[largest]){
				largest = right;
			}
			if(largest != i){
				swap(i, largest);
			}
			heapify(largest);

		}
		// Adjust element i to the correspond pos
		// Sección implementada por sección del miércoles.
	}

	//funcion privada para saber si esta o no dentro de los datos como hoja
	private boolean esHoja(int p) {
		if (p > (size/2) && p <= size) {
			return true;
		}
		return false;
	}
	
	private void buildHeap() {
		// Given an array, get the heap
		for(int i = size/2; i >= 0; i--) {
			heapify(i);
		}
	}
	
	private int parent(int i) {
		return (i-1)/2;
	}
	private int leftChild(int i) {
		return 2*i+1;
	}
	private int rightChild(int i) {
		return 2*i+2;
	}
	private void swap(int i, int j) {
		int temp = items[i];
		items[i] = items[j];
		items[j] = temp;
	}
	
	public static void main(String[] args) {
		System.out.println("Heap: ");
		MaxHeap mh = new MaxHeap();
		mh.insert(3);
		mh.insert(1);
		mh.insert(12);
		mh.insert(9);
		mh.insert(55);
		mh.insert(10);
		mh.buildHeap();
		mh.printHeap();
	}
}
