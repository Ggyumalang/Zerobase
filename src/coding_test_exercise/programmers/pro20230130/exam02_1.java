//프로그래머스 - 광고삽입문제
package coding_test_exercise.programmers.pro20230130;

public class exam02_1 {
    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        System.out.println(solution(play_time,adv_time,logs));
    }

    public static String solution(String play_time, String adv_time, String[] logs) {
        int answer = 0;
        int playTime = strToInt(play_time); //초로 단위를 변환
        int advTime = strToInt(adv_time);
        int[] sum = new int[playTime+1]; //누적되는 합을 구할 배열

        if(play_time.equals(adv_time)){
            return "00:00:00";
        }
        //끝나는 시간으로 오름차순해서..
        //가장 겹치는 시간이 많은 시간을 잡아서
        //return해야하는데 이게 되나..?
        for(String log : logs) {
            String[] arr = log.split("-");
            int start = strToInt(arr[0]);
            int end = strToInt(arr[1]);

            for (int i = start; i < end; i++) {
                sum[i]++;
            }
        }

        long max = 0;
        for (int i = 1; i < advTime; i++) {
            max += sum[i];
        }

        long now = max;

        for (int i = 0 , j = advTime; j < playTime; i++,j++) {
            now = now - sum[i] + sum[j];
            if(now > max){
                answer = i+1;
                max = now;
            }
        }

        return intToStr(answer);
    }

    //str to int
    public static int strToInt(String time_str){
        String[] arr = time_str.split(":");
        return Integer.parseInt(arr[0]) * 3600 + Integer.parseInt(arr[1]) *60
                + Integer.parseInt(arr[2]);
    }

    //int to str
    public static String intToStr(int time) {
        String hh = (time/3600) > 9? (time / 3600) + "" : "0" + (time/3600);
        time %= 3600;
        String mm = (time / 60) > 9?(time/60) + "" : "0" + (time/60);
        time%= 60;
        String ss = time > 9 ? time + "" : "0" + time;
        return hh + ":" + mm + ":" + ss;
    }
}
