package com.Practice;

public class SwapPairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
        return head;

        ListNode temp = head.next.next;
       head.next.next = head;
       head = head.next;
       head.next.next = swapPairs(temp);
        return head;
    }
}
