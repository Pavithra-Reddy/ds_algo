package strings;
import java.util.Scanner;

/*
 * Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
 * Input: s = "aaaaaaabc", goal = "aaaaaaacb"  Output: true
 * Input: s = "aa", goal = "aa"  Output: true
 * Input: s = "ab", goal = "ab"  Output: false
 */

class BuddyStrings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		System.out.println(buddyStrings(a,b));
		
		sc.close();
	}
	
	private static boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        
        //if same check if atleast 2 characters are same in string
        if(s.equals(goal)){
            int[] arr = new int[26];
            for(int i = 0; i < s.length(); i++){
                if(arr[s.charAt(i) - 'a'] == 1){
                    return true;
                }
                arr[s.charAt(i) - 'a']++;
            }
            return false;
        }
        
        int c = 0;
        int swapIndex = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != goal.charAt(i)){
                if(c == 0){
                    swapIndex = i;//index of character which has to be swapped
                }
                else if(c == 2 || s.charAt(swapIndex) != goal.charAt(i) || s.charAt(i) != goal.charAt(swapIndex)){
                    //if more than 2 differences or characters in current index and swapped index are different from goal string
                    return false;
                }
                c++;
            }
        }
        
        if(c == 2){
            return true;
        }
        
        return false;
    }
}
