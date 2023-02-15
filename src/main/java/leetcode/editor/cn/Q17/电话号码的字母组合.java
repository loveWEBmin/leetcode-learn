//<p>给定一个仅包含数字&nbsp;<code>2-9</code>&nbsp;的字符串，返回所有它能表示的字母组合。答案可以按 <strong>任意顺序</strong> 返回。</p>
//
//<p>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。</p>
//
//<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/11/09/200px-telephone-keypad2svg.png" style="width: 200px;" /></p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>digits = "23"
//<strong>输出：</strong>["ad","ae","af","bd","be","bf","cd","ce","cf"]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>digits = ""
//<strong>输出：</strong>[]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>digits = "2"
//<strong>输出：</strong>["a","b","c"]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>0 &lt;= digits.length &lt;= 4</code></li> 
// <li><code>digits[i]</code> 是范围 <code>['2', '9']</code> 的一个数字。</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>哈希表</li><li>字符串</li><li>回溯</li></div></div><br><div><li>👍 2303</li><li>👎 0</li></div>

package leetcode.editor.cn.Q17;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String[] metaCode = "abc,def,ghi,jkl,mno,pqrs,tuv,wxyz".split(",");
    int sizeOfOneNumber = 3;

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("7"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        hs(0, digits, "", "", result);
        return result;
    }

    private void hs(int level, String digits, String frontStr, String current, List<String> result) {
        if (level == digits.length()) {
            result.add(frontStr + current);
            return;
        }

        frontStr += current;
        char[] metaChars = getMetaChars(digits.charAt(level));
        for (int i = 0; i < metaChars.length; i++) {
            hs(level + 1, digits, frontStr, "" + metaChars[i], result);
        }
    }

    private char[] getMetaChars(char number) {
        int index = (Integer.parseInt("" + number) - 2);
        return metaCode[index].toCharArray();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
