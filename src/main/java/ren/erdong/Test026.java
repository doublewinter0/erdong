package ren.erdong;

// 关于初始化实例和实例变量顺序的探究
public class Test026 {

	public static void main(String[] args) {
		new Roby("Roby...");
	}
}

class Users {

	private String username;

	public Users() {
		super();
	}

	public Users(String username) {
		super();
		this.username = username;
		System.out.println("Users有参构造---" + username);
	}

	public String getUsername() {
		return username;
	}
}

class Roby extends Users {

	Dogs dog = new Dogs("阿黄");

	public Roby() {
		super();
	}

	public Roby(String username) {
		super(username);
		System.out.println("Roby 有参构造...");
	}
}

class Dogs {

	String name;

	public Dogs() {
		super();
	}

	public Dogs(String name) {
		super();
		this.name = name;
		System.out.println("Dog 有参构造---" + name);
	}

	@Override
	public String toString() {
		return "Dogs [name=" + name + "]";
	}
}
