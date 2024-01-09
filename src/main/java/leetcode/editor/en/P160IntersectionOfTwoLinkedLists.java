
package leetcode.editor.en;

import leetcode.editor.en.ds.ListNode;

import java.util.List;

class P160IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        // Solution solution = new P160 Solution();
        Solution sol = new P160IntersectionOfTwoLinkedLists().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lenA = 0;
            int lenB = 0;
            ListNode dummyA = new ListNode(0, headA);
            ListNode dummyB = new ListNode(0, headB);
            while (dummyA.next != null) {
                dummyA = dummyA.next;
                lenA++;
            }

            while (dummyB.next != null) {
                dummyB = dummyB.next;
                lenB++;
            }

            while (lenA > lenB) {
                headA = headA.next;
                lenA--;
            }
            while (lenB > lenA) {
                headB = headB.next;
                lenB--;
            }
            while (headA != null || headB != null) {
                if (headA == headB) return headA;
                headA = headA.next;
                headB = headB.next;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}