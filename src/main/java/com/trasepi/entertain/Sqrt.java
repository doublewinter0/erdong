package com.trasepi.entertain;

/**
 * @author erdong
 * @description
 * @date 下午9:16 19-4-5
 **/
public class Sqrt {

	public static void main(String[] args) {
		long num = 4234567890123456789L;
		int go2 = go2(num) / 2;
		System.out.println(go2);
		long go3 = go3((long) Math.pow(2, go2), (long) Math.pow(2, go2 + 1), num);
		System.out.println(go3);
	}

	private static int go2(long num) {
		long quotient = num / 2L;
		return quotient > 1 ? go2(quotient) + 1 : 1;
	}

	private static long go3(long start, long end, long num) {
		if (end - start == 1L) return start;
		long middle = (start + end) / 2L;
		return middle * middle > num ? go3(start, middle, num) : go3(middle, end, num);
	}

}
