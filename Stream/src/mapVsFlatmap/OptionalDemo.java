package mapVsFlatmap;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
	
	 public static Customer getCustomerByEmailId(String email) throws Exception {
	        List<Customer> customers = EkartDataBase.getAll();
	       return customers.stream()
	                .filter(customer -> customer.getEmail().equals(email))
	                .findAny().orElseThrow(()->new Exception("no customer present with this email id"));
	       //.findAny().get();
	    }
	 

	public static void main(String[] args) throws Exception {

		// Customer customer = new Customer(102, "smith", "smith@gmail.com",
		// Arrays.asList("89563865", "2487238947"));
		Customer customer = new Customer(102, "smith", null, Arrays.asList("89563865", "2487238947"));
		// 3 ways to create Optional
		// empty
		// of
		// ofNullable

		Optional<Object> emptyOptional = Optional.empty();
		System.out.println(emptyOptional); // Optional.empty

		// Optional<String> emailOptional = Optional.of(customer.getEmail()); // will do
		// null check wil give NPE
		// System.out.println(emailOptional);

		// Customer customer = new Customer(102, "smith", "smith@gmail.com",
		// Arrays.asList("89563865", "2487238947"));

		Optional<String> emailOptional2 = Optional.ofNullable(customer.getEmail());
		System.out.println(emailOptional2); // Optional[smith@gmail.com] if null-Optional.empty
		// System.out.println(emailOptional2.get()); //No value present

		
		  if(emailOptional2.isPresent()) {
			  System.out.println(emailOptional2.get()); }  //Optional.empty
		  
		  System.out.println(emailOptional2.orElse("default@gmail.com"));
		  
		 // System.out.println(emailOptional2.orElseThrow(()-> new IllegalArgumentException("Email not found"))); //java.lang.IllegalArgumentException: Email not found
		  
		  System.out.println(emailOptional2.map(String::toUpperCase).orElseGet(()-> "defaujlt email..")); //defaujlt email..
		 
		  Customer customer1 = new Customer(102, "smith", "abc", Arrays.asList("89563865", "2487238947"));
		  Optional<String> emailOptional3 = Optional.ofNullable(customer1.getEmail());
		  System.out.println(emailOptional3.orElse("default@gmail.com"));  //abc
		  System.out.println(emailOptional3.map(String::toUpperCase).orElseGet(()-> "defaujlt email..")); 
		  
		  
		  getCustomerByEmailId("pqr");
		  //getCustomerByEmailId("john@gmail.com");
		  
	}

}
