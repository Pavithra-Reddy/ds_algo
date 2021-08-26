package leetcode_aug;

import java.util.Stack;

public class VerifyPreorderSerialization {

	public static void main(String[] args) {
		System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));

	}

	public static boolean isValidSerialization(String preorder) {
        String[] arr = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for(String s: arr){
            if(stack.isEmpty() || !s.equals("#")){
                stack.push(s);
            }else{
                while(!stack.isEmpty() && stack.peek().equals("#")){
                    stack.pop();
                    if(stack.isEmpty()){
                        return false;
                    }else{
                        stack.pop();
                    }
                }
                stack.push("#");
            }            
        }

        return stack.size()==1 && stack.peek().equals("#");
    }
}
