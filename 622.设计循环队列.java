import java.util.ArrayDeque;
import java.util.Deque;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/*
 * @lc app=leetcode.cn id=622 lang=java
 *
 * [622] 设计循环队列
 */

// @lc code=start
class MyCircularQueue {
    //这道题也可以用链表实现，应该自己写一写！
    int[] nums;
    int front;
    int rear;
    int capacity;

    public MyCircularQueue(int k) {
        capacity = k+1;
        nums = new int[capacity];
        front = rear = 0;
    }
    
    public boolean enQueue(int value) {
        if(this.isFull()) return false;
        nums[rear] = value;
        //所谓的循环，就是靠这个% capacity来实现；
        rear = (rear + 1) % capacity;
        return true;
    }
    
    public boolean deQueue() {
        if(this.isEmpty()) return false;
        //front前进一位，就当作删除了一个位置；
        front = (front + 1) % capacity;
        return true;
    }
    
    public int Front() {
        if(this.isEmpty()) return -1;
        else return nums[front];

    }
    
    public int Rear() {
        if(this.isEmpty()) return -1;
        //因为之前deQueue里面把rear提前加了一位，所以-1
        //因为rear可能为0， 避免出现负数index，所以加上capacity
        else return nums[(rear - 1 + capacity) % capacity];

    }
    
    public boolean isEmpty() {
        //只有初始位置时，两个指针在同一位置。以后两指针在同一位置，意味着full
        return front == rear;
    }
    
    //这里是比较难的；
    //isFull（）只会被enQueue调用，这时不用判定是否empty， 只要判定是否Full
    //这时如果rear 在front的前一位，意味着马上full!!!
    public boolean isFull() {
        return((rear + 1) % capacity == front);
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end

