package strings;
import java.util.Scanner;

/*	
 	Given an input string, reverse the string word by word.
	Input : "the sky is blue",
	Output : "blue is sky the".
 */


class ReverseWordsOfSentence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(reverseWords(s));
		
		sc.close();
	}
	
	public static String reverseWords(String s) {
		String words[] = s.split("\\s+");
		String res = "";
		for(int i = words.length - 1; i > 0 ; i--) {
			res += words[i] + " ";
		}
		res += words[0];
		return res;
    }	
}
