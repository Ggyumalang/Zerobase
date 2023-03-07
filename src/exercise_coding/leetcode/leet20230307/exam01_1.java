package exercise_coding.leetcode.leet20230307;

public class exam01_1 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));

        System.out.println("========================");

        nums = new int[]{1,2,-1,-2,2,1,-2,1,4,-5,4};
        System.out.println(maxSubArray(nums));
    }
    static int[] numsCopy;
    static int[] curSum;
    public static int maxSubArray(int[] nums) {
        numsCopy = nums.clone();
        curSum = new int[nums.length];
        curSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum[i] = nums[i] + curSum[i-1];
        }

        return divideAndConquer(0,nums.length-1);
    }

    private static int divideAndConquer(int lo, int hi) {
        if(lo == hi){
            return numsCopy[lo];
        }

        int mid = lo + (hi-lo)/2;
        int left = divideAndConquer(lo, mid);
        int right = divideAndConquer(mid+1, hi);

        int maxVal = Math.max(left, right);
        System.out.println(maxVal);
        return Math.max(maxVal, getMidArea(lo,hi,mid));

    }

    private static int getMidArea(int lo, int hi, int mid) {
        System.out.println("lo = " + lo);
        System.out.println("hi = " + hi);
        System.out.println("mid = " + mid);
        int toLeft = mid;
        int toRight = mid+1;
        int maxVal = numsCopy[toLeft] + numsCopy[toRight];
        while (lo < toLeft && toRight < hi){
            if(numsCopy[toLeft-1] > numsCopy[toRight+1]){
                toLeft--;
                maxVal = Math.max(maxVal, maxVal+numsCopy[toLeft]);
            }else {
                toRight++;
                maxVal = Math.max(maxVal, maxVal+numsCopy[toRight]);
            }
        }

        while (lo < toLeft){
            toLeft--;
            maxVal = Math.max(maxVal, maxVal+numsCopy[toLeft]);
        }

        while (toRight < hi){
            toRight++;
            maxVal = Math.max(maxVal, maxVal+numsCopy[toRight]);
        }
        return maxVal;
    }

    private static int getCurSum(int lo, int hi){
        if(lo == 0){
            return hi;
        }else {
            return curSum[hi] - curSum[lo];
        }
    }
}
