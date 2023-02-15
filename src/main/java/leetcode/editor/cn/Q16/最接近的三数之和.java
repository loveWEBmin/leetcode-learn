//<p>给你一个长度为 <code>n</code> 的整数数组&nbsp;<code>nums</code><em>&nbsp;</em>和 一个目标值&nbsp;<code>target</code>。请你从 <code>nums</code><em> </em>中选出三个整数，使它们的和与&nbsp;<code>target</code>&nbsp;最接近。</p>
//
//<p>返回这三个数的和。</p>
//
//<p>假定每组输入只存在恰好一个解。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [-1,2,1,-4], target = 1
//<strong>输出：</strong>2
//<strong>解释：</strong>与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [0,0,0], target = 1
//<strong>输出：</strong>0
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>3 &lt;= nums.length &lt;= 1000</code></li> 
// <li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li> 
// <li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 1332</li><li>👎 0</li></div>

package leetcode.editor.cn.Q16;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int result = (int) Math.pow(10, 5);
        int length = nums.length;
        for (int i = 0; i < (length - 2); i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int x = i + 1;
            int y = length - 1;
            while (x < y) {
                int sum = nums[i] + nums[x] + nums[y];
                int n1 = target - sum;
                int abs1 = Math.abs(n1);
                int abs2 = Math.abs(target - result);
                if (abs1 < abs2) {
                    result = sum;
                }
                if (n1 == 0) {
                    return result;
                } else if (n1 > 0) {
                    while (x < y && nums[x+1] == nums[x]) {
                        x++;
                    }
                    x++;
                } else {
                    while (x < y && nums[y-1] == nums[y]) {
                        y--;
                    }
                    y--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSumClosest(
                new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));
        /**
         * 	测试用例:[4,0,5,-5,3,3,0,-4,-5]
         * 			-2
         * 	测试结果:-4
         * 	期望结果:-2
         */
    }
}
//leetcode submit region end(Prohibit modification and deletion)
