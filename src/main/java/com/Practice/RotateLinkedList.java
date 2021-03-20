package com.Practice;

public class RotateLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int value) {
            this.val = value;
            this.next = null;
        }
    }
    public void display() {
        int pos = -1;
        int[] list1 = {0,1,2};
        ListNode head = createCycledLinkedList(list1, pos);

        head = rotateRight(head, 4);

        ListNode tempNode = head;
        while (tempNode != null){
            System.out.println(tempNode.val);
            tempNode = tempNode.next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null|| k == 0){
            return head;
        }
        ListNode first = head;
        ListNode second = head;
        while(k != 0){
            second = second.next;
            if (second == null){
                second = head;
            }
            k--;
        }
        while (second.next != null){
            first = first.next;
            second = second.next;
        }

        second.next = head;
        head = first.next;
        first.next = null;
        return head;
    }

    private ListNode createCycledLinkedList(int[] list, int pos) {
        ListNode head = null;
        ListNode posNode = null;
        ListNode prevNode = null;
        for (int i = 0; i < list.length; i++) {
            ListNode node = new ListNode(list[i]);
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
