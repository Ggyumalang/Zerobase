//백준 6549번 히스토그램에서 가장 큰 넓이 구하기
//분할 정복을 이용한 풀이
//시간 복잡도 : O(nlogn)
package coding_test_exercise.year2022.backjun20221228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam03_1 {
    public static int[] histogram;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        StringBuilder sb = new StringBuilder();
        int N;
        while ((str = br.readLine()) != null){
            if(str.equals("0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(str);
            N = Integer.parseInt(st.nextToken());
            histogram = new int[N];

            for (int i = 0; i < N; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }
            sb.append(getArea(0,N-1)).append('\n');
            histogram = null;
        }
        System.out.println(sb);
    }

    public static long getArea(int lo , int hi){
        //막대 폭이 1일 경우
        if(lo == hi) {
            return histogram[lo];
        }
        //1번 과정
        int mid = (lo+hi)/ 2; //중간지점

        System.out.println(lo);
        System.out.println(mid);

        /**
         * 2번 과정
         * mid 를 기점으로 양쪽으로 나누어 양쪽 구간 중 큰 넓이를 저장한다.
         * 왼쪽 부분 : lo ~ mid
         * 오른쪽 부분 : mid+1 ~ hi
         * */
        long leftArea = getArea(lo,mid);
        long rightArea = getArea(mid+1,hi);
        //3번 과정
        long max = Math.max(leftArea, rightArea);

        //4번 과정 양쪽 구간 중 큰 값과 중간 구간을 비교하여 더 큰 넓이로 갱신한다.
        max = Math.max(max,getMidArea(lo,hi,mid));

        return max;
    }

    public static long getMidArea(int lo, int hi , int mid){
        int toLeft = mid; //중간 지점으로부터 왼쪽으로 갈 변수
        int toRight = mid; //중간 지점으로부터 오른쪽으로 갈 변수

        long height = histogram[mid]; //높이

        //초기 넓이는 구간폭이 1이므로 넓이는 곧 높이가 됨
        long maxArea = height;

        //양 끝 범위를 벗어나기 전까지 반복한다.
        while (lo < toLeft && toRight < hi){
            /**
             * 양쪽 다음 칸의 높이 중 높은 칸을 선태갛되,
             * 갱신되는 Height 는 기존 Height 보다 작거나 같아야 한다.
             * */

            if(histogram[toLeft - 1] < histogram[toRight + 1]){
                toRight++;
                height = Math.min(height, histogram[toRight]);
            }else {
                toLeft--;
                height = Math.min(height,histogram[toLeft]);
            }

            //최대 넓이 갱신
            maxArea = Math.max(maxArea,height * (toRight - toLeft + 1));
        }

        // 오른쪽 구간을 끝까지 탐색하지 못했다면 마저 탐색
        while (toRight < hi) {
            toRight++;
            height = Math.min(height, histogram[toRight]);
            maxArea = Math.max(maxArea , height * (toRight - toLeft + 1));
        }
        // 왼쪽 구간을 끝까지 탐색하지 못했다면 마저 탐색
        while (toLeft > lo){
            toLeft--;
            height = Math.min(height , histogram[toLeft]);
            maxArea = Math.max(maxArea , height * (toRight - toLeft + 1));
        }
        return maxArea;
    }
}
