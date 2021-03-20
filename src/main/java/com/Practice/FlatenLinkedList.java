//https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1/?problemType=functional&page=2&company[]=Amazon&category[]=Linked%20List&query=problemTypefunctionalpage2company[]Amazoncategory[]Linked%20List
package com.Practice;

public class FlatenLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public void display() {
    }

    public Node flatten(Node head) {
        Node current = head;
        while (current != null){
            if (current.child != null){
                Node child =current.child;
                while (child.next != null){
                    child = child.next;
                }
                if (current.next != null) {
                    child.next = current.next;
                    current.next.prev = child;
                }
                current.next = current.child;
                current.next.prev = current;
                current.child = null;
            }
            current = current.next;
        }
        return head;
    }
}
