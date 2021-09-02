package leetcode_algo_selfstudy;

public class ReverseString {

	public static void main(String[] args) {
		char[] s = {'t','e','s','t'};
		reverseString(s);
		System.out.println(s);

	}
	
	public static void reverseString(char[] s) {
        int n = s.length;
        for(int i = 0; i < n/2; i++){
            char ch = s[i];
            s[i] = s[n-i-1];
            s[n-i-1] = ch;
        }
    }

}
