//https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1/?problemType=functional&page=2&company[]=Amazon&category[]=Linked%20List&query=problemTypefunctionalpage2company[]Amazoncategory[]Linked%20List
package com.Practice;

import org.w3c.dom.Node;

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

        head = rotateRightRecent(head, 4);

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

    public ListNode rotateRightRecent(ListNode head, int k) {
        ListNode last = head;
        while(last.next!= null) last = last.next;
        int i=0;
        while (i<k){
            last.next= head;
            head = head.next;
            last.next.next= null;
            last= last.next;
            i++;
        }
        return head;
    }

//    / head. The function assumes that k is
//    // smaller than size of linked list.
//// It doesn't modify the list if
//// k is greater than or equal to size
//    void rotate(Node** head_ref, int k)
//    {
//        if (k == 0)
//            return;
//
//        // Let us understand the below
//        // code for example k = 4 and
//        // list = 10->20->30->40->50->60.
//        Node* current = *head_ref;
//
//        // current will either point to
//        // kth or NULL after this loop.
//        // current will point to node
//        // 40 in the above example
//        int count = 1;
//        while (count < k && current != NULL) {
//            current = current->next;
//            count++;
//        }
//
//        // If current is NULL, k is greater than
//        // or equal to count of nodes in linked list.
//        // Don't change the list in this case
//        if (current == NULL)
//            return;
//
//        // current points to kth node.
//        // Store it in a variable. kthNode
//        // points to node 40 in the above example
//        Node* kthNode = current;
//
//        // current will point to
//        // last node after this loop
//        // current will point to
//        // node 60 in the above example
//        while (current->next != NULL)
//            current = current->next;
//
//        // Change next of last node to previous head
//        // Next of 60 is now changed to node 10
//        current->next = *head_ref;
//
//        // Change head to (k+1)th node
//        // head is now changed to node 50
//    *head_ref = kthNode->next;
//
//        // change next of kth node to NULL
//        // next of 40 is now NULL
//        kthNode->next = NULL;
//    }

}
