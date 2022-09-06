/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
        //建立哨兵节点pre
        ListNode pre = new ListNode(0);
        //利用cur来进行步进
        ListNode cur = pre;
        //利用carry来记录每次要进位的值
        int carry = 0;

        //终止条件，当2个链表都为空，则终止；
        while(l1 != null || l2 != null){
            //需要判定，因为可能为null，如果为null，则定义值为0
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            //把上次计算得出的carry，每次加入sum中；
            int sum = x + y + carry;
            carry = sum>9 ? 1 : 0;
            sum = sum % 10;
            cur.next = new ListNode(sum);
            cur = cur.next;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry == 1) cur.next = new ListNode(1);

        return pre.next;

    }
}
// @lc code=end

