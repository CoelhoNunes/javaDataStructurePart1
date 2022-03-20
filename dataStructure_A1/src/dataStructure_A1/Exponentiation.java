/******************************************************************************************* 
Purpose/Description: Implementing a sub-linear running complexity recursive function. 

Author’s Panther ID: 6194506

Certification:
I hereby certify that this work is my own and none of it is the work of any other person.
*******************************************************************************************/

package dataStructure_A1;

public class Exponentiation {
	
	public static long exponentiation(long x, int n) {
		
			// stating the cases
            if (n == 0)
                return 1;

            if (n == 1)
                return x ;

            // The recursive function & operations
            long y = exponentiation(x,n/2);
            	 y = (y * y);
      
            if (n % 2 == 0)
                return y;
            
            else 
                return x * y;
    }
    // Displaying the X^n and its calculations
    public static void main(String[] args) {
    	
        System.out.println("103^4 is: " + exponentiation(103,4));
        System.out.println("12^4 is: " + exponentiation(12,4));
        System.out.println("-165^4 is: " + exponentiation(-164,4));
        System.out.println("36^10 is: " + exponentiation(36,10));
        System.out.println("10000^3 is: " + exponentiation(10000,3));
        System.out.println("3^3 is: " + exponentiation(3,3));
    }
}

/********* Program output *********
 * -----------------------------------
	103^4 is: 112550881
	12^4 is: 20736
	-165^4 is: 723394816
	36^10 is: 3656158440062976
	10000^3 is: 1000000000000
	3^3 is: 27
 *  -----------------------------------
*/