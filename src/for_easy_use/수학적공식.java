package for_easy_use;

public class 수학적공식 {
    public static void main(String[] args) {
        //10이 나누고자 한 수 7이 나누는 수라고 생각하면 된다.
        int timeA = (10 +7 -1) / 7; //그냥 나누어주면 내림이 되지만 올림을 해주는 것.
        int timeB = 10/7; //그냥 나누어주면 내림이 되지만 올림을 해주는 것.

        System.out.println(timeA);
        System.out.println(timeB);


        //이렇게 해주면 right가 너무 커도 나누기가 된다. 이분탐색 시 사용가능.
        int left = 0;
        int right = Integer.MAX_VALUE;
        int mid = left + (right - left) / 2;
        System.out.println(mid);

        //튀김기 문제였는데..
        int mid2 = 3;
        int fry = 3;
        int clean = 2;
        int cnt = 0;
        cnt = (mid2+clean) / (fry+clean); //이런 식으로 하면.. fry 만 해야하는 경우도 계산이 된다..?
        System.out.println(cnt);

    }
}
