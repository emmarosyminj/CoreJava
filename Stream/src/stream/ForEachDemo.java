package stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ForEachDemo {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("mary");
		list.add("john");
		list.add("peter");
		list.add("mark");
		list.add("kevin");

		for (String s : list) {   //Traditional approach
			System.out.println(s);
		}
        //void forEach(Consumer<? super T> action);  forEach uses COnsumer- Func Interface has accept()
		//void accept(T t);
		
		list.stream().forEach(t->System.out.println(t));  //lamda
		
		Map<Integer, String> map = new HashMap<>();
		map.put(1,"a");
		map.put(2,"b");
		map.put(9,"c");
		map.put(3,"d");
		
		for(Map.Entry<Integer, String> entry : map.entrySet())
			System.out.println("key-" +entry.getKey()+ ",value-" + entry.getValue());

		for(Integer num : map.keySet())
			System.out.println("key: " + num);
		
		for(String num1 : map.values())
			System.out.println("value: " + num1);
		
		// using iterators
        Iterator<Map.Entry<Integer, String>> itr = map.entrySet().iterator();
          
        while(itr.hasNext())
        {
             Map.Entry<Integer, String> entry = itr.next();
             System.out.println("Key = " + entry.getKey() + 
                                 ", Value = " + entry.getValue());
        }
        
        System.out.println("---java 8--");
        map.forEach((key,value)->System.out.println(key +":" +value));  //lamda
        //here we cannot use the pipeline method used in the Stream class
        
        map.entrySet().stream().forEach(obj->System.out.println(obj));
        
        
        //filter --> Conditional check
        List<String> list1 = new ArrayList<>();
		list1.add("mary");
		list1.add("john");
		list1.add("peter");
		list1.add("mark");
		list1.add("kevin");
		
		for(String s : list1) {                      //traditional approach
			if(s.startsWith("m")) {
				System.out.println(s);
			}
		}
		//filter uses Predicate
		// boolean test(T t);

		list1.stream().filter(t -> t.startsWith("m")).forEach(t->System.out.println(t));
		

		Map<Integer, String> map1 = new HashMap<>();
		map1.put(1,"a");
		map1.put(2,"b");
		map1.put(3,"c");
		map1.put(4,"d");
		
		map1.entrySet().stream().filter(k->k.getKey()%2==0).forEach(t->System.out.println(t));

	}
}