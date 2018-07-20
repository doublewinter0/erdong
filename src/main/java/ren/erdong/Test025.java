package ren.erdong;

// 关于递归和数学递推的一些思考
class Test025 {

	public static void main(String[] args) throws Exception {
		System.out.println(remain(10, 1));
		System.out.println(factorial(6));
		System.out.println(result(4));
		System.out.println(original(1));
	}

	public static int remain(int day, int remaining) throws Exception {
		if (day < 2 || remaining < 0) {
			throw new Exception("...");
		}
		for (int i = day; i > 1; i--) {
			remaining = (remaining + 1) * 2;
		}
		return remaining;
	}

	public static int factorial(int num) throws Exception {
		if (num < 1) {
			throw new Exception("???");
		}
		if (num == 2) {
			return 2;
		}
		return num * factorial(num - 1);
	}

	public static int result(int n) throws Exception {
		if (n < 1) {
			throw new Exception("");
		}
		if (n == 1) {
			return 2;
		}
		return (3 * result(n - 1) - 1);
	}

	// 对以下几行的代码给予点关注
	public static int original(int orig) throws Exception {
		if (orig > 10) {
			throw new Exception("u are ....");
		}
		if (orig == 10) {
			return 1;
		}
		return (original(orig + 1) + 1) * 2;
	}
}