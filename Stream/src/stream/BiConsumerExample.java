package stream;

import java.util.function.BiConsumer;

public class BiConsumerExample implements BiConsumer<String, Integer> {

	@Override
	public void accept(String I1, Integer I2) {
		System.out.println("Input1: "+I1 + " Input2: " +I2);
	}
	
	public static void main(String[] arrgs) {
		BiConsumer<String, Integer> biConsumer = new BiConsumerExample();  // traditional approach
		biConsumer.accept("Emma", 5000);
		
		
		BiConsumer<String, Integer> biConsumer1 = new BiConsumer<String, Integer>(){  //annonymous approach

			@Override
			public void accept(String i1, Integer i2) {
				System.out.println(i1+":"+i2);
			}
		
		};
		biConsumer1.accept("welcome", 12345);
		
	}
		
	}
