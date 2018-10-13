/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode mergeKLists (ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        // So we sort the lists by the element's value, list in lists can be null
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        // dummy is for us to add elements easier
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (pq.size() != 0) {
            ListNode current = pq.poll();
            prev.next = current;
            prev = prev.next;
            if (current.next != null) {
                pq.add(current.next);
            }
        }
        return dummy.next;
    }
}
