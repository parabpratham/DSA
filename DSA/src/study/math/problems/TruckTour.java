package study.math.problems;

public class TruckTour {

	public class PetroDist {

		public int petrol;
		public int distance;

		public PetroDist(int petrol, int distance) {
			this.petrol = petrol;
			this.distance = distance;
		}
	}

	public static void main(String[] args) {
		TruckTour t = new TruckTour();
		PetroDist[] p = new PetroDist[5];
		p[0] = t.new PetroDist(4, 6);
		p[1] = t.new PetroDist(6, 5);
		p[2] = t.new PetroDist(7, 3);
		p[3] = t.new PetroDist(5, 11);
		p[4] = t.new PetroDist(4, 1);

		int tempArray[] = new int[5];

		for (int i = 0; i < p.length; i++)
			tempArray[i] = p[i].petrol - p[i].distance;

		int result = findStartPoint(tempArray);
	}

	private static int findStartPoint(int[] a) {

		int i = 0, leftSum = 0, rightSum = 0;
		int start = 0;

		while (a[i] < 0) {
			leftSum += a[i++];
		}

		start = i;
		for (int j = i; j < a.length; j++) {
			rightSum += a[j];
			if (j == a.length - 1) {
				if (rightSum + leftSum >= 0)
					return start;
				else
					return -1;
			}
			if (rightSum < 0) {
				leftSum += rightSum;
				rightSum = 0;
				start = j + 1;
			}
		}
		return start;
	}
}
