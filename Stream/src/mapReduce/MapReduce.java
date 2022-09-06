package mapReduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class MapReduce {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(3,5,2,4,1);
		
		List<String> words = Arrays.asList("corejava", "spring", "hibernate");
		
		int sum =0;
		for(int no:numbers) {
			sum=sum+no;
		}
		System.out.println(sum);
		
		//functional programming and parallel processing
		
		int mapToInt = numbers.stream().mapToInt(Integer::intValue).sum();
		System.out.println(mapToInt);
		//numbers.stream().mapToInt
		
		
		Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduceSum);
        
        Optional<Integer> reduceSumWithMethodReference = numbers.stream().reduce(Integer::sum);
        System.out.println("---reduceSumWithMethodReference---");
        System.out.println(reduceSumWithMethodReference.get());
        
        //get the num convert to stream call the reduce 
        
        Integer mulResult = numbers.stream().reduce(1, (a, b) -> a * b);   
        System.out.println(mulResult);

        Integer maxvalue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(maxvalue);
        
        
        Integer maxvalueWithMethodReference = numbers.stream().reduce(Integer::max).get();
        System.out.println(maxvalueWithMethodReference); //5

        Integer minvalueWithMethodReference= numbers.stream().reduce(Integer::min).get();
		System.out.println(minvalueWithMethodReference);  //1
        
        String longestString = words.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();
        System.out.println(longestString); //hibernate
        
        
		int sum1 = Stream.of ("1","2","3")
                .map (Integer::valueOf)
                .map(i -> Math.pow(i,2))
                .mapToInt(Double::intValue)
                .sum();
		System.out.println(sum1);
		
		
		//get employee whose grade A
        //get salary
        double avgSalary = EmployeeDatabase.getEmployees().stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                .map(employee -> employee.getSalary())
                .mapToDouble(i -> i)
                .average().getAsDouble();

        System.out.println(avgSalary);
        
        double sumSalary = EmployeeDatabase.getEmployees().stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                .map(employee -> employee.getSalary())
                .mapToDouble(i -> i)
                .sum();
        System.out.println(sumSalary);

	}

}
