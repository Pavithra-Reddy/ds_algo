package strings;
import java.util.Scanner;

/*	
 	Given a string s containing only digits, return the number of ways to decode it.
 	Input: s = "226"
	Output: 3
	Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */


class DecodeWays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(numDecodings(s));
		
		sc.close();
	}
	
	public static int numDecodings(String s) {
		int len = s.length();

        if(len == 0) {
            return 0;
        }
        
        int[] count = new int[len + 1];//stores count for each index
        count[len] = 1;
        count[len - 1] = s.charAt(len - 1) != '0' ? 1 : 0;
        
        for(int i = len - 2; i >= 0; i--) {
            if(s.charAt(i) != '0')  {
            	count[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? count[i + 1] + count[i + 2] : count[i + 1];
            }
        }
        
        return count[0];
    }	
}
