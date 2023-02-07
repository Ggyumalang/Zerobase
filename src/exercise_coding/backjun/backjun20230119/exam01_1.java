//t부터 시작해서 줄여나가면
//시간초과 발생 x
package exercise_coding.backjun.backjun20230119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam01_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();

        while (s.length() < t.length()){
            if(t.charAt(t.length()-1) == 'A'){
                t = t.substring(0,t.length()-1);
            }else {
                t = t.substring(0,t.length()-1);
                t = flip(t);
            }
        }

        System.out.println(t);
        System.out.println(s);

        if(s.equals(t)){
            System.out.println(1);
        }else {
            System.out.println(0);
        }
    }

    public static String flip(String s){
        String newStr = "";
        for (int i = s.length()-1; i >= 0; i--) {
            newStr += s.charAt(i);
        }
        return newStr;
    }
}
