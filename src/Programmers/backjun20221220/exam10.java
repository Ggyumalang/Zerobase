//백준 2812번

package Programmers.backjun20221220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class exam10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String number = br.readLine();
        Stack<Character> stack = new Stack<>();
        char[] result = new char[number.length()-K];

        for (int i = 0; i < N; i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && K-- > 0){
                stack.pop();
            }
            stack.push(c);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }

        System.out.println(new String(result));
    }
}
