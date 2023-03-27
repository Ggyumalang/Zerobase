package exercise_coding.backjun.backjun20230319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class exam01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] idx = new int[N];
        int[] LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = arr[0];
        idx[0] = 0;
        int len = 1;

        for (int i = 1; i < N; i++) {
            if(arr[i] > LIS[len-1]){
                idx[i] = len;
                LIS[len++] = arr[i];
            }else {
                int left = 0;
                int right = len;

                while (left < right) {
                    int mid = (left+right) / 2;
                    if(arr[i] > LIS[mid]){
                        left = mid+1;
                    }else {
                        right = mid;
                    }
                }

                LIS[left] = arr[i];
                idx[i] = left;
            }
        }

        int index = len-1;
        Stack<Integer> stack = new Stack<>();

        for (int i = N-1; i >= 0 ; i--) {
            if(idx[i] == index) {
                index--;
                stack.push(arr[i]);
            }
        }
        System.out.println(len);
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
            if(stack.size() == 1){
                System.out.println(stack.pop());
            }
        }
    }
}
