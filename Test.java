
// import javax.;

// import javax.crypto.Cipher;

import java.util.Arrays;

public class Test {
        
        public static void main(String[] args){
			int k = 0;
			kWhile: while (k <= 5) {
				k++;
				System.out.println(k);
			
				if (k == 2) continue kWhile;
				if (k == 3) return;
			}
			System.out.println(test());
	}


	public static int test(){

		Arrays.asList(100,200,300).forEach(n -> {
			if (n==200) return;
			System.out.println(n);
		});



		System.out.println("test completed");
		return 11;

	}
}
