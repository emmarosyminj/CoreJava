package stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BiFunctionExample implements BiFunction<List<Integer>, List<Integer>, List<Integer>> {

	@Override
	public List<Integer> apply(List<Integer> list1, List<Integer> list2) {   //implements the BiFunc and override the apply method
		return Stream.of(list1,list2)
				.flatMap(List::stream)
				.distinct()
				.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		BiFunction bifunction = new BiFunctionExample();
		List<Integer> list1 = Stream.of(1,3,55,7,99).collect(Collectors.toList());
		List<Integer> list2 = Stream.of(11,33,55,77,99).collect(Collectors.toList());
		System.out.println("Traditional approach" +bifunction.apply(list1, list2));
	
	
	//annonymous imple
	BiFunction<List<Integer>,List<Integer>,List<Integer>> biFunction1 = new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {
		
		@Override
		public List<Integer> apply(List<Integer> l1, List<Integer> l2) {   //created obj of interface and do the annonymous way
			// TODO Auto-generated method stub
			return Stream.of(l1,l2)
					.flatMap(List::stream)
					.distinct()
					.collect(Collectors.toList());
		}
	};
	
	System.out.println("annonymous approach" +biFunction1.apply(list1, list2));
	
	
	BiFunction<List<Integer>,List<Integer>,List<Integer>> biFunction2 = (l1, l2)-> {   //lamda exp
		// TODO Auto-generated method stub
		return Stream.of(l1,l2)
				.flatMap(List::stream)
				.distinct()
				.collect(Collectors.toList());    //op [1, 3, 55, 7, 99, 11, 33, 77]
	};

	Function<List<Integer>,List<Integer>> sortedFunction = (lists)->lists
			.stream()
			.sorted()
			.collect(Collectors.toList());
	
	System.out.println("Lamda exp"+biFunction2.apply(list1, list2));
	
	System.out.println("Lamda exp and sorted"+biFunction2.andThen(sortedFunction).apply(list1, list2));

	
	Map<String, Integer> map = new HashMap<>();
	map.put("basant",5000);
	map.put("santosh",15000);
	map.put("hema",12000);

	BiFunction<String, Integer, Integer> increaseSalaryBifunction = new BiFunction<String, Integer, Integer>() {

		@Override
		public Integer apply(String key, Integer value) {
			return value+1000;
		}
	};
	map.replaceAll(increaseSalaryBifunction);
	System.out.println(map);
	
	BiFunction<String, Integer, Integer> increaseSalaryBifunction1 = ( key, value)-> {
		return value+1000;
	};
	
	map.replaceAll(increaseSalaryBifunction1);
	System.out.println(map);
	}
	
	
}


