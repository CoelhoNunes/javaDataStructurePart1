/******************************************************************************************* 
Purpose/Description: Implementing a sub-linear running time complexity program with the given
array, that determines whether a given integer is in the array. 
*******************************************************************************************/

package dataStructure_A1;
import java.util.Scanner;

public class recursiveFunction{
	
	/*
	 * A loop is created in finding the increasing and decreasing positions
	 * in the given array (left and right) and counted through a binary search (Lines 21 - 50) 
	 */
	
	private static int increase(int array[], int low, int high, int key) {
		
		while (low <= high) {
			int middle = low + (high - low)/2;
			
			if(array[middle] == key)
				return middle;
			
			if(array[middle] > key)
				high = middle - 1;
			else
				low = middle + 1;
		}
		return -1;	
	}
	
	private static int decrease(int array[], int low, int high, int key) {
		
		while (low <= high) {
			int middle = low + (high - low)/2;
			
			if(array[middle] == key)
				return middle;
			
			if(array[middle] < key)
				high = middle - 1;
			else
				low = middle + 1;
		}
		return -1;
	}
	
	// Loop in finding the max number within the array
	private static int findingMax(int array[], int left, int right) {
		
		if(left <= right) {
			int middle = (left + right)/2;
			
			if(array[middle - 1] < array[middle] && array[middle] > array[middle + 1])
				return middle;
			
			if(array[middle] < array[middle +1])
				return findingMax(array, middle + 1, right);
			else
				return findingMax(array, left, middle - 1);
		}
		return -1;
	}
	
	// Loop to help with checking if the index is found in increasing or decreasing order
	private static int searching(int array[], int n, int key, int index) {
		
		if(key > array[index])
			return -1;
		else if(key == array[index])
			return index;
		else {
			int x = increase(array, 0, index - 1, key);
			if(x != -1) {
				return x;
			}
			return decrease(array, index + 1, n - 1, key);
		}
	}
	
	// Creating method to check if the element is within the array 
	private static void checkingElement(int[] array, int element) {
		
		int n = array.length;
		int index = findingMax(array, 1, n - 2);
		int x = searching(array, n, element, index);
		
		if (x == -1) {
			System.out.println("element not found");
			
		}
		else {
			System.out.println("Found " + element + " at index " + x);
		}
	}
	
	// Establishing the numbers within the array and displaying program output
	public static void main (String[] args) {
		
		int array[] = {1, 3, 4, 5, 7, 14, 11, 7, 2, -4, -8};
		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("Enter element to check: ");
			int element = scan.nextInt();
			checkingElement(array, element);
		}
	}
}

/**************** Program output ****************
 * Program outputs for three different outcomes
 * ----------------------------------------------
	Enter element to check: 1
	Found 1 at index 0
	---------------------------
	Enter element to check: 14
	Found 14 at index 5
	---------------------------
	Enter element to check: 26
	element not found
 *  ----------------------------------------------
*/
