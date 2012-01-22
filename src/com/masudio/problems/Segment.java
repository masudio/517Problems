package com.masudio.problems;

public class Segment {

	public Point start;
	public Point end;
	
	public Segment(Point start, Point end)
	{
		start.owner = this;
		end.owner = this;
		this.start = start;
		this.end = end;
	}
	
	public static Segment getSegment(int x1, int y1, int x2, int y2)
	{
		Segment result = new Segment(new Point(x1, y1, true), new Point(x2, y2, false));
		
		return result;
	}
}
