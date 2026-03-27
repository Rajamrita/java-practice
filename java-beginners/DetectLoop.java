class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class DetectLoop {
    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        // create loop
        head.next.next.next = head;

        Node slow = head;
        Node fast = head;

        boolean loop = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                loop = true;
                break;
            }
        }

        if (loop)
            System.out.println("Loop detected");
        else
            System.out.println("No loop");
    }
}
