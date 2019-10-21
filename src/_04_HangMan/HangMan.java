package _04_HangMan;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	JPanel panel = new JPanel();
	Stack<String> words = new Stack<String>();
	Utilities util = new Utilities();
	String current = "";
	StringBuilder sb;
	int lives = 10;

	public static void main(String[] args) {
		HangMan yeet = new HangMan();
		yeet.start();
	}

	void start() {
		frame.add(panel);
		panel.add(label);
		frame.addKeyListener(this);
		String num = JOptionPane.showInputDialog("Enter a number for the number of words to do.(up to 266)");
		int number = Integer.parseInt(num);
		for (int i = 0; i <= number; i++) {
			String toBePushed = util.readRandomLineFromFile("dictionary.txt");
			if (!words.contains(toBePushed)) {
				words.push(toBePushed);
			} else {
				i--;
			}
		}
		frame.setVisible(true);
		word();
	}

	void word() {
		current = words.pop();
		for (int j = 0; j < current.length(); j++) {
			label.setText(label.getText() + "_");
		}
		sb = new StringBuilder(label.getText());
		frame.pack();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		boolean letterFound = false;
		for (int i = 0; i < current.length(); i++) {
			if (lives != 0) {
				if (current.charAt(i) == e.getKeyChar()) {
					letterFound = true;
					sb.setCharAt(i, current.charAt(i));
					label.setText(sb.toString());
					frame.pack();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Out of lives!");
			}
		}
		if (!letterFound) {
			lives--;
		}
		if (label.getText().equals(current)) {
			label.setText("");
			word();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
