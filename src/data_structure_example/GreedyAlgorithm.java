package data_structure_example;
import java.util.Arrays;
import java.util.Comparator;
public class GreedyAlgorithm {

    static class Activity {
        int start, finish;

        public Activity(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }

        @Override
        public String toString() {
            return "Activity{" +
                    "start=" + start +
                    ", finish=" + finish +
                    '}';
        }
    }

    public static void selectActivities(Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));
        int n = activities.length;

        System.out.println(Arrays.toString(activities));

        System.out.println("Selected activities:");

        int i = 0;
        int count = 1;
        System.out.println("(" + activities[i].start + ", " + activities[i].finish + ")");

        for (int j = 1; j < n; j++) {
            if (activities[j].start >= activities[i].finish) {
                System.out.println("(" + activities[j].start + ", " + activities[j].finish + ")");
                i = j;
                count++;
            }
        }

        //이용할 수 있는 총 회의 갯수
        System.out.println(count);
    }

    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(1, 3),
                new Activity(2, 5),
                new Activity(3, 9),
                new Activity(6, 8),
                new Activity(5, 7),
                new Activity(5, 6),
                new Activity(7, 9),
        };

        selectActivities(activities);
    }
}
