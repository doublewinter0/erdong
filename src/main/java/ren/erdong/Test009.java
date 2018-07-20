
package ren.erdong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 *	简单的 Gui 测试
 */
public class Test009 {
	// Test09 tt = new Test09(); // Stack Overflow Error
	JFrame frame;
	JButton button;
	JLabel nameText;
	JLabel infoText;

	// MyDrawPanel drawPanel;
	public static void main(String[] args) {

		Test009 t = new Test009();
		t.go();

	}


	public void go() {
		frame = new JFrame("作者:任二冬");
		button = new JButton("点我开始");
		nameText = new JLabel("老衲好羞射", JLabel.CENTER);
		infoText = new JLabel("随机点名器ProPlus", JLabel.CENTER);
		nameText.setFont(new Font("微软雅黑", Font.BOLD, 54));
		infoText.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		button.addActionListener(new MyListener());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(BorderLayout.NORTH, infoText);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, nameText);
		frame.setSize(300, 300);

		frame.setVisible(true);
	}

	class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.repaint();
		}
	}

}
