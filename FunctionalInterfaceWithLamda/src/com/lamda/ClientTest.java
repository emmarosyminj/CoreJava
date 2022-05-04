package com.lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ClientTest {

	public static void main(String[] args) {
		//createThreadUsingAnonymousClass();
		//createThreadUsingLamdaExpressionClass();
		
		List<String> nameList = new ArrayList<>();
		nameList.add("Andrew");
		nameList.add("sean");
		nameList.add("Rocky");
		
       //Iterate the list using forEach
		
		
		//nameList.forEach((name)-> System.out.println(name));
		//nameList.forEach(System.out::println);
		
		
		
		//nameList.forEach((String name)-> {System.out.println(name);});	
		//nameList.forEach((name)-> {System.out.println(name);});	
		
		//nameList.forEach((name)-> {System.out.println(name);});	
		nameList.forEach(System.out::println);
		
		
		
		/*
		nameList.forEach(new Consumer<String>() {
			@Override
			public void accept(String name) {
				// TODO Auto-generated method stub
				System.out.println(name);
						
			}
		});	
		
		*/

	}

	private static void createThreadUsingLamdaExpressionClass() {
		// TODO Auto-generated method stub
         Runnable r = () -> {
				// TODO Auto-generated method stub
				System.out.println("My task is running..."); };
		
		Thread t = new Thread(r);
		t.start();
		
		
	}

	private static void createThreadUsingAnonymousClass() {
		// TODO Auto-generated method stub
		//create Thread using Runnable Interface
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("My task is running...");
				
			}
		};
		
		Thread t = new Thread(r);//Thread Constructor
		t.start();
	}

}
