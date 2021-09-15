package leetcode_algo_selfstudy;

public class Search2DMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		System.out.println(searchMatrix(matrix,3));

	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int first = 0;
        int last = m * n - 1;
        while (first != last){
            int mid = first + ((last - first) / 2);
            if (matrix[mid / m][mid % m] < target)
                first = mid + 1;
            else 
                last = mid;
        }
        return matrix[last / m][last % m] == target;
    }

}
