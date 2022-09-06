/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode preHead = null, cur=head, next;
        while(cur != null){
            next = cur.next;
            cur.next = preHead;
            preHead = cur;
            cur = next;


        }
        return preHead;




        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // if(head==null || head.next==null) return head;

        // ListNode pre = null, curr = head, nex;
        // while(curr != null){
        //     nex = curr.next;
        //     curr.next = pre;
        //     pre = curr;
        //     curr = nex;
        // }
        // return pre;

        // if(head==null || head.next==null) return head;
        // ListNode ReverseHead = new ListNode(0), temp = head, temp2;
        // while(temp != null){
        //     temp2 = temp.next;
        //     temp.next = ReverseHead.next;
        //     ReverseHead.next = temp;
        //     temp = temp2;
        // }
        // return ReverseHead.next;
    }
}
// @lc code=end

