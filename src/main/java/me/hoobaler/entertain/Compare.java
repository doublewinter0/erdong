package me.hoobaler.entertain;

import java.util.Arrays;
import java.util.List;

/**
 * @author erdong
 * @description 使用时间复杂度相对较小的算法计算两个数组中数字出现的顺序是否一致, 并非绝对一致, 而是相对一致, 比如: 1, 2, 3 的顺序和 1, 3; 1, 2 的顺序认为一致
 * @date 下午11:52 19-5-24
 **/
public class Compare {

	public static void main(String[] args) {
		List<Integer> benchmark1 = Arrays.asList(1, 2, 5, 4, 3);
		List<Integer> benchmark2 = Arrays.asList(1, 7, 2, 3, 5, 2, 4, 5, 3);
		List<Integer> target1 = Arrays.asList(2, 5, 3);
		List<Integer> target2 = Arrays.asList(1, 4, 5, 3);
		System.out.println(compare(benchmark1, target1));
		System.out.println(compare(benchmark1, target2));
		System.out.println(compare(benchmark2, target1));
		System.out.println(compare(benchmark2, target2));
	}

	/*
	 * @description
	 * @author erdong
	 * @date 上午12:06 19-5-25
	 * @param [benchmark, target] benchmark target
	 * @return boolean
	 **/
	private static boolean compare(List<Integer> benchmark, List<Integer> target) {
		int size = benchmark.size();
		int index = 0;
		for (Integer i : target) {
			List<Integer> tmpList = benchmark.subList(index++, size);
			// System.out.println("tmpList ---> " + tmpList);
			int tmp = tmpList.indexOf(i);
			if (tmp < 0) return false;
			index += tmp;
		}
		return true;
	}
}
