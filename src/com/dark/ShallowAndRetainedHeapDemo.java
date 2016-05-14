package com.dark;

//	MAT Test
public class ShallowAndRetainedHeapDemo {
	public static void main(String[] args) {
		Point a = new Point(0, 0);
		Point b = new Point(1, 1);
		Point c = new Point(2, 9);
		Point d = new Point(8, 3);
		Point e = new Point(4, 5);
		Point f = new Point(3, 7);
		Point g = new Point(7, 4);
		Line aLine = new Line(a, b);
		Line bLine = new Line(a, c);
		Line cLine = new Line(d, e);
		Line dLine = new Line(f, g);
		a = null;
		b = null;
		c = null;
		d = null;
		e = null;
		try {
			Thread.sleep(10000000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

}

class Point {
	private int x;
	private int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

class Line {
	private Point startPoint;
	private Point endPoint;

	public Line(Point startPoint, Point endPoint) {
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
}