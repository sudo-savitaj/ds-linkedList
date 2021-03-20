package com.Practice;

public class OddEvenLinkedList {
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
        int[] list1 = {1, 2, 3, 4, 5};
        ListNode head = createCycledLinkedList(list1, pos);

        head = oddEvenList(head);

        ListNode tempNode = head;
        while (tempNode != null){
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }
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

    // 1 > 2 > 3 > 4 > 5 > 6
    // 2 > 4 > 6
    // 1 > 3 > 5
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }
}
