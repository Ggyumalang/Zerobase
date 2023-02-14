//leetCode Path Sum II
package exercise_coding.leetcode.leet20230214;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

   static class BinaryTree{
        TreeNode root;

       BinaryTree(){}
       BinaryTree(Integer[] arr) {
           TreeNode[] nodes = new TreeNode[arr.length];
           for (int i = 0; i < arr.length; i++) {
               if(arr[i] == null){
                   continue;
               }
               nodes[i] = new TreeNode(arr[i],null,null);
           }

           for (int i = 0; i < arr.length; i++) {
               int left = 2*i+1;
               int right = 2*i+2;

               if(left < arr.length && nodes[left] != null){
                   nodes[i].left = nodes[left];
               }

               if(right < arr.length && nodes[right] != null) {
                   nodes[i].right = nodes[right];
               }
           }

           this.root = nodes[0];
       }

   }

    public static void main(String[] args) {
        Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        BinaryTree bt = new BinaryTree(arr);
        System.out.println(pathSum(bt.root, 22));
    }
    static List<List<Integer>> result;
    static int target;
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        result = new ArrayList<>();
        dfs(root.val, new ArrayList<>() , root);
        System.out.println(result);
        return result;
    }

    private static void dfs(int val , List<Integer> list , TreeNode node) {
        int n = list.size();
        list.add(val);
        if(node.left == null && node.right == null){
            int sum = list.stream().reduce(0, Integer::sum);
            if(sum == target){
                result.add(new ArrayList<>(list));
            }
            list.remove(n);
            return;
        }

        if(node.left != null){
            dfs(node.left.val , list , node.left);
        }
        if(node.right != null){
            dfs(node.right.val , list , node.right);
        }
        list.remove(n);
    }
}
