import java.util.Arrays;
import java.util.Random;

public class Sorting {

	public static int[] fillArray(int n) {
		int[] array = new int[n];
		Random rnd = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rnd.nextInt(n * 10);
		}
		return array;
	}

	public static void bubbleSort(int array[]) {
		int n = array.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					// swap arr[j+1] and arr[j]
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void merge(int array[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = array[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = array[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				array[k] = L[i];
				i++;
			} else {
				array[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			array[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			array[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	public static void sort(int array[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = l + (r - l) / 2;

			// Sort first and second halves
			sort(array, l, m);
			sort(array, m + 1, r);

			// Merge the sorted halves
			merge(array, l, m, r);
		}
	}
	
	public static void mergeSort(int array[]) {
		sort(array, 0, array.length - 1);
	}
	
	public static void print(int array[]) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	

	public static void main(String[] args) {
		//tamaño de los datos a trabajar
        int datos[] = new int [9];
        datos[0] = 1000;
        datos[1] = 5000;
        datos[2] = 10000;
        datos[3] = 50000;
        datos[4] = 100000;
        datos[5] = 1000000;
        datos[6] = 5000000;
        datos[7] = 10000000;
        datos[8] = 50000000;

		
		long data[][] = new long[9][3];
        
        System.out.println("BubbleSort\tMergeSort\tJavaSort");

        for (int i = 0; i < datos.length; i ++) {
            int arr1[] = fillArray(datos[i]);
            int arr2[] = fillArray(datos[i]);
            
            int arr1_1[] = arr1.clone();
            int arr2_1[] = arr2.clone();
            int arr1_2[] = arr1.clone();
            int arr2_2[] = arr2.clone();
            
            long startTime = System.nanoTime();
            if (datos[i] <= 100000) {
                bubbleSort(arr1);
                long finishTime = System.nanoTime() - startTime;
                data[0][0] = finishTime;
                
                startTime = System.nanoTime();
                bubbleSort(arr2);
                finishTime = System.nanoTime() - startTime;
                data[0][0] = (data[0][0]+finishTime) / 2;
            } else {
                data[0][0] = 0;
            }
            
            startTime = System.nanoTime();
            mergeSort(arr1_1);
            long finishTime = System.nanoTime() - startTime;
            data[0][1] = finishTime;
            
            startTime = System.nanoTime();
            mergeSort(arr2_1);
            finishTime = System.nanoTime() - startTime;
            data[0][1] = (data[0][1]+finishTime) / 2;
            
            startTime = System.nanoTime();
            Arrays.sort(arr1_2);
            finishTime = System.nanoTime() - startTime;
            data[0][2] = finishTime;
            
            startTime = System.nanoTime();
            Arrays.sort(arr2_2);
            finishTime = System.nanoTime() - startTime;
            data[0][2] = (data[0][2]+finishTime) / 2;

            System.out.println(data[0][0] + "\t" + data[0][1] + "\t" + data[0][2]);

            if (datos[i] > 50000000) {
                System.out.println("Proceso finalizado");
            }
        }
		
		// int arr1[] = fillArray(1000);
		// int arr2[] = fillArray(1000);
		
		// int arr1_1[] = arr1.clone();
		// int arr2_1[] = arr2.clone();
		// int arr1_2[] = arr1.clone();
		// int arr2_2[] = arr2.clone();
		
		// long startTime = System.nanoTime();
		// bubbleSort(arr1);
		// long finishTime = System.nanoTime() - startTime;
		// data[0][0] = finishTime;
		
		// startTime = System.nanoTime();
		// bubbleSort(arr2);
		// finishTime = System.nanoTime() - startTime;
		// data[0][0] = (data[0][0]+finishTime) / 2;
		
		// startTime = System.nanoTime();
		// mergeSort(arr1_1);
		// finishTime = System.nanoTime() - startTime;
		// data[0][1] = finishTime;
		
		// startTime = System.nanoTime();
		// mergeSort(arr2_1);
		// finishTime = System.nanoTime() - startTime;
		// data[0][1] = (data[0][1]+finishTime) / 2;
		
		// startTime = System.nanoTime();
		// Arrays.sort(arr1_2);
		// finishTime = System.nanoTime() - startTime;
		// data[0][2] = finishTime;
		
		// startTime = System.nanoTime();
		// Arrays.sort(arr2_2);
		// finishTime = System.nanoTime() - startTime;
		// data[0][2] = (data[0][2]+finishTime) / 2;
		
		// System.out.println(data[0][0] + " " + data[0][1] + " " + data[0][2]);
	}

}