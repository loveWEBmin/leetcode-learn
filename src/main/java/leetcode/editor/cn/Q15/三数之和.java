//<p>给你一个整数数组 <code>nums</code> ，判断是否存在三元组 <code>[nums[i], nums[j], nums[k]]</code> 满足 <code>i != j</code>、<code>i != k</code> 且 <code>j != k</code> ，同时还满足 <code>nums[i] + nums[j] + nums[k] == 0</code> 。请</p>
//
//<p>你返回所有和为 <code>0</code> 且不重复的三元组。</p>
//
//<p><strong>注意：</strong>答案中不可以包含重复的三元组。</p>
//
//<p>&nbsp;</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [-1,0,1,2,-1,-4]
//<strong>输出：</strong>[[-1,-1,2],[-1,0,1]]
//<strong>解释：</strong>
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [0,1,1]
//<strong>输出：</strong>[]
//<strong>解释：</strong>唯一可能的三元组和不为 0 。
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>nums = [0,0,0]
//<strong>输出：</strong>[[0,0,0]]
//<strong>解释：</strong>唯一可能的三元组和为 0 。
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>3 &lt;= nums.length &lt;= 3000</code></li> 
// <li><code>-10<sup>5</sup> &lt;= nums[i] &lt;= 10<sup>5</sup></code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>排序</li></div></div><br><div><li>👍 5631</li><li>👎 0</li></div>

package leetcode.editor.cn.Q15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < (length - 2); i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] + nums[length-1] + nums[length-2] < 0) {
                continue;
            }
            if (nums[i] + nums[i+1] + nums[i+2] > 0) {
                continue;
            }
            int x = i + 1;
            int y = length - 1;
            while (x < y) {
                int result = nums[i] + nums[x] + nums[y];
                if (result == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[x], nums[y]));
                    x++;
                    while (x < y && nums[x] == nums[x-1]) {
                        x++;
                    }
                    y--;
                    while (x < y && nums[y] == nums[y+1]) {
                        y--;
                    }
                } else if (result > 0) {
                    y--;
                } else {
                    x++;
                }
            }
        }

        return resultList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
