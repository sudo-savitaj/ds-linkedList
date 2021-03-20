package com.Practice;

import org.w3c.dom.Node;

public class CycleInLinkedList {
    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    Node head;

    public void display() {
        int[] list = {3,2,0,-4};
        int pos = 1;
        createCycledLinkedList(list, pos);

//        int counter = 0;
//        Node tempNode = head;
//        while (tempNode != null) {
//            if (tempNode.value == 2) {
//                counter++;
//            }
//            System.out.println(tempNode.value);
//            tempNode = tempNode.next;
//        }

        System.out.println(hasCycle(head));
        System.out.println(detectCycle(head).value);
    }

    private void createCycledLinkedList(int[] list, int pos) {
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

    }

    boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }


        return false;
    }

    public Node detectCycle(Node head) {
        Node meetingNode = getMeetingNode(head);
        if(meetingNode == null)
            return meetingNode;

        Node p = head;
        Node q = meetingNode;
        while(p != q){
            p = p.next;
            q = q.next;
        }
        return p;
    }

    private Node getMeetingNode(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        Node q = head;

        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q) {
                return p;
            }
        }

        return null;
    }

    private boolean isHeadPresent() {
        return head != null;
    }
}

//        -1