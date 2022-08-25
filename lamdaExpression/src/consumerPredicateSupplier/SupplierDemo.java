package consumerPredicateSupplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;


/*
//traditional approach
public class SupplierDemo implements Supplier<String>{

	@Override
	public String get() {
		return "Hi";
	}

	public static void main(String[] args) {
		
		 Supplier<String> supplier = new SupplierDemo();
		 System.out.println(supplier.get());
		 
	}
*/

public class SupplierDemo{
	
	public static void main(String[] args) {
		Supplier<String> supplier= () -> {
			return "hi";
			};

			Supplier<String> supplier1= () -> "hi"; // refined
			System.out.println(supplier.get());            // print supplier - hi
			
			List<String> list1 = Arrays.asList("a", "b", "c");
			System.out.println(list1.stream().findAny().orElseGet(supplier)); // print a
			
			List<String> list2 = Arrays.asList();
			System.out.println(list2.stream().findAny().orElseGet(supplier));  //  print supplier - hi
}
}
