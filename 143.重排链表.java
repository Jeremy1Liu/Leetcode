import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        // if(head == null) return;
        // List<ListNode> list = new ArrayList<>();
        // while(head != null){
        //     list.add(head);
        //     head = head.next;
        // }
        // int i=0, j=list.size() - 1;
        // while( i<j ){
        //     list.get(i).next = list.get(j);
        //     i++;
        //     if(i<j){
        //         list.get(j).next = list.get(i);
        //         j--;
        //     }
        // }
        // list.get(i).next = null;
        if(head==null || head.next==null) return;
        ListNode hi = head.next, lo = head;
        while(hi.next != null){
            lo = lo.next;
            hi = hi.next.next;
        }

        

    }
}
// @lc code=end

