import java.util.Comparator;
//Algoritmo obtenido del libro Java Structures: Data Structures for the Principle Programmer.
/**
 * 
 */

/**
 *
 *
 */
public class Quicksort {
	private static int partition(int Lista1[], int primero, int ultimo)
	
	{
	while (true)
	{
	
	while (primero < ultimo && Lista1[primero] < Lista1[ultimo]) ultimo--;
	if (primero < ultimo) swap(Lista1,primero++,ultimo);
	else return primero;

	while (primero < ultimo && Lista1[primero] < Lista1[ultimo]) primero++;
	if (primero < ultimo) swap(Lista1,primero,ultimo--);
	else return ultimo;
	}
	}

	private static void swap(int[] lista1, int i, int ultimo) {
		// TODO Auto-generated method stub
		
	}

	public static void quicksort(int[]Lista1, int n ) {
	quickSortRecursive(Lista1, 0, n-1);
	}
	private static void quickSortRecursive(int Lista1, int primero, int ultimo) {
		int pivote;
		if (primero >= ultimo)return;
			pivote = partition(Lista1,primero,ultimo); 
			quickSortRecursive(Lista1,primero,pivote-1); 
			quickSortRecursive(Lista1,pivote+1,ultimo);
	}
	/**
	 * 
	 */
	public Quicksort() {
		// TODO Auto-generated constructor stub
	}

}
