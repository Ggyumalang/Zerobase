//프로그래머스 - 가장 많이 받은 선물 [삽질..]
package exercise_coding.programmers.pro20240612;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        System.out.println(solution(friends,gifts));
    }

    static class Node {
        Map<String, Integer> gifted; //누구에게 선물을 몇 번 줬는 지 기록

        int totalGifted; // 전체 내가 준 선물의 수

        int totalReceived; // 전체 내가 받은 선물의 수

        int presentIndex; //선물 지수

        public Node(Map<String, Integer> gifted, int totalGifted, int totalReceived) {
            this.gifted = gifted;
            this.totalGifted = totalGifted;
            this.totalReceived = totalReceived;
        }

        public void give(String receiver) {
            this.gifted.put(receiver, this.gifted.getOrDefault(receiver, 0) + 1);
            this.totalGifted++;
        }

        public void incReceived() {
            this.totalReceived++;
        }

        public void calIdx() {
            this.presentIndex = this.totalGifted - this.totalReceived;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "gifted=" + gifted +
                    ", totalGifted=" + totalGifted +
                    ", totalReceived=" + totalReceived +
                    ", presentIndex=" + presentIndex +
                    '}';
        }
    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Node> map = new HashMap<>(); //선물을 준 사람 + 갯수
        Map<String, Integer> score = new HashMap<>();
        for(String friend : friends) {
            map.put(friend, new Node(new HashMap<>(), 0, 0));
            score.put(friend, 0);
        }
        int[] gifted = new int[friends.length];

        for(String gift : gifts) {
            String[] split = gift.split(" ");
            String giver = split[0];
            String receiver = split[1];
            map.get(giver).give(receiver);
            map.get(receiver).incReceived();
        }

        for(Map.Entry<String,Node> entry : map.entrySet()) {
            map.get(entry.getKey()).calIdx();
        }

        System.out.println(map);


        for(Map.Entry<String,Node> entry : map.entrySet()) {
            for(Map.Entry<String,Integer> giveEntry : map.get(entry.getKey()).gifted.entrySet()) {

            }
            for(String friend : friends) {
                String key = entry.getKey();

                if(friend.equals(key)) {
                    continue;
                }

                Node node = map.get(key);

                System.out.println("node >>> " + node);

                if(node.gifted.containsKey(friend)) {
                    if(node.gifted.get(friend) > map.get(friend).gifted.getOrDefault(key, 0)) {
                        score.put(key, score.get(key) + 1);
                    } else if(node.gifted.get(friend) < map.get(friend).gifted.getOrDefault(key, 0)) {
                        score.put(friend, score.get(friend) + 1);
                    } else {
                        if(node.presentIndex > map.get(friend).presentIndex) {
                            score.put(key, score.get(key) + 1);
                        } else if(node.presentIndex < map.get(friend).presentIndex) {
                            score.put(friend, score.get(friend) + 1);
                        }
                    }
                } else {
                    if(node.presentIndex > map.get(friend).presentIndex) {
                        score.put(key, score.get(key) + 1);
                    } else if(node.presentIndex < map.get(friend).presentIndex) {
                        score.put(friend, score.get(friend) + 1);
                    }
                }
                System.out.println(score);
            }
        }


        return answer;
    }
}
