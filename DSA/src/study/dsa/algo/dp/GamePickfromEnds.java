package study.dsa.algo.dp;

public class GamePickfromEnds {

	// N pots, each with some number of gold coins, are arranged in a line. You
	// are playing a game against another player. You take turns picking a pot
	// of gold. You may pick a pot from either end of the line, remove the pot,
	// and keep the gold pieces. The player with the most gold at the end wins.
	// Develop a strategy for playing this game.
	
	//https://www.youtube.com/watch?v=WxpIHvsu1RI&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=30

	public class Data implements Comparable<Data> {
		int first;
		int second;

		public Data(int first, int second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public int compareTo(Data o) {
			return first - o.first;
		}
	}

	public static void main(String[] args) {

		GamePickfromEnds g = new GamePickfromEnds();
		int[] ip = { 3, 9, 1, 2 };
		int n = ip.length;
		Data[][] profit = new Data[ip.length][ip.length];

		for (int i = 0; i < n; i++)
			profit[i][i] = g.new Data(ip[i], 0);

		int i = 0;

		while (i < n) {

			for (int j = 0; j < n - i; j++) {
				for (int k = j; k < j + i; k++) {
					if (profit[j][i + j].first > profit[j + k + 1][i + j].first) {
						profit[j][i + j].first = profit[j - 1][i + j].first;
						profit[j][i + j].second = sum(ip, j - 1, i + j);
					} else {
						profit[j][i + j].first = profit[j + 1][i + j].first;
					}

				}

			}
		}

	}
}
