package lamdaExpression;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
	
	public List<Book> getBooks(){
		
		List<Book> books = new ArrayList<>();
		books.add(new Book(101, "Corejava", 400));
		books.add(new Book(363, "Hibernate", 400));
		books.add(new Book(275, "WebServices", 400));
		books.add(new Book(893, "Spring", 400));
		return books;
		
	}

}
