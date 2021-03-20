package com.Practice;

public class AddTwoList {
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
        int[] list1 = {2,4,3};
        ListNode head1 = createCycledLinkedList(list1, pos);
        int[] list2 = {5,6,4};
        ListNode head2 = createCycledLinkedList(list2, pos);

        ListNode head3 = addTwoNumbersNonReverse(head1,head2);

        ListNode tempNode = head3;
        while (tempNode != null){
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }

    }

    public ListNode addTwoNumbersNonReverse(ListNode l1, ListNode l2) {
        ListNode head = null;
        int carry =0;
        ListNode current = null;
        while (l1 != null || l2 != null){
            int l1Value = l1 != null ? l1.value : 0;
            int l2Value = l2 != null ? l2.value : 0;
            int sum = l1Value + l2Value + carry;
            ListNode node = new ListNode(sum%10) ;
            if(current == null){
                current = node;
                head = current;
            } else {
                current.next = node;
                current = current.next;
            }
            carry = sum / 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(carry > 0){
            current.next = new ListNode(carry);
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        addTwoNumbers(l1,l2,head);
        return head;
    }

    private int addTwoNumbers(ListNode l1, ListNode l2, ListNode node) {
        if(l1== null && l2 == null){
            return 0;
        }
        int value = (l1.value + l2.value) % 10;
        int rem = (l1.value + l2.value) / 10;
        ListNode temp = new ListNode(value) ;
        temp.value += addTwoNumbers(l1.next,l2.next,temp);
        if(node == null){
            node = temp;
        } else {
            node.next = temp;
        }
        return rem;
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
