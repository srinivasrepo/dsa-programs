import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
// import javax.;

// import javax.crypto.Cipher;

public class Test {
        
        public static void main(String[] args){
			char c = 'B';
			c = 'A'+1;
			System.out.println(c);

			Predicate<String> predicate = (text) -> text.equals("bool");


			System.out.println( predicate.test("bool") );

			List<String> list = new ArrayList<>();
			list.add("null");
			list.add("null2");
			Consumer<String> consumer = System.out::println;
			list.forEach(consumer);
		
			
		
	}
}
