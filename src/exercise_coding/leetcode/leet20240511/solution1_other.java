package exercise_coding.leetcode.leet20240511;

public class solution1_other {
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
        String []ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String []tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String []hrns = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String []ths ={"","M","MM","MMM"};

        return ths[num/1000] + hrns[(num%1000)/100] + tens[(num%100)/10] + ones[num%10];
    }
}
