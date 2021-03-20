package com.Practice;

public class DeleteDuplicateNode {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public void display() {
        int pos = -1;
        int[] list1 = {1,1};
        ListNode head = createCycledLinkedList(list1, pos);

        head = deleteDuplicates(head);

        ListNode tempNode = head;
        while (tempNode != null){
            System.out.println(tempNode.val);
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null && current.next != null){
            if(current.val == current.next.val) {
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                if(prev == null){
                    head = current.next;
                } else {
                    prev.next = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}
