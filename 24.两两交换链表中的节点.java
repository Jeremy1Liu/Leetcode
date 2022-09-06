/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        //根据别人解法采用栈来实现。还有递归和迭代需要学习！
        if(head==null || head.next==null)
            return head;
        
        Stack<ListNode> stacktemp = new Stack<ListNode>();
        ListNode p1 = new ListNode(-1);
        ListNode cur = head;
        head = p1;

        while(cur != null && cur.next != null){
            stacktemp.add(cur);
            stacktemp.add(cur.next);
            cur = cur.next.next; //这个语句放在最后就会time exceed, why?
            p1.next = stacktemp.pop();
            p1 = p1.next;
            p1.next = stacktemp.pop();
            p1 = p1.next;
            
        }

        p1.next = cur;


        return head.next;

    }
}
// @lc code=end

