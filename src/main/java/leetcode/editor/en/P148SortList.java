//Given the head of a linked list, return the list after sorting it in 
//ascending order. 
//
// 
// Example 1: 
// 
// 
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
// 
//
// Example 2: 
// 
// 
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 5 * 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.
//e. constant space)? 
//
// Related Topics Linked List Two Pointers Divide and Conquer Sorting Merge 
//Sort 👍 10995 👎 322

package leetcode.editor.en;

import leetcode.editor.en.ds.ListNode;

class P148SortList {
    public static void main(String[] args) {
        Solution solution = new P148SortList().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode sortList(ListNode head) {
            return backtracking(head);
        }

        private ListNode backtracking(ListNode head){
            ListNode second = split(head);
            if(second == null) return head;

            ListNode firstHalf = backtracking(head);
            ListNode secondHalf = backtracking(second);
            return merge(firstHalf, secondHalf);
        }

        private ListNode split(ListNode head){
            // return start of second half
            if(head==null || head.next == null) return null; // no second half

            ListNode slow = new ListNode();
            slow.next = head;
            ListNode fast = new ListNode();
            fast.next = head;

            while(fast.next!=null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode rtn = slow.next;
            slow.next = null;
            return rtn;
        }

        private ListNode merge(ListNode first, ListNode second){
            if(first == null) return second;
            if(second == null) return first;
            ListNode dummy = new ListNode();
            ListNode head = dummy;
            while(first!=null && second != null){
                if(first.val<second.val){
                    dummy.next = first;
                    first = first.next;
                }else{
                    dummy.next = second;
                    second = second.next;
                }
                dummy = dummy.next;
            }
            if(first!=null){
                dummy.next = first;
            }
            if(second!=null){
                dummy.next = second;
            }
            return head.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}