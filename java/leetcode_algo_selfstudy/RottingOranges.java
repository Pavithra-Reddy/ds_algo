package leetcode_algo_selfstudy;

public class RottingOranges {

	public static void main(String[] args) {
		int[][] mat = {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println(orangesRotting(mat));

	}
	
	public static int orangesRotting(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int k = 0;
		int time = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1)
					k++;
			}
		}

		int f = k;
		while (k > 0) {
			f = k;
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == time + 2) {
						if ((i + 1) < m && grid[i + 1][j] == 1) {
							grid[i + 1][j] = time + 3;
							k--;
						}
						if ((j + 1) < n && grid[i][j + 1] == 1) {
							grid[i][j + 1] = time + 3;
							k--;
						}
						if ((i - 1) >= 0 && grid[i - 1][j] == 1) {
							grid[i - 1][j] = time + 3;
							k--;
						}
						if ((j - 1) >= 0 && grid[i][j - 1] == 1) {
							grid[i][j - 1] = time + 3;
							k--;
						}
					}
				}

			}
			time++;
			if (k == f)
				return -1;
		}
		
		return time;
	}

}
