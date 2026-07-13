package Linkedl;

public class DLL {

    private int size;;
    Node head;

    class Node{

        int data;
        Node next;
        Node previous;

        Node(int data){
            this.data = data;
            size++;
        }

        Node(int data, Node next, Node previous){
            this.data = data;
            this.next = next;
            this.previous = previous;
            size++;
        }
    }
    
    void insertAtfirst(int data){
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }

        head.previous = node;
        node.next = head;
        head = node;
    }

    void insertAtspecific(int data,int index){    
        if (index<0 || index>size) {
            System.out.println("Invalid Index");
            return;
        }

        if (index==0) {
            insertAtfirst(data);
            return;
        }

        if (index == size) {
            insertAtlast(data);
            return;
        }

        Node currnode = head;
        for (int i = 1; i < index; i++) {
            currnode.next = currnode;
        }

        Node node = new Node(data, currnode.next, currnode.previous);
        node.next = currnode.next;
        node.previous = currnode;
        currnode.next.previous = node;
        currnode.next = node;
        
    }


    void insertAtlast(int data){
        Node node = new Node(data);
        node.next = null;
        if (head == null) {
            head.previous = null;
            head = node;
            return;
        }

        Node curnode = head;
        while (curnode.next!=null) {
            curnode = curnode.next;
        }

        curnode.next = node;
        node.previous = curnode;
    }


    void deleteAtfirst(){
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            size--;
            return;
        }
        head = head.next;
        head.previous = null;
        size--;
    }

    void deleteAtspecific(int index){

        if (index < 0 || index >= size) {
        System.out.println("Invalid Position");
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
        for (int i = 0; i < index; i++) {
            currnode = currnode.next;
        }

        currnode.previous.next = currnode.next;
        currnode.next.previous = currnode.previous;
        size--;
    }

    void deleteAtlast(){
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            size--;
            return;
        }

        Node currnode = head;
        while (currnode.next.next!=null) {
            currnode = currnode.next;
        }
        currnode.next.previous = null;
        currnode.next = null;
        size--;
    }

    void print(){
        if (head == null) {
            System.out.println("Empty LinkedList");
            return;
        }

        Node currnode = head;
        while (currnode!=null) {
            System.out.print(currnode.data + "<=>" );
            currnode = currnode.next;
        }
        System.out.println("End");
    }

    void printrev(){
        if (head == null) {
            System.out.println("Empty LinkedList");
            return;
        }

        Node currnode = head;
        Node last = null;
        while (currnode!=null) {
            last = currnode;
            currnode = currnode.next;
        }

        while (last!=null) {
            System.out.print(last.data + "<=>");
            last = last.previous;
        }

        System.out.println("Start");
    }

    int getsize(){
        return size;
    }

    public static void main(String[] args) {
        DLL a = new DLL();
        a.insertAtfirst(12);
        a.insertAtfirst(11);
        a.insertAtfirst(10);
        a.insertAtlast(13);
        a.print();
        a.printrev();
        a.deleteAtfirst();
        a.print();
        a.deleteAtlast();
        a.print();
        a.getsize();
        a.insertAtspecific(50, 1);
        a.print();
        a.deleteAtspecific(1);
        a.print();
        a.getsize();
    }
    
}