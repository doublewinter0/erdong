package ren.erdong;


import ren.erdong.util.math.IMath;
import org.junit.Test;

import java.util.Arrays;

public class RandomTest {

	private static void bubbleSort(int[] num) {
		for (int x = num.length - 1; x >= 0; x--) {
			for (int y = 0; y < x; y++) {
				if (num[y] > num[y + 1]) {
					int temp = num[y + 1];
					num[y + 1] = num[y];
					num[y] = temp;
				}
			}
		}
		System.out.println("这组数据共有" + num.length + "个");
		System.out.println("按从小到大的顺序排列为:");
		for (int z = 0; z < num.length; z++) {
			if (z != num.length - 1) {
				System.out.print(num[z] + ",");
			} else
				System.out.print(num[z] + "." + "\n");
		}
	}

	@Test
	public void random() {
		long begin = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            int[] nums = IMath.getNonRRS(5000, 10000, true);
            // bubbleSort(num);
        }
		long semi = System.currentTimeMillis();
		System.out.println((semi - begin) / 1000);
        for (int i = 0; i < 10000000; i++) {
            int[] nums = IMath.getNonRRS2(5000, 10000, true);
            // bubbleSort(num);
        }
		long end = System.currentTimeMillis();
		System.out.println((end - semi) / 1000);
	}

	@Test
	public void go() {
		for (int i = 0; i < 10; i++) {
			int[] nums = IMath.getNonRRS2(6, 10, true);
			System.out.println(Arrays.toString(nums));
			// bubbleSort(num);
		}
	}
}
