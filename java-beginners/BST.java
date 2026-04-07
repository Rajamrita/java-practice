class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class BST {

    static Node insert(Node root, int data) {
        if (root == null) return new Node(data);

        if (data < root.data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        return root;
    }

    public static void main(String[] args) {

        Node root = null;

        root = insert(root, 5);
        insert(root, 3);
        insert(root, 7);

        System.out.println("BST created");
    }
}
