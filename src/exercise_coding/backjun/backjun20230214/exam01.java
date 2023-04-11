package exercise_coding.backjun.backjun20230214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam01 {
    static int n;
    static int c;
    static int[] item;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] item = new int[N];
        for (int i = 0; i < N; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

    }
}
