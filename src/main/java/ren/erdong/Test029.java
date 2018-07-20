package ren.erdong;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

// 利用反射对 ArrayList<T> 集合特性的探究
public class Test029 {

	@Test
	public void test() {
		ArrayList<String> arrayList = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			arrayList.add("RED");
		}

        /*
        // java.lang.OutOfMemoryError: Java heap space
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            arrayList.add("RED");
        }
        */

		Class<? extends ArrayList> arrayListClass = arrayList.getClass();
		Field[] arrayListFields = arrayListClass.getDeclaredFields();
		System.out.println("实例变量个数 = " + arrayListFields.length);
		for (Field field : arrayListFields) {
			field.setAccessible(true);
			try {
				if (field.get(arrayList) instanceof Object[]) {
					Object[] objs = (Object[]) field.get(arrayList);
					System.out.print(objs.length + ": " + Arrays.toString(objs));
				}
				System.out.println(field + " = " + field.get(arrayList));
				System.out.println("----------------------------------");
			} catch (IllegalAccessException ilaExp) {
				ilaExp.printStackTrace();
			}
		}
	}
}
