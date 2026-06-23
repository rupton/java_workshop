package org.cryptnerd.workshop.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

public class SwingUI extends JFrame implements ActionListener {

	JLabel text, clicked;
	JButton button, clickButton;
	JPanel panel;
	private boolean _clickedMode = true;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(_clickedMode) {
			text.setText("Button Clicked");
			button.setText("Click Again");
			_clickedMode = false;
		}else {
			text.setText("I'm a simple program");
			button.setText("Click Me");
			_clickedMode = true;
		}

	}

	public static void main(String[] args) {
		SwingUI frame = new SwingUI();
		frame.setTitle("SwingUI");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	SwingUI(){
		text = new JLabel("I'm a simple Program");
		clicked = new JLabel("Button Clicked");
		button = new JButton("Click Me");
		button.addActionListener(this);
		clickButton = new JButton("Click Again");
		panel = new JPanel();
		panel.setLayout(new BorderLayout(1,1));
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);
		panel.add(BorderLayout.CENTER, text);
		panel.add(BorderLayout.SOUTH, button);
	}
}
