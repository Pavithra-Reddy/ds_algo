package leetcode_aug;

public class AddStrings {

	public static void main(String[] args) {
		System.out.println(addStrings("123","456"));

	}
	
	public static String addStrings(String num1, String num2) {
		if(num1 == null || num2 == null) {
			return null;
		}
		
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = a+b+carry;
            carry = sum/10;
            sum = sum%10;
            res.append(sum);
            i--;
            j--;
        }
        
        if(carry != 0){
            res.append(carry);
        }
        
        return res.reverse().toString();
    }

}
