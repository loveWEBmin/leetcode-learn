//<p>数字 <code>n</code>&nbsp;代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 <strong>有效的 </strong>括号组合。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 3
//<strong>输出：</strong>["((()))","(()())","(())()","()(())","()()()"]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 1
//<strong>输出：</strong>["()"]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= n &lt;= 8</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>字符串</li><li>动态规划</li><li>回溯</li></div></div><br><div><li>👍 3083</li><li>👎 0</li></div>

package leetcode.editor.cn.Q22;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {
        new Solution().generateParenthesis(2);
    }
    static String labels = "()";
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dps(n, n, res, "");
        return res;
    }

    public void dps(int left, int right, List<String> result, String genStr) {
        if (left == 0 && right == 0) {
            result.add(genStr);
        }

        if (left > 0) {
            dps(left - 1, right, result, genStr + "(");
        }

        if (right > left) {
            dps(left, right - 1, result, genStr + ")");
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
