/**
 * Add Two Numbers
 */
package exercise_coding.leetcode.leet20250529;

import java.util.*;

public class Solution {

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }

         @Override
         public String toString() {
             StringBuilder sb = new StringBuilder();
             sb.append(val).append(" ");
             while (next != null) {
                 ListNode newLn = next;
                 sb.append(newLn.val).append(" ");
                 next = newLn.next;
             }
             return sb.toString();
         }
     }

    public static void main(String[] args) {
         ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
         ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
         System.out.println(addTwoNumbers(l1,l2));
         System.out.println(addTwoNumbers2(l1,l2));

        l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        System.out.println(addTwoNumbers(l1,l2));
        System.out.println(addTwoNumbers2(l1,l2));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<Integer> queueA = new LinkedList<>();
        Queue<Integer> queueB = new LinkedList<>();
        queueA.add(l1.val);
        queueB.add(l2.val);

         int idxA = 1;

         while (l1.next != null) {
             ListNode next = l1.next;
             queueA.add((next.val));
             l1 = next;
             idxA++;
         }

        int idxB = 1;
        while (l2.next != null) {
            ListNode next = l2.next;
            queueB.add(next.val);
            l2 = next;
            idxB++;
        }

        int maxLen = Math.max(queueA.size(), queueB.size());
        Queue<Integer> resultQueue = new LinkedList<>();
        int carry = 0;
        while (maxLen > 0) {
            int a = 0;
            int b = 0;
            if(queueA.size() > 0) {
                a = queueA.remove();
            }

            if(queueB.size() > 0) {
                b = queueB.remove();
            }

            int sum = a+b+carry;

            if(sum >= 10) {
                resultQueue.offer(sum % 10);
                carry = 1;
            } else {
                resultQueue.offer(sum);
                carry = 0;
            }
            maxLen--;
        }

        if(carry != 0) {
            resultQueue.add(carry);
        }
        System.out.println(resultQueue);

        if(resultQueue.size() == 1) {
            return new ListNode(resultQueue.remove());
        }

        ListNode result = new ListNode(resultQueue.remove(), new ListNode());
        ListNode tail = result;
        while (resultQueue.size() > 0) {
            tail.next = new ListNode(resultQueue.remove());
            tail = tail.next;
        }
        return result;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(digit);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        System.out.println("dummyHead >>> " + dummyHead.next);
        ListNode result = dummyHead.next;
        System.out.println("result >>> " + result);
        dummyHead.next = null;
        return result;
    }
}
