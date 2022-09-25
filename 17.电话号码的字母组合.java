import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    //设置全局变量列表存储最后的结果
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        
        //初始时对应所有数字，2-9；
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno",
                        "pqrs", "tuv", "wxyz"};
        //递归处理
        backTracking(digits, numString, 0);
        return res;
    }

    //每次递归获取一个字符串，这里选择
    StringBuilder sb = new StringBuilder();

    //比如digits是“23”， num为0，在str表示2对应的abc
    private void backTracking(String digits, String[] numStrings, int num){
        //遍历全部一次记录一次得到的字符串
        if(num == digits.length()){
            res.add(sb.toString());
            return;
        }

        //digits 用num来控制
        //str，用i来控制。
        //str 表示当前num对应的字符串,可能是abc, 或def；
        String str = numStrings[digits.charAt(num) - '0'];
        for(int i=0; i < str.length(); i++){
            sb.append(str.charAt(i));
            //c
            backTracking(digits, numStrings, num+1);
            //剔除末尾，继续尝试
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    
}
// @lc code=end

