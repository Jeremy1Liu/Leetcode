import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        //统计每个元素出现次数
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //方法1： 使用优先队列, 把hashMap中的key，按照value（即出现次数）来进行堆排序，value大排在上面；
        // PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        // //遍历整个hashMap, 按照key来遍历，插入pq时是按照map.value的值来比较和排序的
        // //这个是小顶堆，如果size超过且大于，则取出
        // for(Integer key : map.keySet()){
        //     if(pq.size() < k) pq.add(key);
        //     else if(map.get(key) > map.get(pq.peek())){
        //         pq.remove();
        //         pq.add(key);
        //     }
        // }//把pq中存入的最高频的key依次取出，放入res
        // for(int i=0; i<k; i++){
        //     res[i] = pq.remove();
        // }

        // return res;

        //方法2：使用大顶堆(与之对应，上面方法是创建最小堆。topK元素的最小堆；)
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        // for(int key : map.keySet()){
        //     //最大的value的key都存入maxHeap的最上层
        //     maxHeap.add(key);
        // }
        // for(int i=0; i<k; i++){
        //     res[i] = maxHeap.remove();
        // }
        // return res;

        
        

        //方法3：桶排序bucket sort
        //相同频率可能有不同的key，因此需要用List来存储这些key；
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for(int key : map.keySet()){
            int freq = map.get(key);
            //如果此位置为null，则创建新ArrayList
            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            //如果非空，则添加key到此List;
            bucket[freq].add(key);
        }

        int index = 0;
        //bucket从后往前，即为频率最高的key，因此按此方向来遍历，直到找到所需的k个key值；
        for(int i=bucket.length-1; i>=0; i--){
            if(bucket[i] != null){
                //此为遍历List中的所有key值；
                for(int val : bucket[i]){
                    res[index++] = val;
                    if(index == k) return res;
                }
            }
        }
        return res;
        


        //方法4： 也可以使用stream
        //速度太慢，而且起不到训练leetcode的目的
        // return map.entrySet().
        // stream()
        // .sorted((m1, m2) -> m2.getValue() - m1.getValue())
        // .limit(k)
        // .mapToInt(Map.Entry::getKey)
        // .toArray();

        


    }
}
// @lc code=end

