//프로그래머스 스타수열
//한번에 해결하기..
package exercise_coding.programmers.pro20230221;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class exam01_2 {
    public static void main(String[] args) {
        int[] a ={0, 3, 3, 0, 7, 2, 0, 2, 2, 0};
        System.out.println(solution(a));
    }

    public static int solution(int[] a) {
        if(a.length <= 1){
            return 0;
        }

        if(a.length == 2) {
            if(a[0] == a[1]) {
                return 0;
            }else {
                return 2;
            }
        }

        //a 배열의 원소들의 각 수를 구해서 map 에 담는다.
        //a[i] , a[i]가 나온 횟수
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : a) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        //원소들의 수로 내림차순해서 정답의 가능성이 가장 큰 값부터 구해본다.
        List<Map.Entry<Integer,Integer>> mapSort = new ArrayList<>(map.entrySet());
        mapSort.sort((x,y) -> y.getValue() - x.getValue());

        System.out.println(mapSort);

        //결과값을 담을 변수 result
        int result = Integer.MIN_VALUE;

        //mapSort만큼 돈다.
        for(Map.Entry<Integer,Integer> entry : mapSort){
            //result보다 작으면 어차피 답이 될 가능성이 없으므로 , 같으면 어차피 값이 같으므로 continue
            if(entry.getValue() <= result){
                continue;
            }
            int count = 0;

            //인덱스를 이동시키면서 두 개의 수를 체크한다.
            //둘 중에 한 값은 entry의 키값과 같아야 하고 다른 값은 키 값과 달라야한다.
            //이 조건을 만족할 때마다 count를 증가시키고(해당 유형이 있다는 의미이므로..)
            // i는 2씩 증가시킨다. ( i, i+1 을 포함한다는 의미 )
            // i를 1씩 증가시키면 중복된 값이 나올 수 있다. ex) 0 3 0 -> 0 3 도 담고 3 0 도 담아버린다.
            for (int i = 0; i < a.length-1; i++) {
                if(a[i] != entry.getKey() && a[i+1] != entry.getKey()) continue;
                if(a[i] == a[i+1]){
                    continue;
                }
                count++;
                i++; //2칸씩 넘어가므로..
            }
            //결과로 나온 count와 비교하며 result의 max값을 찾는다
            result = Math.max(result, count);
        }
        //최종 결과로 나온 result 는 가짓 수 이기 때문에 총 길이를 리턴하려면 result *2 를 해주어야한다.
        return result * 2;
    }
}
