package Programmers.backjun20221228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam03_3 {
    public static int[] histogram;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null){
            if(str.equals("0")){
                break;
            }
            StringTokenizer st = new StringTokenizer(str);

            int N = Integer.parseInt(st.nextToken());

            histogram = new int[N];

            for (int i = 0; i < N; i++) {
                histogram[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(getArea(0,N-1));
            str = null;
        }
    }

    private static long getArea(int lo, int hi) {

        if(lo == hi){
            return histogram[lo];
        }
        
        int mid = (lo+hi) / 2;
        
        //왼쪽에서 가장 큰 넓이
        long leftArea = getArea(lo,mid);
        //오른쪽에서 가장 큰 넓이
        long rightArea = getArea(mid+1,hi);
        
        //중간 넓이와 비교해서 누가 더 큰지 확인하기
        long maxArea = Math.max(leftArea, rightArea);
        
        maxArea = Math.max(maxArea, getMidArea(lo,hi,mid));
        
        return maxArea;
    }

    private static long getMidArea(int lo, int hi, int mid) {
        int toLeft = mid;
        int toRight = mid;
        
        long height = histogram[mid];
        long maxArea = height;

        while (toLeft > lo && toRight < hi){
            if(histogram[toLeft - 1] < histogram[toRight + 1]){
                //오른쪽의 높이가 더 크면 더 큰쪽으로 가야한다.
                toRight++;
                height = Math.min(height, histogram[toRight]);
            }else {
                toLeft--;
                height = Math.min(height, histogram[toLeft]);
            }
            maxArea = Math.max(maxArea,height * (toRight - toLeft + 1));
        }

        while (toRight < hi){
            toRight++;
            height = Math.min(height, histogram[toRight]);
            maxArea = Math.max(maxArea,height * (toRight - toLeft + 1));
        }

        while (toLeft > lo) {
            toLeft--;
            height = Math.min(height, histogram[toLeft]);
            maxArea = Math.max(maxArea,height * (toRight - toLeft + 1));
        }

        return maxArea;
    }
}
