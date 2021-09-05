package leetcode_algo_selfstudy;

public class FloodFill {

	public static void main(String[] args) {
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		int sr = 1;
		int sc = 1;
		int newColor = 2;
		image = floodFill(image, sr, sc, newColor);
		
		for(int i = 0; i < image.length; i++) {
			for(int j = 0; j < image[0].length; j++) {
				System.out.print(image[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (newColor != image[sr][sc]) {
			dfs(image, sr, sc, newColor, image[sr][sc]);
		}
		return image;
	}

	public static void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
		if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oldColor) {
			return;
		}

		image[sr][sc] = newColor;
		dfs(image, sr + 1, sc, newColor, oldColor);
		dfs(image, sr, sc + 1, newColor, oldColor);
		dfs(image, sr - 1, sc, newColor, oldColor);
		dfs(image, sr, sc - 1, newColor, oldColor);

		return;
	}

}
