/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        HashMap<RandomListNode, RandomListNode> copy = new HashMap<>();
        RandomListNode current = head;
        while (current != null) {
            copy.put(current, new RandomListNode(current.label));
            current = current.next;
        }
        current = head;
        while (current != null) {
            RandomListNode currCop = copy.get(current);
            currCop.next = copy.get(current.next);
            currCop.random = copy.get(current.random);
            current = current.next;
        }
        return copy.get(head);
    }
}
