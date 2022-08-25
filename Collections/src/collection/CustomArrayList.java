package collection;

import java.util.ArrayList;

public class CustomArrayList extends ArrayList {

@Override
public boolean add(Object o) {
	if(this.contains(o)) {
		return true;
	}else {
		return super.add(o);
	}
	
}
	
	public static void main(String[] args) {

		CustomArrayList list1 = new CustomArrayList();
		list1.add(1);
		list1.add(1);
		list1.add(1);
		list1.add(2);
		list1.add(2);
		
		System.out.println(list1);
		
	}

}
