package Linkedl;

public class CDLL {

    Node head;
    Node tail;
    private int size;

    class Node {
        int data;
        Node next;
        Node previous;

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
            head.previous = tail;
            tail.next = head;
            return;
        }

        node.next = head;
        head.previous = node;
        tail.next = node;
        node.previous = tail;
        head = node;
    }

    void insertAtspecific(int data, int index) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
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

        Node curnode = head;
        for (int i = 1; i < index; i++) {
            curnode = curnode.next;
        }

        Node node = new Node(data);
        node.next = curnode.next;
        node.previous = curnode;
        curnode.next.previous = node;
        curnode.next = node;
    }

    void insertAtlast(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
            head.previous = tail;
            tail.next = head;
            return;
        }

        node.previous = tail;
        node.next = head;
        tail.next = node;
        head.previous = node;
        tail = node;
    }

    void deleteAtfirst() {
        if (head == null) {
            System.out.println("Empty LinkedList");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            System.out.println("Deleted");
            return;
        }

        tail.next = head.next;
        head.next.previous = tail;
        head = head.next;
        size--;
    }

    void deleteAtspecific(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 0) {
            deleteAtfirst();
            return;
        }

        if (index == size - 1) {
            deleteAtlast();
            return;
        }

        Node curnode = head;
        for (int i = 1; i < index; i++) {
            curnode = curnode.next;
        }

        curnode.next.next.previous = curnode; 
        curnode.next = curnode.next.next;
        size--;
    }

    void deleteAtlast() {
        if (head == null) {
            System.out.println("Empty LinkedList");
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            size--;
            System.out.println("Deleted");
            return;
        }

        Node currnode = head;
        while (currnode.next != tail) {
            currnode = currnode.next;
        }

        currnode.next = head;
        tail = currnode;
        head.previous = tail;
        size--;
    }

    void print() {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }

        Node currnode = head;
        while (currnode != tail) {
            System.out.print(currnode.data + "<=>");
            currnode = currnode.next;
        }

        System.out.println(tail.data);

    }

    void printrev(){
        if (head == null) {
            System.out.println("Empty LinkedList");
            return;
        }

        Node currnode = tail;

        while (currnode!=head) {
            System.out.print(currnode.data + "<=>");
            currnode = currnode.previous;
        }

        System.out.println(head.data);
    }

    void getsize() {
        System.out.println(size);
    }

    public static void main(String[] args) {
        CDLL list = new CDLL();
        list.insertAtfirst(12);
        list.insertAtfirst(11);
        list.insertAtfirst(10);
        list.insertAtlast(13);
        list.insertAtlast(14);
        list.insertAtlast(15);
        list.print();
        list.getsize();
        list.deleteAtfirst();
        list.print();
        list.getsize();
        list.deleteAtlast();
        list.print();
        list.getsize();
        list.insertAtspecific(50, 3);
        list.print();
        list.getsize();
        list.deleteAtspecific(4);
        list.print();
        list.getsize();
        list.printrev();
    }
}
