package org.Stack;

public class LinkedStackofStrings {
    private Node first =null;

    public LinkedStackofStrings(String item, Node next){
        this.first=new Node(item,next);
    }
    public boolean isEmpty(){
        return first==null;
    }
    public void push(String item){
        Node old = first;
        first = new Node(item, old);
    }

    public String pop(){
        String item=first.item;
        first=first.next;
        return item;
    }
}
