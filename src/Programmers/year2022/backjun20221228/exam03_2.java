//백준 6549번 히스토그램에서 가장 큰 넓이 구하기
//스택을 이용한 풀이
//시간복잡도 : O(n)
package Programmers.year2022.backjun20221228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class exam03_2 {
    public static int[] histogram;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        StringBuilder sb = new StringBuilder();
        int N;
        while ((str = br.readLine()) != null) {
            if (str.equals("0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(str);
            N = Integer.parseInt(st.nextToken());
            histogram = new int[N];

            for (int i = 0; i < N; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(getArea(N)).append('\n');
            histogram = null;
        }
        System.out.println(sb);
    }

    public static long getArea(int len) {
        Stack<Integer> stack = new Stack<>();

        long maxArea = 0;

        for (int i = 0; i < len; i++) {
            /**
             * 이전 체인의 높이보다 현재 히스토그램 높이가 작거나 같을 경우
             * i번째 막대보다 작은 이전 체인들을 pop하면서 최대 넓이를 구해준다.
             *
             * */

            while (!stack.isEmpty() && histogram[stack.peek()] >= histogram[i]){
                int height = histogram[stack.pop()]; //이전 체인의 높이

                /**
                 * pop 한 뒤 그 다음의 이전 체인이 만약 없다면 0번째부터 i-1 번째 인덱스 까지가
                 * 유일한 폭이 된다. (즉 폭은 i가 된다.)
                 * 반면 스택이 비어있지 않다면 이는 pop한 높이보다 더 작은 높이를 갖는
                 * 체인이 들어있다는 것이므로 (i-1)번째 index에서 그 다음 이전 체인의 index를 빼준 것이
                 * 폭이 된다.
                 * */
                long width = stack.isEmpty() ? i : i - 1 - stack.peek();

                maxArea = Math.max(maxArea, height * width); //최대 넓이의 값을 갱신한다.
            }
            /**
             * 위 과정이 끝나면 스택에 저장되어있는 체인은 모두 i보다 작거나 같은 체인들 뿐이므로
             * i번째 index를 넣어준다.
             * */
            stack.push(i);
        }

        //위 과정이 끝나고도 stack에 남아있는 체인들이 존재할 수 있으므로 나머지도 위와 같은 과정을 거친다.
        while (!stack.isEmpty()){
            int height = histogram[stack.pop()];

            /**
             * 만약 pop하고 난 뒤 스택이 비어있다면 이는 남아있는 체인이 없다는 뜻이고
             * 고로 0 ~ (len - 1) 까지인 전체 폭이 width가 된다.
             * */

            long width = stack.isEmpty() ? len : len - 1 - stack.peek();
            maxArea = Math.max(maxArea,height * width);
        }
        return maxArea;
    }
}
