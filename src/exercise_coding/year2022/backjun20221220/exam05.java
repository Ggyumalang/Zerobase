//Palindrome 문제였음.
package exercise_coding.year2022.backjun20221220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exam05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            System.out.println(checkPalindrome(0,arr[i].length()-1,arr[i].toCharArray(),0));
        }
    }

    public static int checkPalindrome(int left, int right, char[] arr, int delCnt){
        while (left < right){
            if(arr[left] == arr[right]){
                left++;
                right--;
            }else {
                //첫번째라면 한번 이동하고 기회를 주고
                if(delCnt == 0){
                    if(checkPalindrome(left+1,right,arr,1) == 0 ||
                    checkPalindrome(left,right-1,arr,1) == 0){
                       return 1;
                    }else {
                        return 2;
                    }
                }else {
                    //아니라면 유사회문도 아니므로 2를 return한다.
                    return 2;
                }
            }
        }
        return 0;
    }
}
