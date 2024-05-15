package exercise_coding.leetcode.leet20240511;

public class solution1_other2 {
    public static void main(String[] args) {
        int num = 3749;
        System.out.println(intToRoman(num));

        num = 58;
        System.out.println(intToRoman(num));

        num = 1994;
        System.out.println(intToRoman(num));

        num = 10;
        System.out.println(intToRoman(num));

        num = 100;
        System.out.println(intToRoman(num));
    }

    public static String intToRoman(int num) {
        int[] intValue = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] code = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<intValue.length;i++) {
            while(num>=intValue[i]) {
                sb.append(code[i]);
                num=num-intValue[i];
                if(num <= 0) {
                    break;
                }
            }
        }
        return sb.toString();
    }
}
