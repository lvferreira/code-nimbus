package core;

import java.util.ArrayList;

public class ArrayLists { 
	//It can an accept duplicate values 
	//ArraList, LinkedList, Vector - Implementing List interface 
	//Array have fixed size where as arraylist can grow dynamicaly 
	//You can access and insert any value in any index private int i =5; 
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		
		ArrayList<String> a = new ArrayList<String>(); 
		a.add("lahun"); 
		a.add("java"); 
		a.add("java"); 
			System.out.println(a); 
		a.add(0, "student"); 
			System.out.println(a); 
		/*a.remove(1); 
		 *a.remove("java"); 
		 *System.out.println(a);*/
			System.out.println(a.get(2)); 
			// testing 
			System.out.println(a.contains("java")); 
			System.out.println(a.indexOf("lahun")); 
			System.out.println(a.isEmpty()); 
			System.out.println(a.size());
	}
	 
	protected void abc() { 
		// TODO Auto-generated method stub 
		System.out.println("hello"); 
	}

}