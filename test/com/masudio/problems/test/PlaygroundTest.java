package com.masudio.problems.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.masudio.problems.AnySegmentsIntersect;
import com.masudio.problems.Segment;

public class PlaygroundTest extends TestCase {

	public void testReferencedObjectChangedInMethod()
	{
		AnySegmentsIntersect sut = new AnySegmentsIntersect();
		List<Segment> input = new ArrayList<Segment>();
		Segment inputSegment = Segment.getSegment(1,1,2,2);
		sut.insert(input, inputSegment);
		
		assertEquals(1, input.size());
	}

}
