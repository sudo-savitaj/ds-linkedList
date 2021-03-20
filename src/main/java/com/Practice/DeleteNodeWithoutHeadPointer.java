package com.Practice;

public class DeleteNodeWithoutHeadPointer {
    class Node
    {
        int data ;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

   void deleteNode(Node del) {
        del.data = del.next.data;
        del.next = del.next.next;
    }
}
