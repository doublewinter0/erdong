package ren.erdong;

import com.red.util.NoRRS;

public class Test007 {
	public static void main(String[] args) throws Exception {
		int[] num = NoRRS.getNonRepeRanSeq(10000, 12000);
		BubbleSort(num);
	}

	private static void BubbleSort(int[] num) {
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
		System.out.print("按从小到大的顺序排列为:");
		for (int z = 0; z < num.length; z++) {
			if (z != num.length - 1) {
				System.out.print(num[z] + ",");
			} else
				System.out.print(num[z] + ".");
		}
	}
}