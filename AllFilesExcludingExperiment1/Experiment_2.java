public class Experiment_2 {
    static class Node {
        int data;
        Node next;
        Node prev;
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    static Node head;
    static Node tail;

    static void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    static void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    static void insertAtMid(int data) {
        if (head == null) {
            insertAtBeginning(data);
            return;
        }
        
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        Node newNode = new Node(data);
        newNode.next = slow.next;
        newNode.prev = slow;
        if (slow.next != null) {
            slow.next.prev = newNode;
        } else {
            tail = newNode;
        }
        slow.next = newNode;
    }

    static void deleteNode(int data) {
        if (head == null) return;
        
        Node current = head;
        while (current != null && current.data != data) {
            current = current.next;
        }
        
        if (current == null) return;
        
        if (current.prev != null) {
            current.prev.next = current.next;
        } else {
            head = current.next;
        }
        
        if (current.next != null) {
            current.next.prev = current.prev;
        } else {
            tail = current.prev;
        }
    }

    static boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) return true;
            current = current.next;
        }
        return false;
    }

    static void reverse() {
        Node current = head;
        Node temp = null;
        
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        
        if (temp != null) {
            tail = head;
            head = temp.prev;
        }
    }

    static void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    static void printReverse() {
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        insertAtEnd(1);
        insertAtEnd(2);
        insertAtEnd(3);
        insertAtEnd(4);
        insertAtEnd(5);
        System.out.println("After insertions at end:");
        printList();

        insertAtBeginning(0);
        System.out.println("After insertion at beginning:");
        printList();

        insertAtMid(9);
        System.out.println("After insertion at middle:");
        printList();

        deleteNode(4);
        System.out.println("After deletion of 4:");
        printList();

        System.out.println("Search 9: " + search(9));
        System.out.println("Search 10: " + search(10));

        System.out.println("Reverse traversal:");
        printReverse();

        reverse();
        System.out.println("After reversing list:");
        printList();
    }
}