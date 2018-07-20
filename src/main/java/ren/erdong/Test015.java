package ren.erdong;

// 
public class Test015 {

	public static void main(String[] args) throws IllegalArgException {

		System.out.println("任二冬");
		int n = 6;
		printTriangle(n);
		
		/*
		for (int i = 3; i <= 20; i++) {
			printTriangle(i);
		}
		*/
	}

	public static void printTriangle(int n) throws IllegalArgException {
		if (n < 3) {
			throw new IllegalArgException("请输入大于 2 的正整数!");
		}
		String[][] asterisk = new String[n][2 * n - 1];
		for (int i = 0; i < asterisk.length; i++) {
			for (int j = 0; j < asterisk[i].length; j++) {
				asterisk[i][j] = " ";
			}
		}

		for (int i = 0; i < asterisk.length; i++) {
			for (int j = 0; j < asterisk[i].length; j++) {
				if (j >= (n - i - 1) && j <= (n + i - 1)) {
					asterisk[i][j] = "*";
				}
			}
		}

		for (int i = 0; i < asterisk.length; i++) {
			for (int j = 0; j < asterisk[i].length; j++) {
				System.out.print(asterisk[i][j]);
			}
			// if (i != asterisk.length - 1) {
			System.out.println();
			// }
		}
	}
}

class IllegalArgException extends Exception {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 303664991849364669L;

	public IllegalArgException(String msg) {
		super(msg);
	}
}
