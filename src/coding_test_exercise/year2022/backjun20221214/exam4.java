package coding_test_exercise.year2022.backjun20221214;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class exam4 {

    static class Node {
        HashMap<Character, Node> child;
        boolean isTerminal;

        public Node() {
            this.child = new HashMap<>();
            this.isTerminal = false;
        }
    }

    static class Trie {
        Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String str) {
            Node cur = this.root;

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                cur.child.putIfAbsent(c, new Node());
                cur = cur.child.get(c);
                if (i == str.length() - 1) {
                    cur.isTerminal = true;
                    return;
                }
            }
        }

        public boolean isPrefix(Node node , String prefix) {
            Node cur = node;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.child.containsKey(c)) {
                    cur = cur.child.get(c);
                } else {
                    return false;
                }

                if (cur.isTerminal) {
                    //자기 자신이면 트루를 반환시킨다.
                    return true;
                }
            }
            return false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        indexLoop:
        for (int i = 0; i < N; i++) {
            String[] phoneBook = new String[Integer.parseInt(br.readLine())];
            Trie trie = new Trie();
            for (int j = 0; j < phoneBook.length; j++) {
                phoneBook[j] = br.readLine();
            }
            Arrays.sort(phoneBook,(x,y) -> x.length() - y.length()); //길이가 짧은 순으로 정렬한 후
            System.out.println(Arrays.toString(phoneBook));
            trie.insert(phoneBook[0]);
            for (int j = 1; j < phoneBook.length; j++) {
                if(trie.isPrefix(trie.root,phoneBook[j])){
                    System.out.println("No");
                    continue indexLoop;
                }else {
                    trie.insert(phoneBook[j]);
                }
            }
            System.out.println("YES");
        }

    }
}
