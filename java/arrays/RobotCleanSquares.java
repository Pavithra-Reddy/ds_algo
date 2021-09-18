package arrays;

public class RobotCleanSquares {

	public static int res = 0;
	public static void main(String[] args) {
		String[] R = {"....X.","X....X",".X...X",".....X","X..XXX"};
		System.out.println(getCleanedSquares(R));
	}
	
	public static int getCleanedSquares(String[] R) {
		int[][] grid = new int[R.length][R[0].length()];
		for(int i = 0; i < R.length; i++) {
			for(int j = 0; j < R[i].length(); j++) {
				if(R[i].charAt(j) == '.') {
					grid[i][j] = 0;
				}
				else {
					grid[i][j] = 1;
				}
			}
		}
		int i = 0;
		int j = 0;
		int prevRes = 0;
		do {
			prevRes = res;
			j = rightSteps(grid, i, j);
			i = downSteps(grid, i, j);
			j = leftSteps(grid, i, j);
			i = upSteps(grid, i, j);
		} while((res  - prevRes) > 0);
		
		return res;
    }
	
	private static int rightSteps(int[][] grid, int i, int j) {
		//System.out.println("right");
		for(; j < grid[0].length; j++) {
			if(grid[i][j] == 0) {
				res++;
				//System.out.println((i+1) + " " + (j+1));
				grid[i][j] = 2;
			}
			else if(grid[i][j] == 1){
				break;
			}
		}
		return j-1;
	}
	
	private static int downSteps(int[][] grid, int i, int j) {
		//System.out.println("down");
		for(; i < grid.length; i++) {
			if(grid[i][j] == 0) {
				res++;
				//System.out.println((i+1) + " " + (j+1));
				grid[i][j] = 2;
			}
			else if(grid[i][j] == 1){
				break;
			}
		}
		return i-1;
	}
	
	private static int leftSteps(int[][] grid, int i, int j) {
		//System.out.println("left");
		for(; j >= 0; j--) {
			if(grid[i][j] == 0) {
				res++;
				//System.out.println((i+1) + " " + (j+1));
				grid[i][j] = 2;
			}
			else if(grid[i][j] == 1){
				break;
			}
		}
		return j+1;
	}
	
	private static int upSteps(int[][] grid, int i, int j) {
		//System.out.println("up");
		for(; i >= 0; i--) {
			if(grid[i][j] == 0) {
				res++;
				//System.out.println((i+1) + " " + (j+1));
				grid[i][j] = 2;
			}
			else if(grid[i][j] == 1){
				break;
			}
		}
		return i+1;
	}

}
