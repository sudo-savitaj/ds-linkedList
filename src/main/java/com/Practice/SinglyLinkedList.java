package com.Practice;

import org.w3c.dom.Node;

public class SinglyLinkedList {
    Node head;
    public class Node {
        int value;
        Node next;

        Node(int value){
            this.value = value;
        }
    }

//["MyLinkedList","addAtHead","addAtIndex","addAtTail","addAtHead","addAtIndex","addAtTail","addAtTail","addAtIndex","deleteAtIndex","deleteAtIndex","addAtTail"]
//[[],[0],[1,4],[8],[5],[4,3],[0],[5],[6,3],[7],[5],[4]]

    public void display() {
        System.out.println("---------------------------");
        SinglyLinkedList myLinkedList = new SinglyLinkedList();
        myLinkedList.addAtHead(0);
        myLinkedList.addAtIndex(1,4);
        myLinkedList.addAtTail(8);
        myLinkedList.addAtHead(5);
        myLinkedList.addAtIndex(4,3);
        myLinkedList.addAtTail(0);
        myLinkedList.addAtTail(5);
        myLinkedList.addAtIndex(6,3);
        myLinkedList.deleteAtIndex(7);
        myLinkedList.deleteAtIndex(5);
        myLinkedList.addAtTail(4);
        System.out.println(myLinkedList.get(0));

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (isHeadPresent()) {
            int i = 0;
            Node iNode = head;
            for (; iNode.next != null && i < index ; iNode = iNode.next, i++) ;
            if (i == index ) {
                return iNode.value;
            }
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
       head = node;
    }

    private boolean isHeadPresent() {
        return head != null;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (isHeadPresent()) {
            Node iNode = head;
            for (; iNode.next != null; iNode = iNode.next) ;
            iNode.next = new Node(val);
        } else {
            head = new Node(val);
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if(index == 0){
            addAtHead(val);
            return;
        }
        if (isHeadPresent()) {

            Node prev = head;
            int i = 0;
            for (Node iNode = head; iNode.next != null && i < index ; prev = iNode, iNode = iNode.next, i++) ;
            if (i == index || i+ 1 == index) {
                Node node = new Node(val);
                node.next = prev.next;
                prev.next= node;

            }
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (isHeadPresent()) {

            Node prev = null;
            int i = 0;
            Node iNode = head;
            for (; iNode.next != null && i < index ; prev = iNode, iNode = iNode.next, i++) ;
            if (i == index ) {
                if (prev == null){
                    head = head.next;
                } else {
                    prev.next =  iNode.next;
                }
            }
        }
    }

    public void printAll(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

}


