/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {
    int[] nums;
    int front;
    int rear;
    int size = 0;

    public MyCircularDeque(int k) {
        nums = new int[k];
        front = k-1;
        rear = 0;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        else{
            nums[front] = value;
            front = (front - 1 + nums.length) % nums.length;
            size++;
            return true;
        }
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        else{
            nums[rear] = value;
            rear = (rear + 1) % nums.length;
            size++;
            return true;
        }

    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        else{
            front = (front + 1) % nums.length;
            size--;
            return true;
        }
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        else{
            rear = (rear - 1 + nums.length) % nums.length;
            size--;
            return true;
        }

    }
    
    public int getFront() {
            if(isEmpty()) return -1;
            else return nums[(front + 1) % nums.length];

        

    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        else return nums[(rear - 1 + nums.length) % nums.length];


    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == nums.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

