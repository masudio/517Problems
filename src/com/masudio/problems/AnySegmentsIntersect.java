package com.masudio.problems;

import java.util.ArrayList;
import java.util.List;

public class AnySegmentsIntersect {
	
	public boolean anySegmentsIntersect(SegmentHandler segmentHandler)
	{
		List<Segment> T = new ArrayList<Segment>();
		List<Point> sortedPoints = segmentHandler.getSortedPoints();
		
		for(int i = 0; i < sortedPoints.size(); i++)
		{
			Point p = sortedPoints.get(i);
			Segment s = p.owner;
			
			if(p.startPoint)
			{
				insert(T, s);
				Segment aboveS = above(T, s);
				Segment belowS = below(T, s);
				if((null != aboveS && segmentsIntersect(s.start, s.end, aboveS.start, aboveS.end)) || // segments intersect is O(1),
					(null != belowS && segmentsIntersect(s.start, s.end, belowS.start, belowS.end)))  // and from the last algorithm studied
				{
					return true;
				}
			}
			else // assume all points are either start or end of a segment
			{
				Segment aboveS = above(T, s);
				Segment belowS = below(T, s);
				if((null != aboveS && null != belowS) &&
					(aboveS.end.below(belowS.end) && aboveS.end.leftOfOrEqualTo(belowS.end)))
				{
					return true;
				}
				delete(T, s);
			}
		}
		
		return false;
	}

	/**
	 * assume only inserting start points of segments.
	 * 
	 * @param T
	 * @param s
	 */
	public void insert(List<Segment> T, Segment s)
	{
		for(int i = 0; i < T.size(); i++)
		{
			if(T.get(i).start.y <= s.start.y)
			{
				T.add(i, s);
				return;
			}
		}
		
		T.add(s);
	}
	
	private Segment above(List<Segment> T, Segment s)
	{
		int index = T.indexOf(s);
		
		return 0 == index ? null : T.get(index - 1);
	}
	
	private Segment below(List<Segment> T, Segment s)
	{
		int index = T.indexOf(s);
		
		return (T.size() - 1 == index) ? null : T.get(index + 1);
	}
	
	private void delete(List<Segment> T, Segment s)
	{
		T.remove(s);
	}
}
