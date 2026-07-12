package Linkedl;

public class LL {
    Node head;
    private int size;

    LL() {
        this.size = 0;
    }

    class Node { // node creation
        int data; // data which we want in the list
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
            size++;
        }
    }

    public void firstinsert(int data) { // insert at first place in linkedlist
        Node node = new Node(data);
        if (head == null) { // this means linkedlist is empty
            head = node; // so we put node in head
            return;
        }

        node.next = head; // if linkedlist is not empty, then we put head's value in node's next
        head = node; // and node in head's place
    }

    public void specificinsert(int data, int index) {

        if (index > size || index < 0) { // here we check, the index should be in between 0 to size otherwise its show
                                         // error
            System.out.println("Invalid Index");
            return;
        }

        if (index == 0) { // if index =0, which means we want to insert at starting
            firstinsert(data);
            return;
        }

        if (index == size) {// this means we wants to insert at last, that's why we taking size
            lastinsert(data);
            return;
        }

        Node temp = head; // for specic first we made a temp variable becoz we cannot move the head
        for (int i = 1; i < index; i++) {// traversing until inputed index
            temp = temp.next;
        }

        Node node = new Node(data, temp.next); // now make a new node and pass data and in next we pass temp.next
        temp.next = node;// and then we placed node in temp.next's place
    }

    public void lastinsert(int data) { // insert at last
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }

        Node currNode = head;// if linkedlist is not empty, then we make a variable which is copy of
                             // head(becoz we cannot change the head)
        while (currNode.next != null) {
            currNode = currNode.next; // we traverse the linkedlist to the end until we find null
        }
        currNode.next = node; // and then we put node in currnode's next
    }

    public void firstdelete() { // delete first node
        if (head == null) {
            System.out.println("Linkedlist is empty");
            return;
        }
        size--;
        head = head.next; // we just put head's neaxt in head
    }

    public void specificdelete(int index) {

        if (index > size || index < 0) {// here we check, the index should be in between 0 to size otherwise its show
                                        // error
            System.out.println("Invalid index");
            return;
        }

        if (index == size) { // if index == size then we just delete the last node
            lastdelete();
            return;
        }

        if (index == 0) { // here we delete the first node or 0th index
            firstdelete();
            return;
        }
        size--;
        Node temp = head; // for specic first we made a temp variable becoz we cannot move the head
        for (int i = 1; i < index; i++) {// traversing until index
            temp = temp.next;
        }
        temp.next = temp.next.next; // we put temp's next next into temp's next so the middle one will remove
    }

    public void lastdelete() {
        if (head == null) {
            System.out.println("Linkedlist is empty");
            return;
        }
        size--;
        if (head.next == null) { // if we have only one node then we just simply pass null into node
            head = null;
            return;
        }

        Node currNode = head;
        while (currNode.next.next != null) { // we traverse until the we found null and we want second last node that
                                             // why we use next.next so we delete next node from the second hand node
            currNode = currNode.next;
        }

        currNode.next = null; // we asign next null from the second hand node
    }

    public void prints() { // prints the linkedlist
        if (head == null) {
            System.out.println("Empty LinkedList");
            return;
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "=>");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public void getsize() {
        System.out.println(size); // to get the size of the linkedlist
        return;
    }

    public static void main(String[] args) {
        LL a = new LL();
        a.firstinsert(12);
        a.firstinsert(14);
        a.firstinsert(17);
        a.lastinsert(56);
        a.lastinsert(89);
        a.lastinsert(5);
        a.prints();
        a.firstdelete();
        a.prints();
        a.lastdelete();
        a.prints();
        a.getsize();
        a.specificinsert(45, a.size);
        a.prints();
        a.getsize();
        a.specificdelete(30);
        a.prints();
        a.getsize();
    }
}