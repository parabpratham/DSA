package study.os;

import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShortestJobFirst {

	public class Details implements Comparable<Details> {
		BigInteger arrival;
		BigInteger timeReqd;

		public Details(BigInteger arr, BigInteger t) {
			arrival = arr;
			timeReqd = t;
		}

		@Override
		public int compareTo(Details o) {
			return this.timeReqd.subtract(o.timeReqd).intValue();
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ShortestJobFirst s = new ShortestJobFirst();
		int no = sc.nextInt();
		Details[] d = new Details[no];
		for (int i = 0; i < no; i++)
			d[i] = s.new Details(BigInteger.valueOf(sc.nextInt()),
					BigInteger.valueOf(sc.nextInt()));

		sortAsPerTimeReqdTime(d);
		PriorityQueue<Details> eligible = new PriorityQueue<ShortestJobFirst.Details>();
		BigInteger currentTime = BigInteger.ZERO;
		int i = 0;
		int j = i;
		BigInteger averageWaiTime = BigInteger.ZERO;
		while (i < no) {
			if (eligible.isEmpty() && currentTime.compareTo(d[j].arrival) <= 0) {
				eligible.add(d[j]);
				currentTime = d[j].arrival;
				j++;
			}

			while (j < no && currentTime.compareTo(d[j].arrival) >= 0) {
				eligible.add(d[j]);
				if (++j == no)
					break;
			}
			Details curr = eligible.remove();
			currentTime = currentTime.add(curr.timeReqd);
			averageWaiTime = averageWaiTime.add(currentTime
					.subtract(curr.arrival));
			System.out.println(averageWaiTime);
			i++;
		}
		System.out.println(averageWaiTime.divide(BigInteger.valueOf(no)));
	}

	public static void sortAsPerTimeReqdTime(Details[] d) {

		for (int i = 0; i < d.length; i++) {
			boolean isSwapped = false;
			for (int j = 0; j < d.length - i - 1; j++) {
				if (d[j].arrival.compareTo(d[j + 1].arrival) > 0) {
					Details temp = d[j];
					d[j] = d[j + 1];
					d[j + 1] = temp;
					isSwapped = true;
				}
			}
			if (!isSwapped)
				break;
		}
	}
}
