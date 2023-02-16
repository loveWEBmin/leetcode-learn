//<p>给定一个只包括 <code>'('</code>，<code>')'</code>，<code>'{'</code>，<code>'}'</code>，<code>'['</code>，<code>']'</code>&nbsp;的字符串 <code>s</code> ，判断字符串是否有效。</p>
//
//<p>有效字符串需满足：</p>
//
//<ol> 
// <li>左括号必须用相同类型的右括号闭合。</li> 
// <li>左括号必须以正确的顺序闭合。</li> 
// <li>每个右括号都有一个对应的相同类型的左括号。</li> 
//</ol>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "()"
//<strong>输出：</strong>true
//</pre>
//
//<p><strong>示例&nbsp;2：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "()[]{}"
//<strong>输出：</strong>true
//</pre>
//
//<p><strong>示例&nbsp;3：</strong></p>
//
//<pre>
//<strong>输入：</strong>s = "(]"
//<strong>输出：</strong>false
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li> 
// <li><code>s</code> 仅由括号 <code>'()[]{}'</code> 组成</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>栈</li><li>字符串</li></div></div><br><div><li>👍 3733</li><li>👎 0</li></div>

package leetcode.editor.cn.Q20;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String startLabel = "([{";
    String endLabel = ")]}";

    public static void main(String[] args) {
        new Solution().isValid("()[]{}");
    }

    public boolean isValid(String s) {
        try {

            Stack<Character> stack = new Stack();
            int length = s.length();

            int halfLength = length / 2;

            for (int i = 0; i < halfLength; i++) {
                char label = s.charAt(i);
                if (isStartLabel(label)) {
                    stack.push(label);
                } else {
                    char correspondStartLabel = getCorrespondStartLabel(label);
                    Character pop = stack.pop();
                    if (correspondStartLabel != pop.charValue()) {
                        return false;
                    }
                }
            }

            for (int i = halfLength; i < length; i++) {
                // 如果栈里面比没有遍历的多，肯定消话不完了
                if (stack.size() > length - i) {
                    return false;
                }
                char label = s.charAt(i);
                if (isStartLabel(label)) {
                    stack.push(label);
                } else {
                    char correspondStartLabel = getCorrespondStartLabel(label);
                    Character pop = stack.pop();
                    if (correspondStartLabel != pop.charValue()) {
                        return false;
                    }
                }
            }

            return stack.size() == 0;
        } catch (Exception e) {
            // 如果堆栈没值了，还弹窗会报错
            return false;
        }
    }

    public boolean isStartLabel(char label) {
        for (char c : startLabel.toCharArray()) {
            if (label == c) {
                return true;
            }
        }
        return false;
    }

    public char getCorrespondStartLabel(char label) {
        for (int i = 0; i < endLabel.toCharArray().length; i++) {
            if (endLabel.charAt(i) == label) {
                return startLabel.charAt(i);
            }
        }
        throw new RuntimeException("参数错误");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
