package arrays;

import java.util.ArrayList;
import java.util.List;

/*
	Return the intersection of these two interval lists.
	For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 */
public class IntervalListIntersection {

	public static void main(String[] args) {
		int[][] list1 = {{0,2},{5,10},{13,23},{24,25}};
		int[][] list2 = {{1,5},{8,12},{15,24},{25,26}};
		int[][] list3 = intersect(list1,list2);
		for(int i = 0; i < list3.length;i++) {
			for(int j = 0; j <list3[i].length;j++) {
				System.out.print(list3[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static int[][] intersect(int[][] list1, int[][] list2) {
	    List<int[]> res = new ArrayList<int[]>();
	    int i = 0;
	    int j = 0;
	    while (i < list1.length && j < list2.length) {
	      int start = Math.max(list1[i][0], list2[j][0]);
	      int end = Math.min(list1[i][1], list2[j][1]);
	      if (start <= end)
	        res.add(new int[]{start, end});
	      if (list1[i][1] < list2[j][1])
	        i++;
	      else
	        j++;
	    }

	    return res.toArray(new int[res.size()][]);
	  }

}
