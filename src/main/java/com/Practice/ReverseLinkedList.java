package com.Practice;

public class ReverseLinkedList {
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
        int[] list1 = {4, 1, 8, 4, 5};
        ListNode head = createCycledLinkedList(list1, pos);

        head = reverseListWithRecursion(head);
        ListNode tempNode = head;
        while (tempNode != null){
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while(current!= null){
            ListNode currentNext = current.next;
            current.next = prev;
            prev = current;
            current = currentNext;
        }
        return prev;
    }
// 1 > 2 -> null
    public ListNode reverseListWithRecursion(ListNode head) {
       if (head == null || head.next == null)
           return head;

       ListNode newHead = reverseListWithRecursion(head.next);
        head.next.next = head;
        head.next = null;

       return newHead;
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
