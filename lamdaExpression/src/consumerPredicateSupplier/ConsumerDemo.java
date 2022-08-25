package consumerPredicateSupplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
	
/*	 // traditional approach
 * public class ConsumerDemo implements Consumer<Integer> {
 * 
	@Override
	public void accept(Integer t) {
		System.out.println("Printing:" +t);
		
	}

	public static void main(String[] args) {
		ConsumerDemo c = new ConsumerDemo();
		c.accept(30);
	}
*/	
	
	public static void main(String[] args) {
		
		Consumer<Integer> consumer =(t)-> {
			System.out.println("Printing:" +t);
			
		};
		consumer.accept(10);
		
		
		List<Integer> list1 = Arrays.asList(1,2,3,4,5);
	//	list1.stream().forEach(consumer);  // pass the Consumer reference
		                                   // will internally call the accept method and print
		
		list1.stream().forEach(t->System.out.println("Print" +t)); //internally uses the Consumer functional interface and calls the accept method and pass t
	}
}
