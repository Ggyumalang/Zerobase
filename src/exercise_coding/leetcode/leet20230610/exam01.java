package exercise_coding.leetcode.leet20230610;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class exam01 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answers = new ArrayList<>();
        answers.add(new ArrayList<>(List.of(root.val)));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levels = queue.size();
            List<Integer> subLevels = new ArrayList<>();

            for (int i = 0; i < levels; i++) {
                if(queue.peek().left != null) {
                    queue.add(queue.peek().left);
                }

                if(queue.peek().right != null) {
                    queue.add(queue.peek().right);
                }
                subLevels.add(queue.poll().val);
            }
            answers.add(subLevels);
        }


        return answers;


    }
}
