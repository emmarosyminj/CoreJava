package consumerPredicateSupplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
/*//traditional way
	public class PredicateDemo implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		if(t % 2 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Predicate<Integer> predicateDemo = new PredicateDemo();
		System.out.println(predicateDemo.test(4));
	}
*/
	public static void main(String[] args) {
	/*	Predicate<Integer> predicate = (t)-> {
			if(t % 2 == 0) {
				return true;
			}else {
				return false;
			}
		};*/
		Predicate<Integer> predicate = t-> t % 2 == 0;  //refined
		System.out.println(predicate.test(6));
		
		List<Integer> list1 = Arrays.asList(1,2,3,4,5,6);
		list1.stream().filter(predicate).forEach(t->System.out.println("print even:" +t));
		list1.stream().filter(t-> t % 2 == 0).forEach(t->System.out.println("print even1:" +t));  //refine
	}
}
