import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=705 lang=java
 *
 * [705] 设计哈希集合
 */

// @lc code=start
class MyHashSet {
    


    Node head = new Node(-1);
    Node temp = head;

    public MyHashSet() {
        

    }
    
    public void add(int key) {
        temp.next = new Node(key);
        temp = temp.next;
    }
    
    public void remove(int key) {
        while(head.next != null){
            if(head.next.val == key) {
                head.next = head.next.next;
            }
        }
    }
    
    public boolean contains(int key) {
        while(head.next != null){
            if(head.next.val == key) {
                return true;
            }
        }
        return false;
    }
}

static class Node{
    private int val;
    private Node next;
    private Node(int val){
        this.val = val;
    }
}



/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @lc code=end

