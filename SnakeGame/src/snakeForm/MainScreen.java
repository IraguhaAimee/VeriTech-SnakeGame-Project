/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeForm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Aimee
 */
public class MainScreen extends JFrame implements ActionListener {

	private static final long serialVersionUID = -1299314404835604855L;

	JRadioButton levels[] = new JRadioButton[3];
	String levelStrings[] = { "Easy", "Normal", "Hard" };
	MainScreenPanel buttonPanel = null;

	public MainScreen() {

		buttonPanel = new MainScreenPanel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(320, 127, 710, 400);
		setResizable(false);
		buttonPanel.setBackground(Color.BLACK);
		for (int i = 0; i < levels.length; i++) {
			levels[i] = new JRadioButton(levelStrings[i]);
			levels[i].addActionListener(this);
			levels[i].setBackground(Color.YELLOW);
			levels[i].setBounds(260, 200 + i * 50, 80, 30);
			buttonPanel.add(levels[i]);
		}

		buttonPanel.setLayout(null);
		getContentPane().add(buttonPanel);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == levels[0]) {

			new GameBoardWindow(1);
			setVisible(false);
			dispose();

		}

		if (obj == levels[1]) {

			new GameBoardWindow(2);
			setVisible(false);
			dispose();
		}

		if (obj == levels[2]) {

			new GameBoardWindow(3);
			setVisible(false);
			dispose();
		}
	}

	@SuppressWarnings("serial")
	class MainScreenPanel extends JPanel {

		MainScreenPanel() {
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;

			g2.setColor(Color.RED);
			g2.setFont(new Font("Comic Sans MS", Font.BOLD, 45));
			g2.drawString("Veri Tech Snake Game", 200, 115);
			g2.setColor(Color.ORANGE);
			g2.drawString("Aimee", 210, 150);
		}
	}
}