public class Test {
	
/**
 * 
 * @param args
 */
	public static void main(String[] args) {

int[] arr1 = new int[1], arr2 = new int[1];

arr1 = arr2 = new int[]{10}; // now arr2 reference is assigned to arr1 

arr2[0] = 11;

System.out.println(arr1[0]);
System.out.println(arr2[0]);
		
	}

}
