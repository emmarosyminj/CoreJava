package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StreamListSort {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(7);
        list.add(12);
        list.add(10);
        
        Collections.sort(list); //Asending [7, 8, 10, 12]
        Collections.reverse(list);// Decending[12, 10, 8, 7]
        System.out.println(list);
        
        list.stream().sorted().forEach(s->System.out.println(s)); //Asending
        list.stream().sorted(Comparator.reverseOrder()).forEach(s->System.out.println(s)); //desending
        
        List<Employee> employee = Database.getEmployees();
       // Collections.sort(employee, new MyComparator());  //traditional way using class MyComparator
       // System.out.println(employee);
        
       /* 
        Collections.sort(employee, new Comparator<Employee>() {  //using Comparator interface
        	
        	@Override
        	public int compare(Employee o1, Employee o2) {
        		return (int) (o1.getSalary()-o2.getSalary());	
      
        	}
	});
        
    */ 
        
    /*    
        Collections.sort(employee, (o1,o2)-> (int) (o1.getSalary()-o2.getSalary()));  //using Lamda expresson - Asending
        //Collections.sort(employee, (o1,o2)-> (int) (o2.getSalary()-o1.getSalary()));  //changing the object reference Decending

        System.out.println(employee);
     */   
        employee.stream().sorted((o1,o2)-> (int) (o1.getSalary()-o2.getSalary())).forEach(System.out::println);   //using Stream api and lamda
        
        employee.stream().sorted(Comparator.comparing(emp-> emp.getSalary())).forEach(System.out::println); //optomize the lamda
        
        employee.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);   //method reference
	}
}
/*
class MyComparator implements Comparator<Employee>{          //traditional way

	@Override
	public int compare(Employee o1, Employee o2) {
		return (int) (o1.getSalary()-o2.getSalary()); //asending
		//return (int) (o2.getSalary()-o1.getSalary());  //decending
	}
}
*/
