package streamDebug;

import java.util.List;
import java.util.stream.Collectors;

import org.omg.IOP.Codec;

public class StreamDebug {
	
	public static void main(String[] args) {
		List<String> names = EmployeeDatabase.getEmployees()
		.stream().filter(employee->employee.getSalary()>40000)
		.map(Employee::getName)
		.distinct()
		.sorted()
		.collect(Collectors.toList());
		
		System.out.println(names);
				
	}

}
