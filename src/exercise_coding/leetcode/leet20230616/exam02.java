// Best Time to Buy and Sell Stock II
package exercise_coding.leetcode.leet20230616;

public class exam02 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

        prices = new int[]{1,2,3,4,5};
        System.out.println(maxProfit(prices));

        prices = new int[] {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int answer = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i] < prices[i+1]) {
                answer += prices[i+1] - prices[i];
            }
        }
        return answer;
    }
}
