package leetcode_algo_selfstudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

	public static void main(String[] args) {
		List<Integer> row1 = new ArrayList<>(Arrays.asList(2));
		List<Integer> row2 = new ArrayList<>(Arrays.asList(3,4));
		List<Integer> row3 = new ArrayList<>(Arrays.asList(6,5,7));
		List<Integer> row4 = new ArrayList<>(Arrays.asList(4,3,8,1));
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();	
		triangle.add(row1);
		triangle.add(row2);
		triangle.add(row3);
		triangle.add(row4);
		
		System.out.println(minimumTotal(triangle));

	}

	public static int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            List<Integer> row = triangle.get(i+1);
			for (int j = 0; j <= i ; j++) {
				int minSum = Math.min(row.get(j), row.get(j+1)) + triangle.get(i).get(j);
				triangle.get(i).set(j, minSum);
			}
		}
		return triangle.get(0).get(0);
    }
}
