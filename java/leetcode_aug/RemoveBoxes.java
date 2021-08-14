package leetcode_aug;

public class RemoveBoxes {

	public static void main(String[] args) {
		int[] boxes = {2,5,10,9,4,8,6,9,9,1};
		System.out.println(removeBoxes(boxes));
	}

	public static int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] mem = new int[n][n][n];
        return dfs(boxes, mem, 0, n-1, 0);
    }
    private static int dfs(int[] boxes, int[][][] mem, int l, int r, int k) {
        if (l > r)
			return 0;
		
		if (mem[l][r][k] != 0)
			return mem[l][r][k];
		
		int points = (k + 1)*(k + 1) + dfs(boxes, mem, l+1, r, 0);
		
		for (int i = l+1; i <= r; i++) {
			if (boxes[i] == boxes[l]) {
				points = Math.max(points,
						dfs(boxes, mem, l+1, i-1, 0) + dfs(boxes, mem, i, r, k+1));
			}
		}
		
		mem[l][r][k] = points;
		
		return points;
    }
}
