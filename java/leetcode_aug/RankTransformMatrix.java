package leetcode_aug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RankTransformMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{20,-21,14},{-19,4,19},{22,-47,24},{-19,4,19}};
		int[][] res = matrixRankTransform(matrix);
		for(int i = 0; i < res.length; i++) {
			for(int j = 0; j < res[0].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] matrixRankTransform(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		TreeMap<Integer, List<int[]>> map = new TreeMap<>();
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				List<int[]> list = map.getOrDefault(matrix[i][j], new ArrayList<>());
				list.add(new int[]{i, j});
				map.put(matrix[i][j], list);
			}
		}

		int[] rowMin = new int[n];
		int[] colMin = new int[m];
		int[][] res = new int[n][m];
		for(Map.Entry<Integer, List<int[]>> sameValueEntry: map.entrySet()) {
			ArrayList<int[]> sameList = new ArrayList<>(sameValueEntry.getValue());

			int[] arr = new int[sameList.size()];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = i;
			}
			HashMap<Integer, List<Integer>> rowMap = new HashMap<>();
			HashMap<Integer, List<Integer>> colMap = new HashMap<>();
			for(int i = 0; i < sameList.size(); i++) {
				int[] point = sameList.get(i);
				List<Integer> rowList = rowMap.getOrDefault(point[0], new ArrayList<>());
				List<Integer> colList = colMap.getOrDefault(point[1], new ArrayList<>());

				rowList.add(i);
				colList.add(i);
				rowMap.put(point[0], rowList);
				colMap.put(point[1], colList);
			}

			for(Map.Entry<Integer, List<Integer>> re: rowMap.entrySet()) {
				List<Integer> rowList = re.getValue();
				for(int i = 1; i < rowList.size(); i++) {
					union(rowList.get(i - 1), rowList.get(i), arr);
				}
			}

			for(Map.Entry<Integer, List<Integer>> ce: colMap.entrySet()) {
				List<Integer> colList = ce.getValue();
				for(int i = 1; i < colList.size(); i++) {
					union(colList.get(i - 1), colList.get(i), arr);
				}
			}

			HashMap<Integer, List<int[]>> combinedList = new HashMap<>();
			for(int i = 0; i < arr.length; i++) {
				int group = find(i, arr);
				List<int[]> list = combinedList.getOrDefault(group, new ArrayList<>());
				list.add(sameList.get(i));
				combinedList.put(group, list);
			}

			for(Map.Entry<Integer, List<int[]>> e: combinedList.entrySet()) {
				int rank = 0;
				List<int[]> ls = e.getValue();

				for(int[] ind: ls) {
					rank = Math.max(rank, rowMin[ind[0]]);
					rank = Math.max(rank, colMin[ind[1]]);
				}

				for(int[] ind: ls) {
					res[ind[0]][ind[1]] = rank + 1;
					rowMin[ind[0]] = rank + 1;
					colMin[ind[1]] = rank + 1;
				}
			}
		}
		return res;
	}

	private static int find(int i, int[] arr) {
		if(arr[i] == i) return i;
		else {
			arr[i] = find(arr[i], arr);
			return arr[i];
		}
	}

	private static void union(int i, int j, int[] arr) {
		i = find(i, arr);
		j = find(j, arr);
		arr[j] = i;
	}

}
