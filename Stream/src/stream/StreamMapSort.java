package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapSort {

	public static void main(String[] args) {
		
		Map<String, Integer> map4 = new TreeMap();
		map4.put("eight", 8);
		map4.put("two", 2);
		map4.put("ten", 10);
		map4.put("one", 1);
		System.out.println(map4);
		List listnew = new ArrayList(map4.entrySet());
		/*
		 * Collections.sort(listnew, new Comparator<Map.Entry<String, Integer>>() {
		 * 
		 * @Override 
		 * public int compare(Map.Entry<String, Integer> e1, Map.Entry<String,
		 * Integer> e2) { return e1.getValue().compareTo(e2.getValue()); } });
		 */
		
		Collections.sort(listnew, (e1, e2) -> ((Entry<String,Integer>) e1).getValue().compareTo(((Entry<String,Integer>) e2).getValue()));
	    System.out.println("Sorted by values:");
	    System.out.println(listnew);
	    Set<Entry<String,Integer>> entries1 = map4.entrySet();
	       for(Map.Entry<String, Integer> entry : entries1){
	            System.out.println( entry.getKey() + "=>" + entry.getValue() );
	        }
	    
	    System.out.println("&&&&&33&&&&&");
	    List<String> collect = map4.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).map(entry -> entry.getKey()).collect(Collectors.toList());
	    System.out.println(collect);
System.out.println("&&&&&&&&&&");


		Map<String, Integer> map = new HashMap<>();
		map.put("eight", 8);
		map.put("two", 2);
		map.put("ten", 10);
		map.put("one", 1);
		//list to map get the list from a a map-  get the entry set from the map then add it to the list
		//map.entrySet() gives you a collection of Map.Entry objects containing both key and value.
		
		List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());  //traditional approach
	/*	Collections.sort(entries,new Comparator<Entry<String, Integer>>() { //COllections.sort(List)

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getKey().compareTo(o2.getKey());  //sort based on key
				//return o1.getValue().compareTo(o2.getValue()); //sort based on value
			}
		});
	*/	
		Collections.sort(entries,(o1,o2)-> o1.getKey().compareTo(o1.getKey()));  //lamda for Comparator
		
		for(Entry<String, Integer> entry : entries)
			System.out.println(entry.getKey() + " : " + entry.getValue());
		//List<Value> values = map.values().stream().collect(Collectors.toList());
		
		//java 8 stream
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
		System.out.println("****************");
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
		//map.entrySet().stream().sorted(Map.Entry.comparingByKey().reversed()).forEach(System.out::println);
		
		
		map.entrySet()
		  .stream()
		  .sorted(Map.Entry.comparingByValue())
		  .forEach(System.out::println);
		
		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
		map.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		System.out.println("Sorted Map   : " + sortedMap);

		LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

		System.out.println("reverse Sorted Map   : " + reverseSortedMap);

		Map<Employee, String> map1 = new HashMap<>();
		map1.put(new Employee(1, "karan", "java", 9000), "java”");
		map1.put(new Employee(3, "vivek", "c", 8000), "c");
		map1.put(new Employee(2, "abc", "c++", 7000), "c++");
		System.out.println("----salary-------");
		map1.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee :: getSalary))).forEach(System.out::println); // print elemnets in ascending order
		System.out.println("----name-------");
		map1.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee :: getName))).forEach(System.out::println);
		System.out.println("----name reverse-------");
		map1.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee :: getName).reversed())).forEach(System.out::println);
		System.out.println("----salary reverse-------");
		map1.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee :: getSalary).reversed())).forEach(System.out::println); // print elemnets in descending order
		map1.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);  //c,c++,java
		
		
		Set<Entry<Employee, String>> entrySet = map1.entrySet();
		List<Entry<Employee, String>> list = new ArrayList<>(entrySet);
		//Collections.sort(list, (o1, o2) -> o1.getKey().getDept().compareTo(o1.getKey().getDept()));
		//Collections.sort(list, (o1, o2) -> o1.getKey().getId() - o2.getKey().getId());   //1,2.3
		//Collections.sort(list, (o1, o2) -> o2.getKey().getId() - o1.getKey().getId());   //3,2,1
		//Collections.sort(list, (o1, o2) -> o1.getKey().getName().compareTo(o2.getKey().getName()));  //abc,karan ,vivek
		Collections.sort(list, (o1, o2) -> o1.getKey().getDept().compareTo(o2.getKey().getDept()));  //c  c++ java
		System.out.println("-----------");
		list.forEach(e-> System.out.println(e.getKey()+":" +e.getValue()));
		System.out.println("----222-------");

	/*	
	Map<Employee,Integer> empMap = new TreeMap<>(new Comparator<Employee>() {


		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return (int) (o1.getSalary()-o2.getSalary());
		}
	});
	*/
		Map<Employee,Integer> empMap = new TreeMap<>((o1, o2) ->  (int) (o1.getSalary()-o2.getSalary()));
//{Employee [id=674, name=sourav, dept=CORE, salary=400000]=120,
	//	Employee [id=470, name=Bimal, dept=DEFENCE, salary=500000]=50, 
		//Employee [id=176, name=Roshan, dept=IT, salary=600000]=60, Employee [id=388, name=Bikash, dept=CIVIL, salary=900000]=40}

		Map<Employee,Integer> empMap2 = new TreeMap<>((o1, o2) ->  (int) (o2.getSalary()-o1.getSalary())); //decending

			

		
	empMap.put(new Employee(176, "Roshan", "IT", 600000), 60);
	empMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 40);	
	empMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 50);	
	empMap.put(new Employee(674, "sourav", "CORE", 400000),120);	
	System.out.println("-----------empMap-----");
	System.out.println(empMap);
	
	
	System.out.println("-----------empMap stream@-----");
	empMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary))).forEach(System.out::println);
	
	
	System.out.println("-----------empMap stream@reverse-----");
	empMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getSalary).reversed())).forEach(System.out::println);
	  
	}
}