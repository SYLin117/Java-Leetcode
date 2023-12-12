//You are given two non-empty linked lists representing two non-negative
//integers. The digits are stored in reverse order, and each of their nodes contains a
//single digit. Add the two numbers and return the sum as a linked list.
//
// You may assume the two numbers do not contain any leading zero, except the
//number 0 itself.
//
//
// Example 1:
//
//
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
//
//
// Example 2:
//
//
//Input: l1 = [0], l2 = [0]
//Output: [0]
//
//
// Example 3:
//
//
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
//
//
//
// Constraints:
//
//
// The number of nodes in each linked list is in the range [1, 100].
// 0 <= Node.val <= 9
// It is guaranteed that the list represents a number that does not have
//leading zeros.
//
//
// Related Topics Linked List Math Recursion 👍 28807 👎 5558

package leetcode.editor.en;

import leetcode.editor.en.ds.ListNode;

import java.util.List;

class P2AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(9);
//        l1.next.next.next = new ListNode(0);
//        l1.next.next.next.next = new ListNode(1);
//        l1.next.next.next.next.next = new ListNode(9);
//        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(9);
        System.out.println(solution.addTwoNumbers(l1, l2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode pre = dummy;

            int carry = 0;
            while (l1 != null && l2 != null) {
                ListNode newNode = new ListNode((l1.val + l2.val + carry) % 10);
                carry = (l1.val + l2.val + carry) / 10;

                pre.next = newNode;
                pre = pre.next;
                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                ListNode newNode = new ListNode((l1.val + carry) % 10);
                carry = (l1.val + carry) / 10;

                pre.next = newNode;
                l1 = l1.next;
                pre = pre.next;
            }

            while (l2 != null) {
                ListNode newNode = new ListNode((l2.val + carry) % 10);
                carry = (l2.val + carry) / 10;

                pre.next = newNode;
                l2 = l2.next;
                pre = pre.next;
            }
            if (carry > 0) {
                ListNode newNode = new ListNode(carry);
                pre.next = newNode;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}