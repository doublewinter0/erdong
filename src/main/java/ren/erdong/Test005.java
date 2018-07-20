package ren.erdong;

import java.util.Scanner;

/*
 * 1. 模拟用户登录
 */

public class Test005 {
	public static void main(String[] args) {
		new Test005().go();
	}

	public void go() {
		userInput();
	}

	private void userInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入账号:");
		String userName = scanner.nextLine();
		System.out.println("请输入密码:");
		String password = scanner.nextLine();
		User user = new User(userName, password);
		new UserLogin().checkUserState(user);
		scanner.close();
	}
}

class UserLogin {
	private static int count = 0;
	private String userName = "RED";
	private String password = "432263";

	public void checkUserState(User user) {
		while (count < 3) {
			if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				System.out.println("登录成功!尝试次数:" + (count + 1));
				break;
			} else if (count < 2) {
				System.out.println("登录失败!");
				System.out.println("还可以尝试" + (2 - count) + "次!");
				count++;
				new Test005().go();
				break;
			} else {
				System.out.println("账号被锁定,请与管理员联系!");
				count++;
				System.out.println("***" + count);
			}

		}
	}

}

class User {
	private String userName;
	private String password;

	public User() {
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
