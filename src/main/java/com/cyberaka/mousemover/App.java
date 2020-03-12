package com.cyberaka.mousemover;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

/** 
 * A simple app to move the mouse pointer 1 pixel back and forth
 * to prevent screen from getting locked.
 * 
 * @author Abhinav
 *
 */
public class App {

	public static final int SLEEP_INTERVAL = 2000;
	public static final int X_DIFF = 10;
	public static final int Y_DIFF = 10;
	public static void main(String[] args) throws Exception {
		Robot r = new Robot();
		Point p;
		int counter = 0; boolean flag = false;
		while (true) {
			p = MouseInfo.getPointerInfo().getLocation();
			r.mouseMove((int) p.getX() + (flag? -X_DIFF: X_DIFF), (int) p.getY() + (flag? -Y_DIFF: Y_DIFF));
			counter++;
			flag = !flag;
			System.out.print((flag? "-": "+"));
			Thread.sleep(SLEEP_INTERVAL);
			if (counter % 80 == 0) {
				System.out.println();
			}
		}
	}

}
