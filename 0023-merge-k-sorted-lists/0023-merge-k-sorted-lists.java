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
class NodeComparator implements Comparator<ListNode> {

    @Override
    public int compare(ListNode a, ListNode b) {
        return Integer.compare(a.val, b.val);
    }
}

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq =
            new PriorityQueue<>(new NodeComparator());

        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!pq.isEmpty()) {

            ListNode node = pq.poll();

            curr.next = node;
            curr = curr.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}