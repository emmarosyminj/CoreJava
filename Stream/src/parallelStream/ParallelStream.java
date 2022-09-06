package parallelStream;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStream {

	public static void main(String[] args) {

		long start=0;
		long end=0;

		start= System.currentTimeMillis();
		IntStream.range(1, 100).forEach(System.out::println);
		end=System.currentTimeMillis();
		System.out.println("plain stream took: "+(end-start));  //plain stream took: 142

		System.out.println("=======================");
		start= System.currentTimeMillis();
		IntStream.range(1, 100).parallel().forEach(System.out::println);
		end=System.currentTimeMillis();
		System.out.println("Parallel stream took: "+(end-start));   //Parallel stream took: 40
		
		
		IntStream.range(1, 10).forEach(x->{
		System.out.println("Thread :"+Thread.currentThread().getName()+" : "+x);
		});
		

		IntStream.range(1, 10).parallel().forEach(x->{
		System.out.println("Thread :"+Thread.currentThread().getName()+" : "+x);
		});

		
		List<Employee> employees = EmployeeDatabase.getEmployees();
		//normal
		start= System.currentTimeMillis();
		double salaryWithStream = employees.stream().map(Employee::getSalary).mapToDouble(i->i).average().getAsDouble();
		end=System.currentTimeMillis();
		System.out.println("plain stream took salaryWithStream: "+(end-start)+ "  Avg salary :" +salaryWithStream);

		
		start= System.currentTimeMillis();
		double salaryWithParallelStream = employees.parallelStream().map(Employee::getSalary).mapToDouble(i->i).average().getAsDouble();
		end=System.currentTimeMillis();
		System.out.println("parallel stream took salaryWithParallelStream: "+(end-start)+ "  Avg salary :" +salaryWithParallelStream);
	}

}
