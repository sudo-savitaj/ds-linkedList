package com.Practice;

public class MergeTwoList {
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
        int[] list1 = {1,2,4};
        ListNode head1 = createCycledLinkedList(list1, pos);
        int[] list2 = {1,3,4};
        ListNode head2 = createCycledLinkedList(list2, pos);

        ListNode head3 = mergeTwoLists(head1,head2);

        ListNode tempNode = head3;
        while (tempNode != null){
            System.out.println(tempNode.value);
            tempNode = tempNode.next;
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode head= null;
        while (l1!= null && l2 != null){
            int temp;
            if(l1.value < l2.value){
                temp = l1.value;
                l1 = l1.next;
            } else {
                temp = l2.value;
                l2 = l2.next;
            }
                ListNode tempNode = new ListNode(temp);
                if(l3 == null){
                    l3 = tempNode;
                    head = l3;
                } else {
                    l3.next = tempNode;
                    l3= l3.next;
                }
        }

        ListNode remainingList = l1 != null ? l1 : l2;
        if(l3 != null){
            l3.next = remainingList;
        } else {
            l3 = remainingList;
            if (head == null){
                head = l3;
            }
        }
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
