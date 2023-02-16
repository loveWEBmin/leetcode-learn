//<p>将两个升序链表合并为一个新的 <strong>升序</strong> 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。&nbsp;</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/merge_ex1.jpg" style="width: 662px; height: 302px;" /> 
//<pre>
//<strong>输入：</strong>l1 = [1,2,4], l2 = [1,3,4]
//<strong>输出：</strong>[1,1,2,3,4,4]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>l1 = [], l2 = []
//<strong>输出：</strong>[]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>l1 = [], l2 = [0]
//<strong>输出：</strong>[0]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li>两个链表的节点数目范围是 <code>[0, 50]</code></li> 
// <li><code>-100 &lt;= Node.val &lt;= 100</code></li> 
// <li><code>l1</code> 和 <code>l2</code> 均按 <strong>非递减顺序</strong> 排列</li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>递归</li><li>链表</li></div></div><br><div><li>👍 2913</li><li>👎 0</li></div>

package leetcode.editor.cn.Q21;
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode l11 = null;
    ListNode l12 = null;

    ListNode l21 = null;
    ListNode l22 = null;

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode result = list1.val <= list2.val ? list1 : list2;
        linkList(list1, list2, null);

        return result;
    }

    public void linkList(ListNode list1, ListNode list2, ListNode list2Pre) {
        if (list1 == null || list2 == null) return;
        l11 = list1;
        l12 = list1.next;
        l21 = list2;
        l22 = list2.next;

        if (l11.val <= l21.val) {
            l11.next = l21;
            if (list2Pre != null) {
                list2Pre.next = l11;
            }
            linkList(l12, l21, l11);
        } else if (l11.val > l21.val) {
            if (l22 == null) {
                l21.next = l11;
            } else if (l11.val <= l22.val) {
                l21.next = l11;
                l11.next = l22;
                linkList(l12, l22, l11);
            } else {
                if (l22.next == null) {
                    l22.next = l11;
                } else {
                    linkList(l11, l22.next, l22);
                }
            }
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}