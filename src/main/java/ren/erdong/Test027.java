package ren.erdong;

// Debug 中的一些探究
/*
 * Debug 中的 variables
 * 	若当前栈顶为 static, 则显示栈顶的局部变量(包含参数);
 * 	若当前栈顶为非 static, 则显示栈顶所属对象(this)以及栈顶的局部变量(包含参数)
 */
public class Test027 {

	public static void main(String[] args) {
		long l = 2L;
		DebugTest dTest = new DebugTest();
		dTest.go();
	}
}

class DebugTest {

	String str = "erdong";

	public void show(String str) {
		System.out.println(str);
	}

	public void go() {
		int i = 2;
		show("red");
		System.out.println(i);
	}

	@Override
	public String toString() {
		return "***" + str + "***";
	}
}
