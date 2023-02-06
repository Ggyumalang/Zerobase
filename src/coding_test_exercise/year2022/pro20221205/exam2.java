package coding_test_exercise.year2022.pro20221205;

import java.util.HashMap;
import java.util.Map;

public class exam2 {
    public static void main(String[] args) {
//        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        String[] want = {"apple"};
//        int[] number = {3,2,2,2,1};
        int[] number = {10};
//        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        String[] discount = {"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"};
        System.out.println(solution(want,number,discount));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String,Integer> wantMap = new HashMap<>();
        HashMap<String,Integer> discountMap = new HashMap<>();

        if(want.length == 0 || number.length == 0 || discount.length == 0) {
            return 0;
        }

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i],number[i]);
        }

        System.out.println("wantMap >>> " + wantMap);
        for (int i = 0; i < discount.length; i++) {
            discountMap.put(discount[i],discountMap.getOrDefault(discount[i],0)+1);
            if(i < 9) {
                continue;
            }
            boolean isOk = true;
            for (Map.Entry<String,Integer> entry : wantMap.entrySet()) {
                if(discountMap.get(entry.getKey()) != null){
                    if(discountMap.get(entry.getKey()) < entry.getValue()) {
                        isOk = false;
                    }
                }else {
                    isOk = false;
                }

            }
            if(isOk){
                answer++;
            }

            discountMap.put(discount[i-9],discountMap.get(discount[i-9])-1);
        }

        return answer;
    }

}
