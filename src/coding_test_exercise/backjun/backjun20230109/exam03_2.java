//bfs로 해결..
package coding_test_exercise.backjun.backjun20230109;

import java.util.*;

public class exam03_2 {
    static class Loc{
        int idx;
        int time;

        public Loc(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
    final static int INF = 100000000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //수빈의 위치
        int K = sc.nextInt(); //동생의 위치
        int[] visited = new int[1000001];

        Queue<Loc> q = new LinkedList<>(); //location 저장
        q.add(new Loc(N,1)); //시작 time을 1로 해놓고 결과 출력시 1 빼기 visited 값이 0인 곳과 구분하기 위해.
        visited[N] = 1;

        while (!q.isEmpty()){
            Loc cur = q.poll();
            
            //앞으로 한칸
            if(cur.idx + 1 >= 0 && cur.idx+1 <= 100000){
                if(visited[cur.idx + 1] == 0 || visited[cur.idx + 1] > cur.time+1){
                    visited[cur.idx+1] = cur.time+1;
                    q.add(new Loc(cur.idx+1 , cur.time+1));
                }
            }
            
            // 뒤로 한칸
            if(cur.idx - 1 >= 0 && cur.idx-1 <= 100000){
                if(visited[cur.idx - 1] == 0 || visited[cur.idx - 1] > cur.time+1){
                    visited[cur.idx-1] = cur.time+1;
                    q.add(new Loc(cur.idx-1 , cur.time+1));
                }
            }
            
            //순간이동
            if(cur.idx * 2 >= 0 && cur.idx * 2 <= 100000){
                if(visited[cur.idx * 2] == 0 || visited[cur.idx * 2] > cur.time){
                    visited[cur.idx * 2] = cur.time;
                    q.add(new Loc(cur.idx*2 , cur.time));
                }
            }
        }

        System.out.println(visited[K]-1);
    }
}
