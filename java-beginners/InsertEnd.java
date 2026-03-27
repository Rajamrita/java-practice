class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class InsertEnd {
    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);

        Node newNode = new Node(30);

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;

        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }
}
