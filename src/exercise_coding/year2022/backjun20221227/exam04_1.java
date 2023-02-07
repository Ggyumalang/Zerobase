package exercise_coding.year2022.backjun20221227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam04_1 {
    final static int OPERATOR = 4;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] operators = new int[OPERATOR];
        for (int i = 0; i < OPERATOR; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(numbers,operators,numbers[0],1);

        System.out.println(max);
        System.out.println(min);

    }

    public static void backTracking(int[] numbers, int[] operators, int num , int idx){
        if(idx == numbers.length){
            max = Math.max(max,num);
            min = Math.min(min,num);
            return;
        }

        for (int i = 0; i < OPERATOR; i++) {
            if(operators[i] > 0){
                operators[i]--;
                switch (i){
                    case 0:
                        backTracking(numbers,operators,num + numbers[idx],idx+1);
                        break;
                    case 1:
                        backTracking(numbers,operators,num - numbers[idx],idx+1);
                        break;
                    case 2:
                        backTracking(numbers,operators,num * numbers[idx],idx+1);
                        break;
                    case 3:
                        backTracking(numbers,operators,num / numbers[idx],idx+1);
                        break;
                }
                operators[i]++;
            }
        }

    }
}
