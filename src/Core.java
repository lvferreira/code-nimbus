import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Core {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Variables && Data Types
		int num = 5;
		String website = "X-Team Academy";
		char letter = 'r';
		float dec = 5.99f;
		double decimal = 5.99;
		boolean status = true;
		
		System.out.println(num+(" is the value stored in the num variable"));
		System.out.println(website);
		System.out.println(letter);
		System.out.println(dec);
		System.out.println(decimal);
		System.out.println(status);
		
		// Arrays
		int[] arr = new int[5];
		
		int[] numbers = {6,7,8,9,0};
		
		int[] nums = {1,2,4,5,6,7,8,9,10,122};
		
		String[] words = {"x", "team", "academy"};
		
		// ArrayList
		ArrayList<Integer> list = new ArrayList<>();
		
		ArrayList<String> shop = new ArrayList<>();
		
		// ForLoop
		// Conditional Operators
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
			System.out.println(arr[i]);
		}
		
		for(int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i]);
			
			if(i==numbers.length-1) {
				System.out.println();
				
			} else {
                System.out.print(" "); // Print a space between elements
            }
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i]%2==0) {
				System.out.println(nums[i]);
				if(i==nums.length-1) {
					for(int j = 0; j < nums.length; j++) {
						if(nums[j]%2!=0) {
							System.out.print(nums[j]+" ");
						}
						if(j==nums.length-1) {
							System.out.println();
						}
					}
				}
			} 
		}
		
		for( String str: words) {
			System.out.println(str);
		}
		
		for(int i = 1; i <= 5; i++) {
			list.add(i);
		} System.out.println(list);
		
		// Different string values for the shopping list
        String[] items = {"banana", "apples", "mangoes"};
        // Dynamically initialize using a ForLoop
        for (String item: items) {
        	shop.add(item);
        }
        // Iterate through the ArrayList using a For-each Loop
        // index=0;
        for (String item: shop) {
            System.out.println(item);
			/*
			 * if(index == shop.size()-1) { System.out.println(); // Print a new line }
			 * index++;
			 */
        } 
        System.out.println(shop);
        
        for(int i=0; i<shop.size(); i++) {
        	System.out.println(shop.get(i));
        }
        System.out.println(shop.contains("banana"));
        
        String[] names = {"selenium", "wedriver", "code", "nimbus"};
        List<String> nameList = Arrays.asList(names);
        System.out.println(nameList);
        System.out.println(nameList.contains("code"));
        
        // Strings (object)
        String str = "Code Selenium Webdriver Nimbus"; // string literal
        String hello = new String("Hello World!"); // new string
        
        System.out.println(str);
        System.out.println(hello);
        
        String[] result = str.split("Selenium Webdriver");
        for(int i=0; i<result.length; i++) {
        	System.out.println(result[i].trim());
        }
        // string forecast
        for(int i=0; i<str.length(); i++) {
        	System.out.println(str.charAt(i));
        }
        // reverse string
        for(int i=str.length()-1; i>=0; i--) {
        	System.out.println(str.charAt(i));
        }
        
        // Methods
		
	}

}
