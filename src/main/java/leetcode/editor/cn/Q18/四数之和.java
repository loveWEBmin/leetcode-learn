//<p>给你一个由 <code>n</code> 个整数组成的数组&nbsp;<code>nums</code> ，和一个目标值 <code>target</code> 。请你找出并返回满足下述全部条件且<strong>不重复</strong>的四元组&nbsp;<code>[nums[a], nums[b], nums[c], nums[d]]</code>&nbsp;（若两个四元组元素一一对应，则认为两个四元组重复）：</p>
//
//<ul> 
// <li><code>0 &lt;= a, b, c, d&nbsp;&lt; n</code></li> 
// <li><code>a</code>、<code>b</code>、<code>c</code> 和 <code>d</code> <strong>互不相同</strong></li> 
// <li><code>nums[a] + nums[b] + nums[c] + nums[d] == target</code></li> 
//</ul>
//
//<p>你可以按 <strong>任意顺序</strong> 返回答案 。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [1,0,-1,0,-2,2], target = 0
//<strong>输出：</strong>[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [2,2,2,2,2], target = 8
//<strong>输出：</strong>[[2,2,2,2]]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= nums.length &lt;= 200</code></li> 
// <li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li> 
// <li><code>-10<sup>9</sup> &lt;= target &lt;= 10<sup>9</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 1502</li><li>👎 0</li></div>

package leetcode.editor.cn.Q18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> response = new ArrayList<>();
        // 数组不够4个，直接返回个空集合就好了
        if (nums == null || nums.length < 4) {
            return response;
        }
        
        // 排序，Log2N的复杂度
        Arrays.sort(nums);

        // 转化下，不然太大相加会变成负数
        long[] longNums = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            longNums[i] = nums[i];
        }
        
        // 开始遍历，先固定第1位
        int size = nums.length;
        for (int i = 0; i < (size - 3); i++) {
            // 与前一位相同，则后面能满足条件的数组包含在前一位固定的时候
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            
            // 第一位固定，+ 最后面3个最大的值都小于target，那么再遍历也不会有符合条件的
            if (longNums[i] + longNums[size - 1] + longNums[size - 2] + longNums[size - 3] < target) {
                continue;
            }
            
            // 第一位固定，+ 最前面3个最小的值都大于target,那么再遍历也不会有符合条件的
            if (longNums[i] + longNums[i+1] + longNums[i+2] + longNums[i+3] > target) {
                continue;
            }
            
            // 开始固定第2位，需要在第一位后面
            for (int j = i + 1; j < (size - 2); j++) {

                // 与前一位相同，则后面能满足条件的数组包含在前一位固定的时候
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }

                // 第1,2位固定，+ 最后面2个最大的值都小于target，那么再遍历也不会有符合条件的
                if (longNums[i] + longNums[j] + longNums[size - 1] + longNums[size - 2] < target) {
                    continue;
                }

                // 第1,2位固定，+ 最前面2个最小的值和都大于target,那么再遍历也不会有符合条件的
                if (longNums[i] + longNums[i+1] + longNums[i+2] + longNums[j] > target) {
                    continue;
                }
                
                // 第3，4位用双指针即可
                int x = j + 1;
                int y = size -1;
                
                // 第3，4位和的值
                long sum = target - (longNums[i] + longNums[j]);
                
                // 开始移动双指针
                while(x < y) {
                    // 还差的数值, result > 0 则说明需要x指针前进
                    long result = sum - (longNums[x] + longNums[y]);
                    if (result == 0) {
                        response.add(Arrays.asList(nums[i], nums[j], nums[x], nums[y]));
                        x++;
                        while (x < y && nums[x-1] == nums[x]) {
                            x ++;
                        }
                        y--;
                        while (x < y - 1 && nums[y+1] == nums[y]) {
                            y --;
                        }
                    } else if (result > 0) {
                        x++;
                    } else {
                        y--;
                    }
                }
            }
        }


        return response;
    }

    public static void main(String[] args) {
        new Solution().fourSum(new int[]{0,0,0,1000000000,1000000000,1000000000,1000000000}, 1000000000);
    }
}
//leetcode submit region end(Prohibit modification and deletion)