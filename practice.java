package Linkedl;

public class practice {
    Node head;
    private int size;

    practice(){
        this.size = 0;
    }

    class Node{  //node creation
        int data; // data which we want in the list
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
            size++; 
        }
    }

    public void firstinsert(int data){  // insert at first place in linkedlist
        Node node = new Node(data);
        if (head==null) {  //this means linkedlist is empty 
            head = node; //so we put node in head
            return;
        }

        node.next = head; //if linkedlist is not empty, then we put head's value in node's next
        head = node; // and node in head's place
    }

    public void lastinsert(int data){ // insert at last
        Node node = new Node(data);
        if (head==null) {
            head = node;
            return;
        }

        Node currNode = head;// if linkedlist is not empty, then we make a variable which is copy of head(becoz we cannot change the head)
        while (currNode.next!=null) {  
            currNode = currNode.next; // we traverse the linkedlist to the end until we find null
        }
        currNode.next = node; // and then we put node in currnode's next
    }


    public void firstdelete(){ // delete first node
        if (head == null) {
            System.out.println("Linkedlist is empty");
            return;
        }
        size--;
        head = head.next; //we just put head's neaxt in head
    }

    public void lastdelete(){
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
        while (currNode.next.next!=null) { // we traverse until the we found null and we want second last node that why we use next.next so we delete next node from the second hand node
            currNode = currNode.next;
        }

        currNode.next = null; // we asign next null from the second hand node
    }


    public void prints(){  // prints the linkedlist
        if (head == null) {
            System.out.println("Empty LinkedList");
            return;
        }
        Node currNode = head;
        while (currNode!=null) {
            System.out.print(currNode.data + "=>");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public void getsize(){
        System.out.println(size); // to get the size of the linkedlist
        return;
    }

    public static void main(String[] args) {
        practice a = new practice();
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
        
    }
}