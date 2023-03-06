//프로그래머스 고고학자 튜브 자물쇠와 열쇠문제..
package exercise_coding.programmers.pro20230306;

public class exam01 {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(solution(key, lock));
    }

    static boolean isOk = false;
    public static boolean solution(int[][] key, int[][] lock) {
        int len = lock.length;
        //3배 확장 후 중앙으로 옮긴다.
        int[][] copyLock = new int[len*3][len*3];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                copyLock[i+len][j+len] = lock[i][j];
            }
        }

        dfs(key, copyLock,0);
        return isOk;
    }

    private static void dfs(int[][] key, int[][] copyLock, int cnt) {
        check(key, copyLock, 0, 0);
        if(isOk) return;
        if(cnt >= 4) return;
        int[][] temp = rotate(key);
        dfs(temp,copyLock, cnt+1);
    }
    //이것을 모든 부분을 돌면서 확인..
    private static void check(int[][] key, int[][] lock, int x, int y) {
        if(isOk) return;
        //열로 이동
        if(y + key.length > lock.length){
            y = 0;
            x++;
        }
        //모두 돌았음.
        if(x + key.length > lock.length) return;

        int[][] copyLock = new int[lock.length][lock.length];

        for (int i = 0; i < lock.length; i++) {
            copyLock[i] = lock[i].clone();
        }

        boolean isFail = false;
        //자물쇠 영역 내에 열쇠의 돌기와 자물쇠의 돌기가 만나기 때문에 isFail = true임
        loop:
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key.length; j++) {
                if(key[i][j] == 1){
                    if(copyLock[i+x][j+y] == 1){
                        isFail = true;
                        break loop;
                    }
                    copyLock[i+x][j+y] = key[i][j];
                }
            }
        }
        //중앙에 있는 자물쇠 상태를 확인해 모든 홈이 채워져 있지않으면 false
        if(!isFail){
            loop:
            for (int i = 0; i < lock.length/3; i++) {
                for (int j = 0; j < lock.length/3; j++) {
                    if(copyLock[i+lock.length/3][j+lock.length/3] != 1) {
                        isFail = true;
                        break loop;
                    }
                }
            }
        }
        if(!isFail){
            isOk = true;
        }
        check(key,lock,x,y+1);
    }
    
    public static int[][] rotate(int[][] key) { //90도씩 회전해보는 것
        int len = key.length;
        int[][] temp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                temp[i][j] = key[len-j-1][i];
            }
        }
        return temp;
    }
}
