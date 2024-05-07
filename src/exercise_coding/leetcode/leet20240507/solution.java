//leetcode - 134.Gas Station
package exercise_coding.leetcode.leet20240507;

public class solution {
    public static void main(String[] args) {
       int[] gas = {1,2,3,4,5};
       int[] cost = {3,4,5,1,2};

        System.out.println(canCompleteCircuit(gas,cost));

        gas = new int[]{2,3,4};
        cost = new int[]{3,4,3};

        System.out.println(canCompleteCircuit(gas,cost));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        if(gas.length == 1 && gas[0] == cost[0]) {
            return 0;
        }

        for (int i = 0; i < gas.length; i++) {
            if(gas[i] >= cost[i]){
                if(check(i, gas, cost, gas[i])) return i;
            }
        }

        return -1;
    }

    private static boolean check(int start, int[] gas, int[] cost, int gasTank) {

        int prev = start;
        int c = 0;
        int g = 0;
        for (int i = 1; i <= gas.length; i++) {
            int idx = (start + i) % gas.length;
            g = idx == start ? 0 : gas[idx];
//            c = idx == start ? cost[idx] : cost[prev];
            c = cost[prev];
            if(gasTank < c) {
                return false;
            }
            gasTank = gasTank + g - c;
            if(gasTank < 0) {
                return false;
            } else if (gasTank == 0) {
                if(idx != start) {
                    return false;
                }
            }
            prev = idx;
        }

        return true;
    }

}
