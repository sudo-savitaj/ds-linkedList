package com.Practice;

public class PalindromeLinkedList {
    public class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }
    ListNode left;

    public void display() {
        int pos = -1;
        int[] list1 = {1, 2, 3,2, 1};
        ListNode head = createCycledLinkedList(list1, pos);

        System.out.println(isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        left = head;
        return isPalindromeUtil(slow);
    }

    private boolean isPalindromeUtil(ListNode right) {
        if(right == null)
            return true;
        boolean isPalindrome =  isPalindromeUtil(right.next);
        if (!isPalindrome){
            return false;
        }

        boolean isPalin = right.value == left.value;
        left = left.next;
        return isPalin;
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
