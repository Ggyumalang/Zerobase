//백준 2263번 : 트리의 순회

package Programmers.backjun20221228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class exam06 {
    static int n;
    static int[] inOrder,postOrder,preOrder;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        inOrder = new int[n];
        postOrder = new int[n];
        preOrder = new int[n];
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }


        getPreOrder(0,n-1,0,n-1);

    }

    public static void getPreOrder(int is, int ie, int ps, int pe){
        //is 는 인오더 범위 시작 위치 , ie는 끝위치
        //ps 는 포스트오더 범위의 시작 , pe 는 끝위치

        if(is <= ie && ps <= pe){
            preOrder[idx++] = postOrder[pe];
            int pos = is;
            for (int i = is; i <= ie ; i++) {
                if(inOrder[i] == postOrder[pe]){
                    pos = i;
                    break;
                }
            }

            //왼쪽 자식 트리를 가지고 똑같은 과정을 반복한다.
            getPreOrder(is,pos - 1 , ps , ps + pos - is - 1);
            //오른쪽 자식 트리를 가지고 똑같은 과정을 반복한다.
            getPreOrder(pos+1 , ie, ps+pos-is,pe-1);
        }
    }
}
