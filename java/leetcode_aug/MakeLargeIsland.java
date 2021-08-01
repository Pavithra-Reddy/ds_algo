package leetcode_aug;

/*
 You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.

 

Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MakeLargeIsland {

	public static void main(String args[]) {
		int[][] grid = {{1,1,1},{0,0,0},{1,1,1}};
		System.out.println(largestIsland(grid));
	}

	public static int largestIsland(int[][] grid) {
		HashMap<Integer,Integer> areaMap = new HashMap<Integer,Integer>();
		int areaKey = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j] == 1){
					areaKey--;
					int area = getArea(grid, i, j, areaKey); 
					areaMap.put(areaKey, area);
				}
			}
		}

		int max = 0;
		if(areaMap.containsKey(areaKey)){
			max = areaMap.get(areaKey);
		}
		else{
			return 1;
		}

		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(grid[i][j] == 0){

					Set<Integer> areaKeys = new HashSet<Integer>();
					areaKeys.add(getMapKey(grid,i-1,j));
					areaKeys.add(getMapKey(grid,i+1,j));
					areaKeys.add(getMapKey(grid,i,j-1));
					areaKeys.add(getMapKey(grid,i,j+1));

					int currMax = 0;
					for(Integer key : areaKeys){
						if(areaMap.containsKey(key))
							currMax += areaMap.get(key);
					}
					max = Math.max(currMax + 1,max);
				}
			}
		}

		return max;
	}

	private static int getArea(int[][] grid, int i, int j, int areaKey){
		if(i < 0 || i > grid.length-1 || j < 0 || j > grid.length -1 || grid[i][j] != 1){
			return 0;
		}

		grid[i][j] = areaKey;

		int area = 1;
		area += getArea(grid, i-1, j, areaKey);
		area += getArea(grid, i+1, j, areaKey);
		area += getArea(grid, i, j-1, areaKey);
		area += getArea(grid, i, j+1, areaKey);

		return area;
	}

	private static int getMapKey(int[][] grid, int i, int j){
		if(i < 0 || i > grid.length-1 || j < 0 || j > grid.length -1){
			return 0;
		}
		return grid[i][j];
	}
}