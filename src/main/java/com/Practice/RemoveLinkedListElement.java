package com.Practice;

public class RemoveLinkedListElement {

    public class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void display() {
        int pos = -1;
        int[] list1 = {1, 1};
        ListNode head = createCycledLinkedList(list1, pos);
        head = removeElements(head, 1);
        ListNode tempNode = head;
        while (tempNode != null) {
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode(val + 1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        ListNode current = head;

        while (current != null) {
            if (current.value == val) {
                prev.next = current.next;
                break;
            } else {
                prev = current;
            }
            current = current.next;
        }
        return dummyNode.next;
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
