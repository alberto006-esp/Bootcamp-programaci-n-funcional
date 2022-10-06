package practica1MicroReactivos;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> numbers = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);
		System.out.println(numbers.stream().filter(number -> number >10).count());
	}

}
