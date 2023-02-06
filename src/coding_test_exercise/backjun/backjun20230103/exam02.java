package coding_test_exercise.backjun.backjun20230103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class exam02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            triangle.add(new ArrayList<>());
            while (st.hasMoreTokens()){
                triangle.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        int[][] tri = triangle.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        for (int i = 1; i < triangle.size(); i++) {
            //맨앞
            tri[i][0] = tri[i-1][0] + tri[i][0];
            //중간
            for (int j = 1; j < i; j++) {
                tri[i][j] = Math.max(tri[i-1][j-1] + tri[i][j] , tri[i-1][j] + tri[i][j]);
            }
            //맨뒤
            tri[i][i] = tri[i-1][i-1] + tri[i][i];
        }
        System.out.println(Arrays.stream(tri[tri.length-1]).max().getAsInt());

    }
}
