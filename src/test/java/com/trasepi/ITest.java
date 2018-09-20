package com.trasepi;

import org.junit.Test;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class ITest {

	@Test
	public void double2Int() {
		long l = 123456789876L;
		int i = (int) l; // -1097261708
		long lower32bit = l << 32 >>> 32;
		System.out.println(Integer.toHexString(i).equals(Long.toHexString(lower32bit)));

		System.out.println("--- I am split line ---");
		System.out.println(Integer.MAX_VALUE);
		double d1 = 123456789876.123;
		double d2 = 123.123;
		double d3 = 123456789.123;
		System.out.println((int) d1);
		System.out.println((int) d2);
		System.out.println((int) d3);
		System.out.println(Double.toString(d1));
	}

    @Test
    public void sortTest() {
        int[] ints = {3, 5, 1, 9, 4};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }
}
