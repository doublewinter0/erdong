package ren.erdong;

/*
 *	该测试我也不知道该怎么写注释
 *		注意第十一行
 *
 */
public class Test010 {

	public static void main(String[] args) {
		int i; // 为什么会报警?
		// i = 2;
		while ((i = 5) > 0) {
			System.out.println("***");
			break;
		}
	}

	public static void method() {
		int j;
		for (j = 0; j < 9; j++) {
			// ...
		}
	}
}
