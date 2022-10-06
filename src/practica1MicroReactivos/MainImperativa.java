package practica1MicroReactivos;

import java.util.ArrayList;
import java.util.List;

public class MainImperativa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count=0;
		List<Integer> numbers = List.of(18, 6, 4, 15, 55, 78, 12, 9, 8);
		for (Integer integer : numbers) {
			if (integer > 10) {
				count++;
			}
		}
		System.out.println(count);
	}
}
