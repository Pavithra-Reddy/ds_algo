package graphs;

public class ClosedIslands {

	public static void main(String[] args) {
		int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
		System.out.println(closedIsland(grid));
	}
	
	
	private static int closedIsland(int[][] grid) {
	      if(grid.length == 0) 
	          return 0;
	        
	        int n = grid.length;
	        int m = grid[0].length;
	      
	        int c = 0;
	        
	        for(int i = 0; i < n; i++)
	        {
	            for(int j = 0; j < m; j++) 
	            {
	                if((i == 0 || j == 0 || i == n-1 || j == m-1) && grid[i][j] == 0)
	                {
	                    dfs(grid, i, j, n, m);
	                }
	            }
	        }
	        for(int i = 0; i < n; i++)
	        {
	            for(int j = 0; j < m; j++) 
	            {
	                if(grid[i][j] == 0)
	                {
	                    dfs(grid, i, j, n, m);
	                    c++;
	                }
	            }
	        }
	        return c;  
	    }
	    
		private static void dfs(int[][] grid, int i, int j, int n, int m)
	    {
	        
	        if(i < 0 || i > n-1 || j < 0 || j > m-1 || grid[i][j] == 1) 
	            return;
	        
	        grid[i][j] = 1;
	        
	        dfs(grid, i-1, j, n, m);
	        dfs(grid, i+1, j, n, m);
	        dfs(grid, i, j-1, n, m);
	        dfs(grid, i, j+1, n, m);
	        
	    }
	    

}
