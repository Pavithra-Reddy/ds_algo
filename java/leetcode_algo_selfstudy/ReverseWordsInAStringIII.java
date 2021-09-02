package leetcode_algo_selfstudy;

public class ReverseWordsInAStringIII {

	public static void main(String[] args) {
		System.out.println(reverseWords("reverse words in a string"));

	}
	
	public static String reverseWords(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                int j = i;
                while (j+1 < arr.length && arr[j+1] != ' ') {
                    j++; 
                }
                reverseString(arr, i, j);
                i = j;
            }
        }
        return String.valueOf(arr);
    }

    public static void reverseString(char[] word, int i, int j) {
        while(i<j){
            char ch = word[i];
            word[i++] = word[j];
            word[j--] = ch;
        }
    }

}
