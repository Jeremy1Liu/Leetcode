/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // //看答案的，利用Hash Set
        // ListNode pos = head;
        // Set<ListNode> visited = new HashSet<ListNode>();
        // while(pos != null){
        //     if(visited.contains(pos)) return pos;
        //     else visited.add(pos);
        //     pos = pos.next;
        // }
        // return null;


        //数学推导为：(a+x)*2 = a+b+x; 则a=b-x;
        //此时相遇点就在a+x的位置。让指针1从头开始，指针2从相遇点开始
        //指针1走了a到达环点，指针2走了b-x也到达环点，此时相遇在环点。
        //根据代码随想录所写的；精彩。
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {//有环
                ListNode index1 = fast;
                ListNode index2 = head;
                //两个指针，从头节点和相遇节点，各自步进，在未来相遇点即为环入口；
                //数学推导得出的。
                while(index1 != index2) {
                index1 = index1.next;
                index2 = index2.next;
                }
            return index1;
            }                        

        }
        return null;


    }
}
// @lc code=end

