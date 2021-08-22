package leetcode_aug;

public class RectangleAreaII {
	public static long modulus = 1000000007;
	
	public static void main(String[] args) {
		int[][] rectangles = {{0,0,2,2},{1,0,2,3},{1,0,3,1}};
		System.out.println(rectangleArea(rectangles));
	}
	
    public static int rectangleArea(int[][] rectangles) {
        long res = 0;
        
        for (int[] r: rectangles) 
            res += getArea(r[0], r[1], r[2], r[3]);
        
        for (int i = 0; i < rectangles.length; i++){
            long overlappedArea= getOverlappedArea(rectangles, rectangles[i], i+1);
            res=(res - overlappedArea + modulus) % modulus;
        }
        return (int)res;
    }
    
    public static long getArea(int x1, int y1, int x2, int y2){
        return (long)(x2-x1)*(y2-y1);
    }
    
    public static long getOverlappedArea(int[][] rectangles, int[] rect, int i){
        if (i == rectangles.length) 
            return 0;
        
        int[] neighbour= rectangles[i++];
        int l= Math.max(rect[0], neighbour[0]);
        int r= Math.min(rect[2], neighbour[2]);
        int d= Math.max(rect[1], neighbour[1]);
        int u= Math.min(rect[3], neighbour[3]);
        
        if (l >= r || u <= d) 
            return getOverlappedArea(rectangles, rect, i);
        
        long res = getArea(l, d, r, u);
        
        if (rect[0] < neighbour[0]) 
            res = (res + getOverlappedArea(rectangles, new int[]{rect[0], rect[1], neighbour[0], rect[3]}, i)) % modulus;
        
        if (neighbour[2] < rect[2]) 
            res = (res + getOverlappedArea(rectangles, new int[]{neighbour[2], rect[1], rect[2], rect[3]}, i)) % modulus;
        
        if (rect[1] < neighbour[1]) 
            res = (res + getOverlappedArea(rectangles, new int[]{l, rect[1], r, neighbour[1]}, i)) % modulus;
        
        if (neighbour[3]<rect[3]) 
            res = (res + getOverlappedArea(rectangles, new int[]{l, neighbour[3], r, rect[3]}, i)) % modulus;
        return res;
    }

}
