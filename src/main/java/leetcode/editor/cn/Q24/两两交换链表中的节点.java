//<p>给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p> 
//<img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/swap_ex1.jpg" style="width: 422px; height: 222px;" /> 
//<pre>
//<strong>输入：</strong>head = [1,2,3,4]
//<strong>输出：</strong>[2,1,4,3]
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>head = []
//<strong>输出：</strong>[]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre>
//<strong>输入：</strong>head = [1]
//<strong>输出：</strong>[1]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li>链表中节点的数目在范围 <code>[0, 100]</code> 内</li> 
// <li><code>0 &lt;= Node.val &lt;= 100</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>递归</li><li>链表</li></div></div><br><div><li>👍 1717</li><li>👎 0</li></div>

package leetcode.editor.cn.Q24;
//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;
import java.util.List;

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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode response = head.next;
        exchangeNode(null, head);
        return response;
    }

    public void exchangeNode(ListNode pre, ListNode current) {
       if (current == null || current.next == null) return;
       ListNode next = current.next;

       if (pre != null) {
           pre.next = next;
       }

       current.next = next.next;
       next.next = current;
       exchangeNode(current, current.next);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static List<ListNode> getListNode(int[][] inputParam) {
        List<ListNode> listNodes = new ArrayList<>();
        for (int[] ints : inputParam) {
            ListNode a = null;
            if (ints.length > 0) {
                a = new ListNode();
                a.val = ints[0];
                listNodes.add(a);
                for (int i = 1; i < ints.length; i++) {
                    ListNode listNode = new ListNode(ints[i]);
                    a.next = listNode;
                    a = listNode;
                }
            } else {
                listNodes.add(a);
            }
        }
        return listNodes;
    }

}
