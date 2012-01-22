package com.masudio.problems.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.masudio.problems.Point;
import com.masudio.problems.Segment;
import com.masudio.problems.SegmentHandler;

public class SegmentHandlerTest extends TestCase
{
	public void testShouldPass()
	{
		assertTrue(true);
	}

	public void testSortSegmentStartEndpoints()
	{
		ArrayList<Segment> segments = new ArrayList<Segment>();
		
		segments.add(Segment.getSegment(2,6,4,7));
		segments.add(Segment.getSegment(6,7,8,5));
		segments.add(Segment.getSegment(5,6,8,6));
		segments.add(Segment.getSegment(3,5,5,4));
		
		SegmentHandler sut = new SegmentHandler(segments);
		List<Point> result = sut.getSortedPoints();
		
		Point current;
		for(int i = 0; i < result.size() - 1; i++)
		{
			current = result.get(i);
			assertTrue(current.x <= result.get(i + 1).x);
		}
	}
	
	public void testSortSegmentStartEndPointsEqualXsShouldBeSortedByYValueAscending()
	{
		ArrayList<Segment> segments = new ArrayList<Segment>();
		
		segments.add(Segment.getSegment(2,6,4,7));
		segments.add(Segment.getSegment(6,7,8,5));
		segments.add(Segment.getSegment(5,6,8,6));
		segments.add(Segment.getSegment(3,5,5,4));
		
		SegmentHandler sut = new SegmentHandler(segments);
		List<Point> result = sut.getSortedPoints();
		
		Point current;
		for(int i = 0; i < result.size() - 1; i++)
		{
			current = result.get(i);
			
			if(current.x == result.get(i + 1).x)
			{
				assertTrue(current.y <= result.get(i + 1).y);
			}
		}
	}
}
