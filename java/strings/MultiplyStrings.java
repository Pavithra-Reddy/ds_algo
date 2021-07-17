package strings;
import java.util.Scanner;

/*
 	Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
	Input: num1 = "2", num2 = "3"
	Output: "6"

 */

public class MultiplyStrings {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		System.out.println(multiply(a,b));
		sc.close();
	}
	
	private static String multiply(String a, String b) {
	    if(a.equals("0") || b.equals("0"))
	        return "0";
	    
	    if(a.equals("1")) {
	    	return b;
	    }
	    
	    if(b.equals("1")) {
	    	return a;
	    }
	    
	    int len1 =  a.length();
	    int len2 =  b.length();
	    int[] mulRes = new int[len1 + len2];
	    
	    int curr = mulRes.length;
	    
	    for(int i = len1-1; i >=0 ; i--) {
	        int k = --curr;
	        
	        for(int j = len2 - 1; j >= 0; j--) {
	            int n1 = a.charAt(i) - '0';
	            int n2 = b.charAt(j) - '0';
	            int mulResuct = n1 * n2 + mulRes[k];
	            
	            mulRes[k] = mulResuct%10;
	            k --;
	            mulRes[k] = mulRes[k] + mulResuct/10;
	        }
	    }
	    
	    int i = 0;
	    while(mulRes[i] == 0 ) {
	        i++;
	    }
	    
		StringBuilder res = new StringBuilder();
	    while(i < mulRes.length) {
	        res.append(mulRes[i]);
	        i++;
	    }
		
	    return res.toString();
	}
	 
}
