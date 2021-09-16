package leetcode_algo_selfstudy;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		int[][] mat = {{1,2,3},{1,2,3},{1,2,3},{1,2,3}};
		
		System.out.println(spiralOrder(mat));

	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>(); 
        
        int n = matrix.length;
        int m = matrix[0].length;
        int u = 0;
        int d = n - 1;
        int l = 0;
        int r = m - 1;
        
        while (res.size() < n * m) {
            for (int j = l; j <= r && res.size() < n * m; j++)
                res.add(matrix[u][j]);
            
            for (int i = u + 1; i <= d - 1 && res.size() < n * m; i++)
                res.add(matrix[i][r]);
                     
            for (int j = r; j >= l && res.size() < n * m; j--)
                res.add(matrix[d][j]);
                        
            for (int i = d - 1; i >= u + 1 && res.size() < n * m; i--) 
                res.add(matrix[i][l]);
                
            l++; 
            r--; 
            u++; 
            d--; 
        }
        return res;
    }
}
