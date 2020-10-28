package me.hoobaler.entertain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// Given a positive number N(>1), find all consecutive positive number sequences with a sum of N
public class Sum2N {

	public static void main(String[] args) {
		System.out.println(isSquareNum(9000000006000000033L));

		Scanner scanner = new Scanner(System.in);
		System.out.println("please input a positive num:");
		// List<long[]> seqList = getSeqs(scanner.nextLong());
		List<long[]> seqList = getAllSeqs((scanner.nextLong()));
		seqList.forEach(ele -> System.out.println(Arrays.toString(ele)));
	}

	/**
	 * @param n 和
	 * @return java.util.List<long [ ]> 所有满足条件的序列
	 * @description 这个算法大概是 18 年 8 月份写的, 当时也没作太多的思考, 现在(2019/3/6)看来, 这个算法并不好!
	 * @author erdong
	 * @date 19:27 2019/3/6
	 **/
	private static List<long[]> getAllSeqs(long n) {

		if (n < 2) throw new RuntimeException("your input " + "(" + n + ")" + " is illegal");

		List<long[]> ansList = new LinkedList<>();
		long firstTerm;
		long maxFirstTerm = n / 2;
		// 如果穷举参数, 当 n 比较大时, 循环次数也会变得很大, 导致程序性能下降!
		for (firstTerm = 1L; firstTerm <= maxFirstTerm; firstTerm++) {
			long delta = (long) Math.pow(2 * firstTerm - 1, 2) + 8 * n;
			long numOfTerms;
			// 这个方法要对参数开根号, 显然也是比较消耗性能的操作
			if ((numOfTerms = getRoot(delta, firstTerm)) > 0) ansList.add(new long[]{firstTerm, numOfTerms});
		}
		return ansList;
	}

	/**
	 * @param n 和
	 * @return java.util.List<long [ ]> 所有满足条件的序列
	 * @description 这个算法便是 getAllSeqs(long n) 的优化版本, 两个算法的数学原理是一样的: 求解方程!(m^2+(2a+1)m-2n=0, n 为已知量)
	 * 因为之前没有意识到, 参数和二次元有某种等价性, 所以如果穷举二次元, 那么就变成了一次方程, 求解一次方程显然更容易, 即使是计算机去做这件事!
	 * 事实上, 穷举二次元会使循环次数大大减少, 具体可参见代码, 证明也比较容易!
	 * @author erdong
	 * @date 19:37 2019/3/6
	 **/
	private static List<long[]> getSeqs(long n) {

		if (n < 2L) throw new RuntimeException("your input " + "(" + n + ")" + " is illegal");

		List<long[]> ansList = new LinkedList<>();
		// m 为项数
		long m;
		long max = (long) (Math.sqrt(8 * n + 1) - 1) / 2;
		for (m = 2L; m <= max; m++) {
			long alpha;
			if ((alpha = (2 * n - m * (m + 1))) % (2 * m) == 0)
				ansList.add(new long[]{alpha / (2 * m) + 1, m});
		}
		return ansList;
	}

	private static boolean isSquareNum(long n) {
		return Math.pow((long) Math.sqrt(n), 2) == n;
	}

	private static long getRoot(long delta, long firstTerm) {
		if (isSquareNum(delta)) {
			long temp;
			if (((temp = (long) (1 + Math.sqrt(delta)))) % 2 == 0) return temp / 2 - firstTerm;
		}
		return -1;
	}
}
