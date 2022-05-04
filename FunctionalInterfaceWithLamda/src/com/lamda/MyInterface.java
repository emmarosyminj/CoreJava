package com.lamda;

@FunctionalInterface
public interface MyInterface {
	
	public abstract void method1();
	//public abstract void method2(); //Invalid '@FunctionalInterface' annotation; MyInterface is not a functional interface
	 public int hashCode(); //method from Object class will not show err if we add 
	 public boolean equals(Object obj);

}
