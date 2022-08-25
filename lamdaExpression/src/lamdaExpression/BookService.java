package lamdaExpression;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookService {
	
	public List<Book> getBooksInSorted()
	{
		List<Book> books = new BookDao().getBooks();
		// Collections.sort(books, new MyComparator()); //Traditional approach
		/*
		   Collections.sort(books,new Comparator<Book>() { //now pass Comparator directly

			@Override
			public int compare(Book o1, Book o2) {
				return o2.getName().compareTo(o1.getName());
			}
		});
		return books;
		*/
		
		    Collections.sort(books,(o1,o2)->o2.getName().compareTo(o1.getName()));  //using Lamda expression
		    return books;
	}
	
	public static void main(String[] args) {
		System.out.println(new BookService().getBooksInSorted());
	}
	
	/*
	 * Traditional approach
	class MyComparator implements Comparator<Book>{

		@Override
		public int compare(Book o1, Book o2) {
			//return o1.getName().compareTo(o2.getName());//Asending order Corjava Hibernate Spring webservices
			return o2.getName().compareTo(o1.getName()); //decending order webservices Spring Hibernate Corjava
		}
	}
	*/
}
