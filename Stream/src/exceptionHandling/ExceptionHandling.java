package exceptionHandling;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ExceptionHandling {

	public static void main(String[] args) {

		/*List<String> list = Arrays.asList("44","234","768");
		
		List<Integer> intList = list.stream().map(s->Integer.parseInt(s)).collect(Collectors.toList());
		System.out.println(intList); //[44, 234, 768]
		
		
		List<Integer> intList1 = list.stream().map(Integer::parseInt).collect(Collectors.toList());
		System.out.println(intList1); //[44, 234, 768]
		*/
		
		/*List<String> list = Arrays.asList("44","234","xyz");

		list.forEach(s-> {
			try {
				System.out.println(Integer.parseInt(s));
			} catch (NumberFormatException e) {
				System.out.println("exception: "+e.getMessage());   //not and ideal way to handle ex in lamda
			}
		});
		*/
		
		List<String> list = Arrays.asList("44","234","xyz");
		list.forEach(ExceptionHandling::printList);
		
		list.forEach(handleExceptionIfAny(s-> System.out.println(Integer.parseInt(s))));
		
	//	list.forEach(handleGenericException(s-> System.out.println(Integer.parseInt(s)),NumberFormatException.class));
		
	//	list.forEach(handleGenericException(s-> System.out.println(Integer.parseInt(s)),ArithmeticException.class));
		
	//	List<Integer> list1 = Arrays.asList(1,0);
	//	list1.forEach(s->System.out.println(10/s));
		
		
	/*	List<Integer> list1 = Arrays.asList(1,0);
		list1.forEach(handleGenericException( s->System.out.println(10/s),ArithmeticException.class));
	*/	
	/*	List<Integer> list2 = Arrays.asList(10,20);
		list2.forEach(i-> {
			try {
				Thread.sleep(i);
				System.out.println(i);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
			
		});
	}
	*/
		
		List<Integer> list2 = Arrays.asList(10,20);
		//list2.forEach(handleCheckedExceptionConsumer (i-> Thread.sleep(i)));
		
		list2.forEach(handleCheckedExceptionConsumer (i-> {
			
		Thread.sleep(i);
		System.out.println(i);
		}));
	}
		
	public static void printList(String s) {
		try {
			System.out.println(Integer.parseInt(s));
		} catch (NumberFormatException e) {
			System.out.println("exception: " + e.getMessage()); // not and ideal way to handle ex in lamda
		}
	}

	static Consumer<String> handleExceptionIfAny(Consumer<String> payload){
		return obj->{
			try {
			payload.accept(obj);
			}catch(Exception ex) {
				System.out.println("exception: "+ex.getMessage());
		}
	};
}
	
	
	
	static <Target, ExObj extends Exception> Consumer<Target> handleGenericException(Consumer<Target> targetConsumer,Class<ExObj> exObjClass){
		return obj->{
			try {
				targetConsumer.accept(obj);
			}catch(Exception ex) {
				try {
					ExObj exObj = exObjClass.cast(ex);
					System.out.println("exception: "+exObj.getMessage());
				}catch(ClassCastException ecx) {
				throw ex;
				}
		}
	};
	
	}
	
	static <Target> Consumer<Target> handleCheckedExceptionConsumer (CheckedExceptionHandlerConsumer<Target,Exception> handlerConsumer){
		return obj->{
			try {
				handlerConsumer.accept(obj);
			}catch(Exception ex) {
				throw new RuntimeException(ex);
		}
	};
	}
	
}
