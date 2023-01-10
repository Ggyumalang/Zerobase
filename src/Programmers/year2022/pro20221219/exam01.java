//
package Programmers.year2022.pro20221219;

public class exam01 {
    public static void main(String[] args) {
        String number = "1924";
        int k = 2;
        System.out.println(solution(number,k));

        number = "1231234";
        k = 3;
        System.out.println(solution(number,k));

        number = "4177252841";
        k = 4;
        System.out.println(solution(number,k));
    }
    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < number.length()-k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = idx; j <= k+i;j++) {
                if(max < number.charAt(j)-'0'){
                    max = number.charAt(j)-'0';
                    idx = j+1;
                }
            }
            System.out.println(max);
            sb.append(max);
        }
        return sb.toString();
    }
}
