package java8Features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {

		List<Employee> employees = Stream
				.of(new Employee(1, "Emma", "Dev", 40000), new Employee(4, "Rosy", "Test", 19000),
						new Employee(9, "minj", "Dev", 80000), new Employee(12, "hanna", "Devops", 9000),
						new Employee(3, "eliza", "Test", 18000), new Employee(19, "florence", "Devops", 15000))
				.collect(Collectors.toList());
		// max salary approach 1
		Comparator<Employee> comparingSalary = Comparator.comparing(Employee::getSalary);
		Map<String, Optional<Employee>> collect = employees.stream()
				        .collect(Collectors.groupingBy(Employee::getDept, Collectors
						.reducing(BinaryOperator.maxBy(comparingSalary))));
		System.out.println("Max salary from each dept collect--->");
		System.out.println(collect);
		// max salary approach 2
		Map<String, Employee> collect2 = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDept, Collectors
				.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));
		System.out.println("Max salary from each dept collect2--->");
		System.out.println(collect2);

		Map<String, List<Employee>> deptGrp = employees.stream().collect(Collectors.groupingBy(Employee::getDept));
		System.out.println("***grp by dept****" + deptGrp);

		// nth salary
		Optional<Integer> findNthSalary = employees.stream().map(e -> e.getSalary()).sorted(Comparator.reverseOrder())
				.skip(2).findFirst(); // 80000 40000 19000 18000 15000 9000
		// .skip(0).findFirst(); //80000
		// .skip(2).findFirst(); // 19000
		System.out.println("findNthSalary--->" + findNthSalary);

		List<User> userInfo = Stream
				.of(new User("user1", "1235666", Arrays.asList("a@gmail.com", "b@gmail.com")),
						new User("user2", "12356622", Arrays.asList("c@gmail.com", "d@gmail.com")))
				.collect(Collectors.toList());

		List<String> name = userInfo.stream().map(User::getName).collect(Collectors.toList());
		System.out.println(name);

		List<String> phone = userInfo.stream().map(User::getPhone).collect(Collectors.toList());
		System.out.println(phone);

		List<String> email = userInfo.stream().flatMap(u -> u.getEmail().stream()).collect(Collectors.toList());
		System.out.println(email);
		
		String input = "emmarosyminj";
		Map<String, Long> occurances = Arrays.stream(input.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(occurances);
	}

}
