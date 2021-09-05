package leetcode_algo_selfstudy;

public class MaxAreaOfIsland {

	public static void main(String[] args) {
		int[][] grid = {{1,1,1},{1,1,0},{1,0,1}};
		System.out.println(maxAreaOfIsland(grid));
	}
	
	public static int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1){
                    max = Math.max(dfs(grid, i, j), max);
                }
			}
		}
        return max;
    }
    
    public static int dfs(int[][] grid, int sr, int sc) {
		if (sr < 0 || sr >= grid.length || sc < 0 || sc >= grid[0].length || grid[sr][sc] == 0) {
			return 0;
		}

		grid[sr][sc] = 0;
        int area = 1;
		area += dfs(grid, sr + 1, sc);
		area += dfs(grid, sr, sc + 1);
		area += dfs(grid, sr - 1, sc);
		area += dfs(grid, sr, sc - 1);

		return area;
	}

}
