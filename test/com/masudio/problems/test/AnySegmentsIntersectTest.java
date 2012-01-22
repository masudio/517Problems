package com.masudio.problems.test;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.masudio.problems.AnySegmentsIntersect;
import com.masudio.problems.Segment;
import com.masudio.problems.SegmentHandler;

public class AnySegmentsIntersectTest extends TestCase {

	public void testAnySegmentsIntersectTrue()
	{
		ArrayList<Segment> segments = new ArrayList<Segment>();
		segments.add(Segment.getSegment(2,6,4,7));
		segments.add(Segment.getSegment(6,7,8,5));
		segments.add(Segment.getSegment(5,6,8,6));
		segments.add(Segment.getSegment(3,5,5,4));
		
		AnySegmentsIntersect sut = new AnySegmentsIntersect();
		SegmentHandler segmentHandler = new SegmentHandler(segments);
		
		boolean result = sut.anySegmentsIntersect(segmentHandler);
		
		assertTrue(result);
	}

	public void testAnySegmentsIntersectFalse()
	{
		ArrayList<Segment> segments = new ArrayList<Segment>();
		segments.add(Segment.getSegment(2,6,4,7));
		segments.add(Segment.getSegment(6,7,8,7));
		segments.add(Segment.getSegment(5,6,8,6));
		segments.add(Segment.getSegment(3,5,5,4));
		
		AnySegmentsIntersect sut = new AnySegmentsIntersect();
		SegmentHandler segmentHandler = new SegmentHandler(segments);
		
		boolean result = sut.anySegmentsIntersect(segmentHandler);
		
		assertFalse(result);
	}
	
	public void testAnySegmentsIntersectAgain()
	{
		ArrayList<Segment> segments = new ArrayList<Segment>();
		segments.add(Segment.getSegment(2,6,4,7));
		segments.add(Segment.getSegment(5,8,8,5));
		segments.add(Segment.getSegment(5,6,6,6));
		segments.add(Segment.getSegment(3,5,5,4));
		
		AnySegmentsIntersect sut = new AnySegmentsIntersect();
		SegmentHandler segmentHandler = new SegmentHandler(segments);
		
		boolean result = sut.anySegmentsIntersect(segmentHandler);
		
		assertFalse(result);
	}
}
