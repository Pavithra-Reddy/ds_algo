import java.util.Scanner;

/*	
 	Given a positive integer n, return the nth term of the count-and-say sequence.
 	Input: n = 4
	Explanation:
	Output: "1211"
	countAndSay(1) = "1"
	countAndSay(2) = say "1" = one 1 = "11"
	countAndSay(3) = say "11" = two 1's = "21"
	countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 */


class CountAndSay {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(countAndSay(n));
		
		sc.close();
	}
	
	public static String countAndSay(int n) {
       String s = "1";
       for(int i = 1; i < n; i++) {
    	   s = getCountString(s);
       }
       return s;
    }

	private static String getCountString(String s) {
		StringBuilder sb = new StringBuilder();
		int c = 1;
		int i = 0;
		for(i = 0; i < s.length()-1; i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				c++;
			}
			else {
				sb.append(c+""+s.charAt(i));
				c = 1;
			}
		}
		sb.append(c+""+s.charAt(i));
		return sb.toString();
	}
}
