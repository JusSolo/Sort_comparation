/**
 * 
 */
//Este algoritmo ha sido obtenido de https://www.geeksforgeeks.org/java-program-for-gnome-sort/.
/**
 * @author aripi
 *
 */
public class GnomeSort {

	 
	import java.util.Arrays;
	public class GFG {
	 static void gnomeSort(int arr[], int n)
	 {
	  int index = 0;
	 
	  while (index < n) {
	   if (index == 0)
	    index++;
	   if (arr[index] >= arr[index - 1])
	    index++;
	   else {
	    int temp = 0;
	    temp = arr[index];
	    arr[index] = arr[index - 1];
	    arr[index - 1] = temp;
	    index--;
	   }
	  }
	  return;
	 }
	 
	 
	 public static void main(String[] args)
	 {
	  int arr[] = { 34, 2, 10, -9 };
	 
	  gnomeSort(arr, arr.length);
	 
	  System.out.println(Arrays.toString(arr));
	 }
	}
	 
	// Code Contributed by Mohit Gupta_OMG
	/**
	 * 
	 */
	public GnomeSort() {
		// TODO Auto-generated constructor stub
	}

}
