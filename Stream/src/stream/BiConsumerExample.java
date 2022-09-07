package stream;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerExample implements BiConsumer<String, Integer> {

	@Override
	public void accept(String I1, Integer I2) {
		System.out.println("Input1: " + I1 + " Input2: " + I2);
	}

	public static void main(String[] arrgs) {
		BiConsumer<String, Integer> biConsumer = new BiConsumerExample(); // traditional approach
		biConsumer.accept("Emma", 5000);

		BiConsumer<String, Integer> biConsumer1 = new BiConsumer<String, Integer>() { // annonymous approach

			@Override
			public void accept(String i1, Integer i2) {
				System.out.println(i1 + ":" + i2);
			}

		};
		biConsumer1.accept("welcome", 12345);

		BiConsumer<String, Integer> biConsumer2 = (i1, i2) -> System.out.println("Key:" + i1 + " Value:" + i2);  //lamda
		biConsumer2.accept("abc", 1234);
		
		Map<String, Integer> map = new HashMap<>();
		map.put("basant",5000);
		map.put("santosh",15000);
		map.put("hema",12000);

		
		map.forEach(biConsumer2);
		map.forEach((k,v)->System.out.println(k+","+v));
	}

}
