package Linkedl;

public class CSLL {

    Node head;
    Node tail;
    private int size;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            size++;
        }
    }

    void insertAtfirst(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            tail.next = head;
            return;
        }

        node.next = head;
        head = node;
        tail.next = head;
    }

    void insertAtspecific(int data, int index) {

        if (index < 0 || index > size) {
            System.out.println("Invalid Index");
            return;
        }

        if (index == 0) {
            insertAtfirst(data);
            return;
        }

        if (index == size) {
            insertAtlast(data);
            return;
        }

        Node currnode = head;
        for (int i = 1; i < index; i++) {
            currnode = currnode.next;
        }

        Node node = new Node(data);
        node.next = currnode.next;
        currnode.next = node;
    }

    void insertAtlast(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        tail.next = node;
        tail = node;
    }

    void deleteAtfirst() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }

        head = head.next;
        tail.next = head;
        size--;
    }

    void deleteAtspecific(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid Index");
            return;
        }

        if (index == 0) {
            deleteAtfirst();
            return;
        }

        if (index == size-1) {
            deleteAtlast();
            return;
        }

        Node currnode = head;
        for (int i = 1; i < index; i++) {
            currnode = currnode.next;
        }

        currnode.next = currnode.next.next;
        size--;

    }

    void deleteAtlast() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }

        Node currnode = head;
        while (currnode.next != tail) {
            currnode = currnode.next;
        }

        currnode.next = head;
        tail = currnode;
        size--;
    }

    void print() {
        if (head == null) {
            System.out.println("linkedlist is empty");
            return;
        }

        Node currnode = head;
        while (currnode != tail) {
            System.out.print(currnode.data + "=>");
            currnode = currnode.next;
        }

        System.out.println(tail.data);
    }

    void getsize() {
        System.out.println(size);
        ;
    }

    public static void main(String[] args) {
        CSLL list = new CSLL();
        list.insertAtfirst(12);
        list.insertAtfirst(11);
        list.insertAtfirst(10);
        list.insertAtlast(13);
        list.insertAtlast(14);
        list.insertAtlast(15);
        // list.print();
        // list.getsize();
        // list.deleteAtfirst();
        // list.print();
        // list.deleteAtlast();
        // list.print();
        // list.getsize();
        list.insertAtspecific(50, 6);
        list.print();
        list.deleteAtspecific(8);
        list.print();
        list.getsize();
    }

}
