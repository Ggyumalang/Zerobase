package exercise_coding.year2022.backjun20221214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class exam4_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] phoneBook = new String[Integer.parseInt(br.readLine())];
            for (int j = 0; j < phoneBook.length; j++) {
                phoneBook[j] = br.readLine();
            }
            Arrays.sort(phoneBook); //길이가 짧은 순으로 정렬한 후
            if(isPrefix(phoneBook)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }

    }

    private static boolean isPrefix(String[] phoneBook) {
        for (int i = 0; i < phoneBook.length-1; i++) {
            if(phoneBook[i+1].startsWith(phoneBook[i])){
                return false;
            }
        }
        return true;
    }
}
