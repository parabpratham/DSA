package study.dsa.algo;

import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingIntervals {

	/*
	 * 
	 * Merge Overlapping Intervals Given a set of time intervals in any order,
	 * merge all overlapping intervals into one and output the result which
	 * should have only mutually exclusive intervals. Let the intervals be
	 * represented as pairs of integers for simplicity. For example, let the
	 * given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }. The intervals
	 * {1,3} and {2,4} overlap with each other, so they should be merged and
	 * become {1, 4}. Similarly {5, 7} and {6, 8} should be merged and become
	 * {5, 8}
	 */

	public class Interval implements Comparable<Interval> {
		int start, end;

		public Interval() {
			super();
		}

		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Interval i) {
			return this.start - i.start;
		}

	}

	public static void main(String[] args) {
		MergeOverlappingIntervals m = new MergeOverlappingIntervals();
		Interval[] intervals = { m.new Interval(1, 3), m.new Interval(7, 9),
				m.new Interval(4, 6), m.new Interval(8, 13) };
		Arrays.sort(intervals);

		Stack<Interval> stc = new Stack<MergeOverlappingIntervals.Interval>();
		stc.push(intervals[0]);
		for (int k = 1; k < intervals.length; k++) {
			Interval i = intervals[k];
			Interval top = stc.peek();
			if (top.end < i.start) {
				stc.push(i);
			} else if (top.end < i.end) {
				top.end = i.end;
				stc.pop();
				stc.push(top);
			}
		}

		while (!stc.empty()) {
			Interval t = stc.pop();
			System.out.println(t.start + " " + t.end);

		}

	}
}
