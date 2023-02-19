//<p>给你一个链表数组，每个链表都已经按升序排列。</p>
//
//<p>请你将所有链表合并到一个升序链表中，返回合并后的链表。</p>
//
//<p>&nbsp;</p>
//
//<p><strong>示例 1：</strong></p>
//
//<pre><strong>输入：</strong>lists = [[1,4,5],[1,3,4],[2,6]]
//<strong>输出：</strong>[1,1,2,3,4,4,5,6]
//<strong>解释：</strong>链表数组如下：
//[
//  1-&gt;4-&gt;5,
//  1-&gt;3-&gt;4,
//  2-&gt;6
//]
//将它们合并到一个有序链表中得到。
//1-&gt;1-&gt;2-&gt;3-&gt;4-&gt;4-&gt;5-&gt;6
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre><strong>输入：</strong>lists = []
//<strong>输出：</strong>[]
//</pre>
//
//<p><strong>示例 3：</strong></p>
//
//<pre><strong>输入：</strong>lists = [[]]
//<strong>输出：</strong>[]
//</pre>
//
//<p>&nbsp;</p>
//
//<p><strong>提示：</strong></p>
//
//<ul> 
// <li><code>k == lists.length</code></li> 
// <li><code>0 &lt;= k &lt;= 10^4</code></li> 
// <li><code>0 &lt;= lists[i].length &lt;= 500</code></li> 
// <li><code>-10^4 &lt;= lists[i][j] &lt;= 10^4</code></li> 
// <li><code>lists[i]</code> 按 <strong>升序</strong> 排列</li> 
// <li><code>lists[i].length</code> 的总和不超过 <code>10^4</code></li> 
//</ul>
//
//<div><div>Related Topics</div><div><li>链表</li><li>分治</li><li>堆（优先队列）</li><li>归并排序</li></div></div><br><div><li>👍 2332</li><li>👎 0</li></div>

package leetcode.editor.cn.Q23;
//leetcode submit region begin(Prohibit modification and deletion)


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    /**
     * 直接取值排序
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            while (list != null) {
                priorityQueue.offer(list);
                ListNode next = list.next;
                list.next = null;
                list = next;
            }
        }

        if (priorityQueue.size() == 0) {
            return null;
        }

        ListNode head = priorityQueue.poll();
        ListNode pre = head;
        while (priorityQueue.size() > 0) {
            ListNode next = priorityQueue.poll();
            pre.next = next;
            pre = next;
        }

        return head;
    }

    /**
     * 分而治理的思路。两个两个合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode mergeList = lists[0];

        for (int i = 1; i < lists.length; i++) {
            mergeList = mergeKTowLists(mergeList, lists[i]);
        }

        return mergeList;
    }

    public ListNode mergeKTowLists (ListNode up, ListNode down) {
        if (up == null || down == null) return up == null ? down : up;

        ListNode l11 = up;
        ListNode l12 = null;
        ListNode l20 = null;
        ListNode l21 = down;
        ListNode l22 = null;
        ListNode result = l11.val <= l21.val ? l11 : l21;


        while (!(l11 == null || l21 == null)) {
            l12 = l11.next;
            l22 = l21.next;
            if (l11.val <= l21.val) {
                l11.next = l21;
                if (l20 != null) {
                    l20.next = l11;
                }
                l20 = l11;
                l11 = l12;
            } else {
                if (l22 == null) {
                    l21.next = l11;
                    break;
                } else if (l22.val >= l11.val) {
                    l21.next = l11;
                    l11.next = l22;
                    l20 = l11;
                    l11 = l12;
                    l21 = l22;
                } else if (l22.val < l11.val) {
                    if (l22.next == null) {
                        l22.next = l11;
                        break;
                    }
                    l20 = l22;
                    l21 = l22.next;
                }
            }
        }

        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public static void main(String[] args) {
        List<ListNode> listNode = ListNode.getListNode(new int[][]{{1,4,5}, {1,3,4}, {2,6}});
//        System.out.println(new Solution().mergeKLists(listNode.toArray(new ListNode[listNode.size()])));
        System.out.println(new Solution().mergeKLists(listNode.toArray(new ListNode[listNode.size()])));
    }

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
