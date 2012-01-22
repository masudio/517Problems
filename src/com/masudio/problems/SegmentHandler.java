package com.masudio.problems;

import java.util.ArrayList;
import java.util.List;

public class SegmentHandler {

	public List<Segment> segments;
	public List<Point> sortedPoints;
	
	public SegmentHandler(List<Segment> initialSegmentList)
	{
		segments = initialSegmentList;
		
		sortedPoints = sortPointsOf(getPointsOf(segments));
	}

	public List<Point> getSortedPoints()
	{
		return sortedPoints;
	}
	
	private List<Point> getPointsOf(List<Segment> segments)
	{
		List<Point> result = new ArrayList<Point>();
		
		for(int i = 0; i < segments.size(); i++)
		{
			Point currentStart = segments.get(i).start;
			Point currentEnd = segments.get(i).end;
			
			result.add(currentStart);
			result.add(currentEnd);
		}
		
		return result;
	}
	
	private List<Point> sortPointsOf(List<Point> points)
	{
		if(points.size() <= 1)
		{
			return points;
		}
		
		int mid = points.size() / 2;
		
		return merge(sortPointsOf(points.subList(0, mid)), sortPointsOf(points.subList(mid, points.size())));
	}
	
	private List<Point> merge(List<Point> left, List<Point> right)
	{
		int i = 0, j = 0;
		List<Point> result = new ArrayList<Point>();
		
		while(i < left.size() && j < right.size())
		{
			Point leftCurrent = left.get(i);
			Point rightCurrent = right.get(j);
			
			if(leftCurrent.x < rightCurrent.x)
			{
				result.add(leftCurrent);
				i++;
			}
			else if(leftCurrent.x == rightCurrent.x)
			{
				if(leftCurrent.y < rightCurrent.y)
				{
					result.add(leftCurrent);
					i++;
				}
				else
				{
					result.add(rightCurrent);
					j++;
				}
			}
			else
			{
				result.add(rightCurrent);
				j++;
			}
		}
		
		while(i < left.size())
		{
			result.add(left.get(i++));
		}
		while(j < right.size())
		{
			result.add(right.get(j++));
		}
		
		return result;
	}
}
