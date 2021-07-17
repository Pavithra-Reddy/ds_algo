package strings;
import java.util.Scanner;

/*
 * Given two binary strings a and b, return their sum as a binary string.
 * Input: a = "11", b = "1"			Output: "100"
 */

class AddBinary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		System.out.println(addBinary(a,b));
		
		sc.close();
	}
	
    private static String addBinary(String a, String b) {
    	StringBuilder res = new StringBuilder();
    	int carry = 0;
    	int i = a.length() - 1, j = b.length() - 1;
    	while(i >= 0 || j >= 0) {
    		int s = ((i >= 0) ? a.charAt(i) - '0' : 0)  + ((j >= 0) ? b.charAt(j) - '0' : 0) + carry;
    		res.append(s%2);
    		carry = s/2;
    		i--;
    		j--;
    	}
    	
    	if(carry != 0) {
    		res.append("1");
    	}
    	
		return res.reverse().toString();
    }
}
