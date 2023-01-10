//백준 1759번 암호 만들기
package Programmers.year2022.backjun20221228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam05 {
    public static char[] pwd;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        pwd = new char[C];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < C; i++) {
            pwd[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(pwd);
        dfs(L,"",0);
    }

    public static void dfs(int L, String password ,int depth) {
        if (password.length() == L) {
            if(check(password)){
                System.out.println(password);
            }
            return;
        }

        if(depth >= pwd.length){
            return;
        }

       dfs(L,password+pwd[depth],depth+1);
       dfs(L,password,depth+1);
    }

    public static boolean check(String password) {
        int vowel = 0; //모음
        int consonant = 0; //자음
        for(char arr : password.toCharArray()){
            if(arr == 'a' || arr == 'e' || arr == 'i' || arr == 'o' || arr == 'u'){
                vowel++;
            }else {
                consonant++;
            }
        }

        return vowel >= 1 && consonant >= 2;
    }
}
