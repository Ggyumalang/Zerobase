package coding_test_exercise.year2022.backjun20221228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam04_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int left = 0;
        int right = N-1;
        int sum = numbers[left] + numbers[right];
        while (left < right) {
            if(sum < S){
                left++;
                sum += numbers[left];
            }else if(sum > S){
                right--;
                sum += numbers[right];
            }else {
                cnt++;
                left++;
                sum += numbers[left];
            }
            System.out.println(sum);
        }

        System.out.println(cnt);

    }
}
