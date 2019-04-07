package com.trasepi.entertain;

/**
 * @author erdong
 * @description 整数开平方
 * @date 下午9:16 19-4-5
 **/
public class Sqrt {

	public static void main(String[] args) {
		long num = 4234567890123456789L;
		long num2 = 234567890123456789L;
		int go2 = go(num2) / 2;
		long go3 = go2((long) Math.pow(2, go2), (long) Math.pow(2, go2 + 1), num2);
		System.out.println(go3 + go3(num2, go3, 0.1D, 0, 20));
	}

	private static int go(long num) {
		long quotient = num / 2L;
		return quotient > 1 ? go(quotient) + 1 : 1;
	}

	private static long go2(long start, long end, long num) {
		if (end - start == 1L) return start;
		long middle = (start + end) / 2L;
		return middle * middle > num ? go2(start, middle, num) : go2(middle, end, num);
	}

	private static double go3(long n, long m, double a, double predicate, int precision) {
		if (precision == 0) return predicate;
		if ((Math.pow(m + predicate + a, 2) > n)) {
			return go3(n, m, a / 10, predicate, precision - 1);
		} else if ((Math.pow(m + predicate + 9 * a, 2)) < n) {
			return go3(n, m, a / 10, predicate + 9 * a, precision - 1);
		} else {
			return go3(n, m, a / 10, go4(1, 9, n, m, a, predicate), precision - 1);
		}
	}

	private static double go4(int start, int end, long n, long m, double a, double predicate) {
		int middle = (start + end) / 2;
		if (end - start == 1) return predicate + start * a;
		return Math.pow(m + predicate + middle * a, 2) > n ?
				go4(start, middle, n, m, a, predicate) : go4(middle, end, n, m, a, predicate);
	}
}
