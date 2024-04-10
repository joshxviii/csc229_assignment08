package assignment_package;


class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
    }

    public Node getHead() {
        return head;
    }
    public boolean hasHead() {
        if (head != null) return true;
        else return false;
    }

    public void print() {
        if (head != null) print(head);
    }
    public Node print(Node node) {
        if (node != null) {
            System.out.print(node.data);
            if (node.next != null) System.out.print(", ");
            else System.out.print("\n");
            return print(node.next);
        }
        else return null;
    }


    public void append(Node newNode) {
        if (head == null) {
            head = newNode;
        }
        else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public void prepend(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }



    public void insertAfter(Node currentNode, Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else if (currentNode == tail) {
            tail.next = newNode;
            tail = newNode;
        }
        else {
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        size++;
    }


    public void removeAfter(Node currentNode) {
        if (currentNode == null && head != null) {
            // Special case: remove head
            Node succeedingNode = head.next;
            head = succeedingNode;
            if (succeedingNode == null) {
                // Last item was removed
                tail = null;
                size--;
            }
        }
        else if (currentNode.next != null) {
            Node succeedingNode = currentNode.next.next;
            currentNode.next = succeedingNode;
            if (succeedingNode == null) {
                // Remove tail
                tail = currentNode;
                size--;
            }
        }
    }
}