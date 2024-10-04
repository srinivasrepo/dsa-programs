import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Test {


	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(list);
	}

	public static void printList(List<Integer> list) {
		Map<Integer, Integer> map = list.stream().collect(Collectors.toMap(x -> x, x -> x));
		System.out.println(
			list
		);
		


	}


}
