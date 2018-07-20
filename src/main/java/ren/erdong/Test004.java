package ren.erdong;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 装逼如风,常伴吾身.
 */


public class Test004 {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type something here...");
		String str = scanner.nextLine();
		System.out.println("***" + str.toString());
		scanner.close();
		arrayList.add(str);
		System.out.println("str before reverse:" + "\n" + arrayList);
		arrayList.clear();
		reverseString(str);
		//System.out.println("---" + str);
		arrayList.add(str);
		System.out.println("str after reverse:" + "\n" + arrayList);
	}

	public static void reverseString(String str) {

		StringBuilder stringBuilder = new StringBuilder(str);
		System.out.println("@@@" + stringBuilder.hashCode());
		System.out.println("###" + stringBuilder.reverse().hashCode());
		System.out.println("$$$" + stringBuilder.reverse().toString().hashCode());
		//System.out.println(str + "***");
	}
}
