//백준 1092번 배
package exercise_coding.backjun.backjun20230123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class exam01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cranes = new int[N];
        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cranes);

        int box = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        ArrayList<Integer> boxes = new ArrayList<>();

        for (int i = 0; i < box; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(boxes, Comparator.reverseOrder());
        
        //박스의 무게보다 크레인 무게가 크면 뽑아올릴 수 없기 때문에
        if(boxes.get(0) >
                Arrays.stream(cranes).max().getAsInt()){
            System.out.println(-1);
            return;
        }

        int cnt = 0;
        while (!boxes.isEmpty()) {
            int idx = 0;
            for (int i = N-1; i >= 0;) {
                if(idx >= boxes.size()){
                    break;
                }
                int crane = cranes[i];
                if(boxes.get(idx) <= crane){
                    boxes.remove(idx);
                    i--;
                }else {
                    idx++;
                }
            }
            cnt++;
        }
        System.out.println(cnt);

    }
}
