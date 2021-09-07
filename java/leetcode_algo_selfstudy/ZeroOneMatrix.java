package leetcode_algo_selfstudy;

public class ZeroOneMatrix {

	public static void main(String[] args) {
		int[][] mat = {{0,1,0},{1,1,1},{1,1,1}};
		mat = updateMatrix(mat);
		for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
	}

	public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] != 0){
                    int min = m + n;
                    if((i-1) >= 0){
                        min = Math.min(min,mat[i-1][j] + 1);
                    }
                    if((j-1) >= 0){
                        min = Math.min(min,mat[i][j-1] + 1);
                    }  
                    mat[i][j] = min;
                }
            }
        }
        
        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(mat[i][j] != 0){
                    int min = m + n;
                    if((i+1) < m){
                        min = Math.min(min, mat[i+1][j] + 1);
                    }
                    if((j+1) < n){
                        min = Math.min(min, mat[i][j+1] + 1);
                    }   
                    mat[i][j] = Math.min(mat[i][j], min);
                }
            }
        }
        
        return mat;
    }
}
