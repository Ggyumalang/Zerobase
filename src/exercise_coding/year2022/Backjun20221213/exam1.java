package exercise_coding.year2022.Backjun20221213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] conference = new int[Integer.parseInt(st.nextToken())][2];
        for (int i = 0; i < conference.length; i++) {
            st = new StringTokenizer(br.readLine());
            conference[i][0] = Integer.parseInt(st.nextToken());
            conference[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(conference,(x,y) -> {
            if(x[1] == y[1]){
                return x[0] - y[0];
            }
            return x[1]-y[1];
        });
        int cnt = 1;
        int finishTime = conference[0][1];
        for (int j = 1; j < conference.length; j++) {
            if(finishTime > conference[j][0]){
                continue;
            }
            cnt++;
            finishTime = conference[j][1];
        }
        System.out.println(cnt);


    }
}
