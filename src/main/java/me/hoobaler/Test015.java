package me.hoobaler;

public class Test015 {

	public static void main(String[] args) throws IllegalArgException {
		System.out.println("任二冬");
		int n = 6;
		printTriangle(n);
	}

	private static void printTriangle(int n) throws IllegalArgException {
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

        for (String[] anAsterisk : asterisk) {
            for (String anAnAsterisk : anAsterisk) {
                System.out.print(anAnAsterisk);
            }
            System.out.println();
        }
	}
}

class IllegalArgException extends Exception {

	private static final long serialVersionUID = 303664991849364669L;

	IllegalArgException(String msg) {
		super(msg);
	}
}
