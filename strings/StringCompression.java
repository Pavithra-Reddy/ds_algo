import java.util.Scanner;

/*	
 	Given an array of characters chars, compress it using the following algorithm:

	Begin with an empty string s. For each group of consecutive repeating characters in chars:

	If the group's length is 1, append the character to s.
	Otherwise, append the character followed by the group's length.
	The compressed string s should not be returned separately, but instead be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.
	
	After you are done modifying the input array, return the new length of the array.
 */


class StringCompression {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		char[] charArr = n.toCharArray();
		int len = compress(charArr);
		for(int i = 0; i < len;i++)
			System.out.print(charArr[i] + " ");
		
		sc.close();
	}

	public static int compress(char[] chars) {
	       int p = 0;
	       int c = 0;
	       for(int i = 0; i< chars.length-1;i++){
	           if(chars[i] == chars[i+1]){
	               c++;
	           } else{
	               c++;
	               chars[p++] = chars[i];
	               if(c != 1){
	                   if(c >= 10){
	                       p = addMultipleDigitsToCharArray(chars,p,c);
	                   }
	                   else{
	                       chars[p++] = (char) ('0' + c%10);
	                   }
	               }
	               c = 0;
	           }
	       }
	    
	       c++;
	       chars[p++] = chars[chars.length -1];
	       if(c != 1){
	           if(c >= 10){
	               p = addMultipleDigitsToCharArray(chars,p,c);
	           }
	           else{
	               chars[p++] = (char) ('0' + c%10);
	           }
	       }
	       return p;
	    }
	    
	    private static int addMultipleDigitsToCharArray(char[] chars, int p, int N) {
	        if (N == 0) {
	            return p;
	        }

	        int r = N % 10;
	        p = addMultipleDigitsToCharArray(chars,p,N / 10);

	        chars[p] = (char) ('0' + r%10);
	        return p+1;
	    }
}
