class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Find length and tail
        ListNode temp = head;
        int len = 1;

        while (temp.next != null) {
            temp = temp.next;
            len++;
        }

        // 2. Reduce unnecessary rotations
        k = k % len;

        if (k == 0) {
            return head;
        }

        // 3. Connect tail to head (make circular list)
        temp.next = head;

        // 4. Find new tail
        int steps = len - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // 5. Set new head and break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}