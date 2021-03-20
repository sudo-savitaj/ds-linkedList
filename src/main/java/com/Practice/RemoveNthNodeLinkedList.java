package com.Practice;

public class RemoveNthNodeLinkedList {
    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void display() {
        int[] list = {1,2};
        Node head = createCycledLinkedList(list, -1);
        head= removeNthFromEnd(head,2);

        Node tempNode = head;
        while(tempNode != null){
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }
    }

    public Node removeNthFromEnd(Node head, int n) {
        if(head == null){
            return null;
        }

        Node dummyNode = new Node(10);
        dummyNode.next = head;
        Node p = dummyNode;
        Node q = dummyNode;

        int i = 0;
        while(i <= n && q != null){
            q= q.next;
            i++;
        }

        while(q!= null){
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;

       return dummyNode.next;
    }

    private Node createCycledLinkedList(int[] list, int pos) {
        Node head = null;
        Node posNode = null;
        Node prevNode = null;
        for (int i = 0; i < list.length; i++) {
            Node node = new Node(list[i]);
            if (head == null) {
                head = node;
            } else {
                prevNode.next = node;
            }
            prevNode = node;
            if (i == pos) {
                posNode = node;
            }
        }
        if (pos != -1) {
            prevNode.next = posNode;
        }
        return head;
    }

}
