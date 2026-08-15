public class ReverseLinkedListII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        // Move prev to the node before left
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode current = prev.next;

        // Reverse nodes from left to right
        for (int i = 0; i < right - left; i++) {

            ListNode nextNode = current.next;

            current.next = nextNode.next;

            nextNode.next = prev.next;

            prev.next = nextNode;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> 4 -> 5

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int left = 2;
        int right = 4;

        head = reverseBetween(head, left, right);

        printList(head);
    }
}