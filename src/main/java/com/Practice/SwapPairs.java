//https://practice.geeksforgeeks.org/problems/pairwise-swap-elements-of-a-linked-list-by-swapping-data/1/?problemType=functional&page=1&company[]=Amazon&category[]=Linked%20List&query=problemTypefunctionalpage1company[]Amazoncategory[]Linked%20List
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
