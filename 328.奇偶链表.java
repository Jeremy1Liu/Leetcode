import javax.management.ListenerNotFoundException;

/*
 * @lc app=leetcode.cn id=328 lang=java
 *
 * [328] 奇偶链表
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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        //利用两个链表串联下这些数据，但是不使用额外空间，只存储头节点，并利用Cur进行步进
        ListNode oddHead = head, oddCur = head;
        ListNode evenHead = head.next, evenCur = evenHead;
        while(oddCur.next != null && evenCur.next != null){
            oddCur.next = oddCur.next.next;
            evenCur.next = evenCur.next.next;
            oddCur = oddCur.next;
            evenCur = evenCur.next;
        }
        //最后偶数链表和基数链表尾链接起来。
        oddCur.next = evenHead;
        return head;
    }
}
// @lc code=end

