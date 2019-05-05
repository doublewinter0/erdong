package com.trasepi;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import java.awt.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static java.util.Arrays.sort;
import static java.util.Arrays.stream;

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
	}

    @Test
    public void sortTest() {
        int[] ints = {3, 5, 1, 9, 4};
        sort(ints);
        System.out.println(Arrays.toString(ints));
    }

    @Test
	public void colorTest() {
		System.out.println(Color.GRAY.getRGB());
		System.out.println(Color.GRAY.getRed());
		System.out.println(Color.GRAY.getGreen());
		System.out.println(Color.GRAY.getBlue());
	}

	@Test
	public void replaceTest() {
		// String str = "-as--df---jk----l";
		// System.out.println(str.replaceAll("--", "\\+"));

		String str = " 1 - 3 + 4 * ( 8 / ( 1 + 3 ) - 5 * ( 7 + 3 ) * 4 + 10 ) / 5 ";
		System.out.println(str.replaceAll("\\s*", ""));
	}

	@Test
	public void go() {
		System.out.println(Hex.encodeHexString(("234567890123456789").getBytes(StandardCharsets.UTF_8)));
	}
}
