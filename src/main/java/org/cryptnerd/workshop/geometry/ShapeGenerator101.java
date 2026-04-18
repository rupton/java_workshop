/**
 * This is a simple class to practice drawing geometric shapes in Java
 */
package org.cryptnerd.workshop.geometry;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics2D;
/**
 * 
 */
public class ShapeGenerator101 extends JComponent {

	private static final int RIGHT_BORDER_FIX = 1;
	private static final int RECT_WIDTH = 200;
	private static final int RECT_HEIGHT = 50;
	private static final int WINDOW_WIDTH = 600;
	private static final int WINDOW_HEIGHT = 600;
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		System.out.println(getWidth());
		Graphics2D graphics = (Graphics2D) g;
		graphics.drawRect(getWidth() - RECT_WIDTH, 0, RECT_WIDTH - RIGHT_BORDER_FIX, RECT_HEIGHT);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create a component to house the shapes
		JFrame frame = new JFrame("Geometric Shapes");
		frame.setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new ShapeGenerator101());
		frame.setVisible(true);

	}

}
