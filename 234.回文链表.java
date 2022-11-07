/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode fast = head.next, slow = head;
        //try to get the middle position
        //slow is on the middle, when the fast goes to end.
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //说明是偶数节点, 让slow指向下一个节点；
        if(fast != null) {
            slow = slow.next;
        cut(head, slow);

        return isEqual(head, reverse(slow));
        }
        //说明是奇数个节点，从slow处切断前链表，并把slow.next进行反转和比较
        else{
            cut(head, slow);
            return isEqual(head, reverse(slow.next));
        }
        

    }
    private void cut(ListNode head, ListNode cutNode){
        while(head.next != cutNode){
            head = head.next;
        }
        head.next = null;
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head != null) {
            ListNode nex = head.next;
            head.next = pre;
            pre = head;
            head = nex;
        }
        return pre;
    }

    private boolean isEqual(ListNode l1, ListNode l2){
        while(l1 != null || l2 != null){
            if(l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
// @lc code=end

