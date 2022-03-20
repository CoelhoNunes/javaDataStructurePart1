/******************************************************************************************* 
Purpose/Description: Sorting an array of integer that include duplicate elements. Methods
include a sub-linear running time complexity to find the number of occurrences of the input.
*******************************************************************************************/

package dataStructure_A1;

import java.util.*;

public class sortedArray {
	
	// Creating the function that is going to count the frequency
	static int freq(int A[], int x, int y) {
	
	/*
	 * Extracting the functions called to find the start/end index from
	 * elements, which frequency is going to be found within the given
	 * array. Then returning the different once calculated (lines 26 - 34)
	 */
		
		int first, last;
		first = startIndex(A, 0, y - 1, x, y);
		
		if(first == - 1)
			return first;

		last = endIndex(A, first, y - 1, x, y);
		
		return last - first + 1;
	}
	
	// Establishing the starting index
	static int startIndex(int a[], int low, int high, int x, int y) {
	
	/*
	 * Loop for the stating index if integer is greater than of equal to 
	 * the start index
	 */
		
		if(high >= low) {
			
			int middle = (low + high)/2;
			
			if ((middle == 0 || x > a[middle - 1]) && a[middle] == x)
				return middle;
			
			else if(x > a[middle])
				return startIndex(a,(middle + 1), high, x, y);
			else
				return startIndex(a, low, (middle -1), x, y);
		}
		return -1;
	}
	
	// Establishing the ending index
	static int endIndex(int b[], int low, int high, int x, int y) {
		
	/*
	 * Loop for the stating index if integer is greater than of equal to 
	 * the end index
	*/
		if(high >= low) {
			
			int middle = (low + high)/2;
			if((middle == y - 1 || x < b[middle + 1]) && b[middle] == x)
				return middle;
			else if(x < b[middle])
				return endIndex(b, low, (middle - 1), x, y);
			else
				return endIndex(b, (middle + 1), high, x, y);
		}
		return -1;
	}
	
	public static void main(String args[]) {
		
	/*
	 * Asking the user to input the number of elements inside the array,
	 * and also asking which number has the highest frequency within that set. From
	 * the information given from the user, the program then returns the frequency
	 * (lines 90 - 107). 
	 */
		
		try (Scanner scan = new Scanner(System.in)) {
			System.out.println("Input the elements in the given array: ");
			
			int y;
			y = scan.nextInt();
			int[] a = new int[y];
			int b;
			
			for(int w = 0; w < y; w++) {
				System.out.printf("Enter the %d element of the array: ", w +1);
				b = scan.nextInt();
				a[w] = b;
			}
			
			int x;
			System.out.println("Enter the element whose Frequency is to be found: ");
			x = scan.nextInt();
			int number = freq(a, x, y);
			System.out.printf("Frequency of %d is: %d", x, number);
		}
	}
}

/********* Program output *********
 * ------------------------------------------------------
	Input the elements in the given array: 
	9
	Enter the 1 element of the array: -1
	Enter the 2 element of the array: 2
	Enter the 3 element of the array: 3
	Enter the 4 element of the array: 5
	Enter the 5 element of the array: 6
	Enter the 6 element of the array: 6
	Enter the 7 element of the array: 6
	Enter the 8 element of the array: 9
	Enter the 9 element of the array: 10
	Enter the element whose Frequency is to be found: 
	6
	Frequency of 6 is: 3
 *  ------------------------------------------------------ 
*/
