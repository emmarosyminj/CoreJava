package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class IQuestions {

	public static void main(String[] args) {
		
		//find the duplicate elements in a list of integers using stream functions
		System.out.println("find the duplicate elements in a list of integers using stream functions");
		List<Integer> list = Arrays.asList(10,28 ,14,8,3,2,28,4,10,10,10);
		Set<Integer> set = new HashSet<>();
		//list.stream().filter(x->!set.add(x)).forEach(x->System.out.println(x));  //28,10,10,10
		list.stream().filter(x->!set.add(x)).collect(Collectors.toSet()).forEach(x->System.out.println(x)); //10 28
		
		
		System.out.println("multiply 2 num using fucntional interface");
		// lambda expression
		FuncInterface func = (i1, i2) -> i1 * i2;	
		System.out.println(func.multiply(5, 10));
		
		
		
		
		List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8);
		System.out.println("limit");
		list1.stream().limit(2).forEach(x->System.out.println(x));
		System.out.println("skip");
		list1.stream().skip(3).forEach(x->System.out.println(x));
	
		
		//count the number of occurance of a words in a given string
		String str ="welcome to code decode code welcome hello decode";
		List<String> list2 = Arrays.asList(str.split(" "));
		
		Map<String, Long> countOfWords = list2.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(countOfWords);
		
	}

}
