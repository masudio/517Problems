package com.masudio.problems;

public class Point {

	public int x;
	public int y;
	public Segment owner;
	public boolean startPoint;
	
	public Point(int x, int y, boolean startPoint)
	{
		this.x = x;
		this.y = y;
		this.startPoint = startPoint;
	}

	public boolean below(Point other)
	{
		return this.y < other.y;
	}
	
	public boolean above(Point other)
	{
		return this.y > other.y;
	}
	
	public boolean leftOfOrEqualTo(Point other)
	{
		return this.x <= other.x;
	}
}
