//queue를 이용해 풀어봣는데 시간초과..
//당연한 결과
package coding_test_exercise.backjun.backjun20230119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class exam01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String t = br.readLine();
        int n = s.length();
        int m = t.length();
        Queue<String> answer = new LinkedList<>();
        if(s.equals(t)){
            System.out.println(1);
            return;
        }
        answer.add(s+"A");
        answer.add(flip(s)+"B");

        for (int i = n; i < m; i++) {
            while (!answer.isEmpty() && answer.peek().length() <= i){
                String str = answer.poll();
                answer.add(str + "A");
                answer.add(flip(str) + "B");
            }
            if(answer.contains(t)){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    public static String flip(String s){
        String newStr = "";
        for (int i = s.length()-1; i >= 0; i--) {
            newStr += s.charAt(i);
        }
        return newStr;
    }
}
