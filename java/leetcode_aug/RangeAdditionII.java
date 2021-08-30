package leetcode_aug;

public class RangeAdditionII {

	public static void main(String[] args) {
		int[][] ops = new int[2][2];
		ops[0][0] = 1;
		ops[0][1] = 2;
				
		ops[1][0] = 3;
		ops[1][1] = 3;
		System.out.println(maxCount(3,3,ops));

	}
	
	public static int maxCount(int m, int n, int[][] ops) {
        int r = m;
        int c = n;

        for (int i = 0; i < ops.length; i++) {
            r = Math.min(r, ops[i][0]);
            c = Math.min(c, ops[i][1]);
        }

        return r*c;
    }

}
