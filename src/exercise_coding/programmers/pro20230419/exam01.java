package exercise_coding.programmers.pro20230419;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 트라이 응용문제
 */

public class exam01 {

    static class Node {

        HashMap<Character, Node> child;
        boolean isTerminal;

        List<String> words = new ArrayList<>();

        public Node() {
            this.child = new HashMap<>();
            this.isTerminal = false;
        }
    }

    static class Trie {

        Node root;
        ArrayList<Character> capitals;

        public Trie() {
            this.root = new Node();
            capitals = new ArrayList<>();
        }


        public void insert(String str) {
            Node cur = this.root;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (c < 'a') {
                    capitals.add(c);
                }

                cur.child.putIfAbsent(c, new Node());
                cur = cur.child.get(c);
                cur.words.add(str);

                if (i == str.length() - 1) {
                    cur.isTerminal = true;
                    return;
                }
            }
        }

        public int search(String str) {
            Node cur = this.root;
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if(cur.words.size() == 1){
                    return count;
                }else {
                    cur = cur.child.get(c);
                    count++;
                }

                if (i == str.length() - 1) {
                    if (!cur.isTerminal) {
                        return count;
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        String[] words = {"go", "gone", "guild"};
        System.out.println(solution(words));

        words = new String[]{"abc", "def", "ghi", "jklm"};
        System.out.println(solution(words));

        words = new String[]{"word", "war", "warrior", "world"};
        System.out.println(solution(words));
    }

    public static int solution(String[] words) {
        int answer = 0;

        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

      for (String word : words) {
          answer += trie.search(word);
        }

        return answer;
    }
}
