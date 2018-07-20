package ren.erdong;

/*
 *	关于继承的一些问题
 */
public class Test021 {

	public static void main(String[] args) {
		Test021_Test test = new SubTest021_Test();
		test.go();
	}
}

class Test021_Test {
	private String str;

	public Test021_Test() {
		super();
	}

	public Test021_Test(String str) {
		this.str = str;
	}

	public void go() {
		show();
	}

	public void show() {
		System.out.println("parent");
	}
}

class SubTest021_Test extends Test021_Test {
	private String str;

	public SubTest021_Test() {
		super();
	}

	public SubTest021_Test(String str) {
		super(str);
	}

	@Override
	public void show() {
		System.out.println("sub");
	}
}