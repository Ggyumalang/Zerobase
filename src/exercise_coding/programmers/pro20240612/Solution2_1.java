// //프로그래머스 - 가장 많이 받은 선물 [정답] - 다시 풀어보기
package exercise_coding.programmers.pro20240612;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2_1 {
    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(solution(friends,gifts));
    }

    public static int solution(String[] friends, String[] gifts) {
        Map<String, Integer> idxMap = new HashMap<>();
        int idx = 0;

        // 인덱스 저장
        for(String friend : friends) {
            idxMap.put(friend, idx++);
        }

        int length = friends.length;
        int[][] history = new int[length][length]; // 주고받은 선물 내역을 계산
        int[] giftScore = new int[length];  // 선물 지수 계산
        int[] answer = new int[length]; // 정답

        for(String gift : gifts) {
            String[] split = gift.split(" ");
            int giverIdx = idxMap.get(split[0]);
            int receiverIdx = idxMap.get(split[1]);

            //선물을 주었기 때문에 증가
            history[giverIdx][receiverIdx]++;

            //선물 지수 + 1
            giftScore[giverIdx]++;
            //받는 쪽은 선물 지수 - 1
            giftScore[receiverIdx]--;
        }

        System.out.println(Arrays.deepToString(history));

        for(int giver = 0; giver < length; giver++) {
            for(int receiver = giver + 1 ; receiver < length ; receiver ++) {
                //giver 가 receiver 에게 give 한 횟수
                int giveCnt = history[giver][receiver];

                //receiver 가 giver 에게 give 한 횟수
                int receiveCnt = history[receiver][giver];

                //giver 가 선물을 더 많이 줬다면 선물을 받는다
                if(giveCnt > receiveCnt) {
                    answer[giver]++;
                } else if(giveCnt < receiveCnt) {
                    //receiver 가 선물을 더 많이 줬다면 선물을 받는다
                    answer[receiver]++;
                } else {
                    //둘이 선물을 주고 받은 적이 없으며 giver 가 선물지수가 더 높다면 선물을 받는다
                    if(giftScore[giver] > giftScore[receiver]) {
                        answer[giver] ++;
                    } else if (giftScore[giver] < giftScore[receiver]) {
                        //둘이 선물을 주고 받은 적이 없으며 receiver 가 선물지수가 더 높다면 선물을 받는다
                        answer[receiver] ++;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(answer));

        return 0;
    }
}
