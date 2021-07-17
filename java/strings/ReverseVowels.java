package strings;
import java.util.Scanner;

/*	
	Given an input string, reverse only the vowels of a string.
Input : "hello",
Output : "holle".
*/


class ReverseVowels {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(reverseVowels(s));
		
		sc.close();
	}
	
	public static String reverseVowels(String s) {
		int i = 0;
		int j = s.length() - 1;
		String vowels = "AEIOUaeiou";
		char[] charseq = s.toCharArray();
		while(i<j) {
			if(vowels.contains(charseq[i] + "") && vowels.contains(charseq[j] + "")) {
				char temp = charseq[i];
				charseq[i] = charseq[j];
				charseq[j] = temp;
				i++;
				j--;
			}
			else if(vowels.contains(charseq[i] + "")) {
				j--;
			}
			else if(vowels.contains(charseq[j] + "")) {
				i++;
			}
			else {
				i++;
				j--;
			}
		}
		return new String(charseq);
    }
}
