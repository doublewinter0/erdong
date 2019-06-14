package me.hoobaler;

import org.joda.time.DateTime;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.sort;

public class ITest {

	@Test
	public void setTest() {
		Set<Long> idSet = Collections.synchronizedSet(new HashSet<>());
		idSet.add(1L);
		idSet.add(2L);
		idSet.add(3L);
		idSet.add(1L);
		System.out.println(idSet);
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
		DateTime dateTime = new DateTime(
				2019,
				1,
				1,
				0,
				0,
				0,
				0
		);
		DateTime dateTime2 = new DateTime();
		DateTime dateTime3 = new DateTime(
				2050,
				1,
				1,
				0,
				0,
				0,
				0
		);
		System.out.println(dateTime.toDate().getTime());
		System.out.println(dateTime2.toDate().getTime());
		System.out.println(dateTime3.toDate().getTime());
	}
}
