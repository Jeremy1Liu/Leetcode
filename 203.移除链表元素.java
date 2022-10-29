/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        ListNode tmp = new ListNode(0);
        ListNode sentinal = tmp;
        tmp.next = head;
        while(tmp.next != null){
            //满足情况时，需要跳过下一个节点；
            if(tmp.next.val == val){
                tmp.next = tmp.next.next;
            }
            //只有不满足情况时，才会步进
            else{
                tmp = tmp.next;
            }
            
                
            
        }
        return sentinal.next;
    }
}
// @lc code=end

