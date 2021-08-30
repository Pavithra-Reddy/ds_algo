package leetcode_algo_binarysearch;

public class FirstBadVersion {

	private static boolean[] versions = {false, false, false, false, true, true, true};

	public static void main(String[] args) {
		System.out.println(firstBadVersion(7));
	}
	
	public static int firstBadVersion(int n) {
        int first = 1;
        int last = n;
        int mid;
        while(first < last){
            mid =  first + ((last - first)/2);
            if(isBadVersion(mid)){
                last = mid;
            }
            else{
                first = mid+1;
            }
        }
        return last;
    }

	private static boolean isBadVersion(int i) {
		return versions[i];
	}

}
