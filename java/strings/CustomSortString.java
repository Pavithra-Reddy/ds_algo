package strings;
import java.util.Scanner;

/**
	order and str are strings composed of lowercase letters. In order, no letter occurs more than once.
	
	order was sorted in some custom order previously. We want to permute the characters of str so that they match the order that order was sorted. More specifically, if x occurs before y in order, then x should occur before y in the returned string.
	
	Return any permutation of str (as a string) that satisfies this property. 
	Input: 
	order = "cba"
	str = "abcd"
	Output: "cbad"

 *
 */
public class CustomSortString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String order = sc.nextLine();
		String str = sc.nextLine();
		System.out.println(customSortString(order,str));
		
		sc.close();

	}
	
	private static String customSortString(String order, String str) {
        int[] charCount = new int[26];
        
        for(int i = 0; i < str.length(); i++){
            charCount[str.charAt(i) - 'a']++;
        }
        
        StringBuilder sb =  new StringBuilder();
        
        for(int i = 0; i < order.length(); i++){
            while(charCount[order.charAt(i) - 'a'] > 0){
                charCount[order.charAt(i) - 'a']--;  
                sb.append(order.charAt(i));
            }
        }
        
        for(int i = 0; i < 26; i++){
            while(charCount[i] > 0){
                charCount[i]--;  
                sb.append((char)('a' + i));
            }
        }
        
        return sb.toString();
    }

}
