package org.Stack;

public class Node {
    String item;
    Node next=null;
    public Node (String item){
        this.item=item;
        this.next=null;
    }
    public Node (String item, Node next){
        this.item=item;
        this.next=next;
    }
}
