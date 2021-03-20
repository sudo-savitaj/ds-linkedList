package com.Practice;

public class IntersectionInLinkedList {
    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void display() {
        int pos = -1;

        int[] list1 = {4, 1, 8, 4, 5};
        Node head1 = createCycledLinkedList(list1, pos);

        int[] list2 = {5, 6, 1, 8, 4, 5};
        Node head2 = createCycledLinkedList(list2, pos);

        Node intersectionNode = getIntersectionNode(head1, head2);
        System.out.println(intersectionNode.value);

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

    public Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null){
            return null;
        }
        Node tempA = headA;
        Node tempB = headB;
        while (tempA != tempB){
            tempA = tempA.next;
            tempB = tempB.next;
            if(tempA == tempB){
                return tempA;
            }
            if(tempA== null){
                tempA = headB;
            }
            if (tempB == null){
                tempB = headA;
            }
        }
        return tempA;
    }
}
