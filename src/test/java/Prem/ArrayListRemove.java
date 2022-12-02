package Prem;

import java.util.ArrayList;

public class ArrayListRemove {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(10);
		arr.add(20);
		arr.add(30);
		arr.add(40);
		arr.add(50);
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(40);
		arr1.add(50);
		arr1.add(60);
		arr1.add(70);
		System.out.println(arr);
		System.out.println(arr1);
		//arr.removeAll(arr1);
		arr.retainAll(arr1);
		System.out.println(arr);
		System.out.println(arr1);
		
		
	}

}
