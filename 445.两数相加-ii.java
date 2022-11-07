import java.util.Stack;

import javax.management.ListenerNotFoundException;

/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = new ListNode(-1);
        while(!stack1.isEmpty() || !stack2.isEmpty() || carry != 0){
            int sum = carry;
            sum+= stack1.isEmpty() ? 0 : stack1.pop();
            sum+= stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode(sum%10);
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }

        return head.next;
    }
}
// @lc code=end

