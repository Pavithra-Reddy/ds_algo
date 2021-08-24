package leetcode_aug;

public class ComplexNumberMultiplication {

	public static void main(String[] args) {
		System.out.println(complexNumberMultiply("3+2i","1+-1i"));

	}
	
	public static String complexNumberMultiply(String num1, String num2) {
        String[] num1RealImag = num1.split("\\+");
        int num1R = Integer.parseInt(num1RealImag[0]);
        String num1Imag = num1RealImag[1];
        int num1I = Integer.parseInt(num1Imag.substring(0, num1Imag.length()-1));
        
        String[] num2RealImag = num2.split("\\+");
        int num2R = Integer.parseInt(num2RealImag[0]);
        String num2Imag = num2RealImag[1];
        int num2I = Integer.parseInt(num2Imag.substring(0, num2Imag.length()-1));
        
        int resI = (num1R*num2I) + (num2R*num1I);
        int resR = (num1R*num2R) - (num1I*num2I);
        
        StringBuilder sb = new StringBuilder();
        sb.append(resR);
        sb.append("+");
        sb.append(resI);
        sb.append("i");
        return sb.toString();
        
    }

}
