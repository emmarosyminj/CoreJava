package stream;

import java.util.function.BiPredicate;

public class BiPredicateExample {
	
	public static void main(String[] args) {

		BiPredicate<String, String> biPredicate = new BiPredicate<String, String>() {

			@Override
			public boolean test(String s1, String s2) {
				return s1.equals(s2);
			}
			
		};
		
		System.out.println(biPredicate.test("madam", "madam"));
		
		BiPredicate<String, String> biPredicate1 = ( s1,  s2) -> s1.equals(s2);
		System.out.println(biPredicate1.test("madam", "madam1"));
		
		
		
		BiPredicate<String, String> equalsPredicate = (s1, s2) -> s1.equals(s2);
		BiPredicate<String, String> lengthPredicate = (s1, s2) ->s1.length()==s2.length();
		Boolean output = equalsPredicate.and(lengthPredicate).test("madam", "madam");
		System.out.println("Output: "+ output);
		
		Boolean orOutput = equalsPredicate.or(lengthPredicate).test("madam", "madam"); //or if any one cond is true
		System.out.println("OrOutput: "+ orOutput);
		

		
		
		
		//palindrom
		String original = "madam";
	    String reverse = "";
	    
	    int length = original.length();
	    System.out.println(length);
	      for ( int i = length - 1; i >= 0; i-- )  
	         reverse = reverse + original.charAt(i);  
	      if (original.equals(reverse))  
	         System.out.println("Entered string/number is a palindrome.");  
	      else  
	         System.out.println("Entered string/number isn't a palindrome.");   
		
		
		
	}

}
