
public class Test {

/**
 *
 * @param args
 */
	public static void main(String[] args) {
		String s = "HelloWorld!";
		String p = "World";
		int i = 5;
		System.out.println(s.startsWith(p, i));
		System.out.println( s.substring(i, i + p.length()).equals(p) );
	}


}
