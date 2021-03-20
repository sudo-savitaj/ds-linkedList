package com.Practice;

public class DoublyLinkedList {

    class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    ListNode head = null;


    public void display() {

//        addAtHead(1);
//        addAtHead(25);
//        addAtTail(6);
//        addAtHead(50);
//        addAtTail(2);
//        addAtIndex(5,125);
//        deleteAtIndex(3);
//
//        printList();




        String[] operations = {"addAtHead", "addAtTail", "addAtTail", "addAtTail", "addAtTail", "addAtTail", "addAtTail", "deleteAtIndex", "addAtHead", "addAtHead", "get",
                "addAtTail", "addAtHead", "get", "addAtTail", "addAtIndex", "addAtTail", "addAtHead", "addAtHead", "addAtHead", "get", "addAtIndex", "addAtHead", "get",
                "addAtHead", "deleteAtIndex", "addAtHead", "addAtTail", "addAtTail", "addAtIndex", "addAtTail", "addAtHead", "get", "addAtTail", "deleteAtIndex", "addAtIndex",
                "deleteAtIndex", "addAtHead", "addAtTail", "addAtHead", "addAtHead", "addAtTail", "addAtTail", "get", "get", "addAtHead", "addAtTail", "addAtTail", "addAtTail",
                "addAtIndex", "get", "addAtHead", "addAtIndex", "addAtHead", "addAtTail", "addAtTail", "addAtIndex", "deleteAtIndex", "addAtIndex", "addAtHead", "addAtHead",
                "deleteAtIndex", "addAtTail", "deleteAtIndex", "addAtIndex", "addAtTail", "addAtHead", "get", "addAtIndex", "addAtTail", "addAtHead", "addAtHead", "addAtHead",
                "addAtHead", "addAtHead", "addAtHead", "deleteAtIndex", "get", "get", "addAtHead", "get", "addAtTail", "addAtTail", "addAtIndex", "addAtIndex", "addAtHead", "addAtTail",
                "addAtTail", "get", "addAtIndex", "addAtHead", "deleteAtIndex", "addAtTail", "get", "addAtHead", "get", "addAtHead", "deleteAtIndex", "get", "addAtTail", "addAtTail"};

        int[][] values = {{38}, {66}, {61}, {76}, {26}, {37}, {8}, {5}, {4}, {45}, {4}, {85}, {37}, {5}, {93}, {10, 23}, {21}, {52}, {15}, {47}, {12}, {6, 24}, {64}, {4}, {31}, {6}, {40}, {17},
                {15}, {19, 2}, {11}, {86}, {17}, {55}, {15}, {14, 95}, {22}, {66}, {95}, {8}, {47}, {23}, {39}, {30}, {27}, {0}, {99}, {45}, {4}, {9, 11}, {6}, {81}, {18, 32}, {20}, {13}, {42}, {37, 91},
                {36}, {10, 37}, {96}, {57}, {20}, {89}, {18}, {41, 5}, {23}, {75}, {7}, {25, 51}, {48}, {46}, {29}, {85}, {82}, {6}, {38}, {14}, {1}, {12}, {42}, {42}, {83}, {13}, {14, 20}, {17, 34}, {36},
                {58}, {2}, {38}, {33, 59}, {37}, {15}, {64}, {56}, {0}, {40}, {92}, {63}, {35}, {62}, {32}};

        System.out.println(values[0][0]);
        System.out.println(values[1][0]);
        System.out.println("Operations == Values");
        System.out.println(operations.length == values.length);
        System.out.println("--------------");
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "addAtTail":
                    addAtTail(values[i][0]);
                    break;
                case "deleteAtIndex":
//                    System.out.println("--------------delete : "+count() + " -   " + values[i][0]);
//                    System.out.println("***************before delete******************");
//                    printList();
//                    System.out.println("*****************************************");
                    deleteAtIndex(values[i][0]);
//                    System.out.println("*************after delete*************************");
//                    printList();
//                    System.out.println("*********************************");
                    break;
                case "addAtHead":
                    addAtHead(values[i][0]);
                    break;
                case "addAtIndex":
                    addAtIndex(values[i][0], values[i][1]);
                    break;
                case "get":
                    System.out.println(get(values[i][0]));
//                    if (get(values[i][0]) == 39) {
//                        System.out.println("--------------"+ values[i][0]);
//                        printList();
//                        System.out.println("--------------");
//                    }
                    break;
            }
        }
    }

    private void printList() {
        ListNode tempNode = head;
        while (tempNode != null) {
            System.out.println(tempNode.val);
            tempNode = tempNode.next;
        }
    }

    private int count() {
        ListNode tempNode = head;
        int count = 0;
        while (tempNode != null) {
            tempNode = tempNode.next;
            count++;
        }
        return count;
    }

    public int get(int index) {
        if (head == null) {
            return -1;
        }
        int i = 0;
        ListNode current = head;
        while (i < index && current.next != null) {
            current = current.next;
            i++;
        }
        if (i == index) {
            return current.val;
        }
        return -1;
    }

    public void addAtHead(int val) {

        ListNode node = new ListNode(val);
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        ListNode node = new ListNode(val);
        current.next = node;
        node.prev = current;

    }

    // 1 > 2 > 3
    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }

        int i = 0;
        ListNode current = head;
        while (i < index && current.next != null) {
            current = current.next;
            i++;
        }
        if (i == index) {
            ListNode node = new ListNode(val);
            current.prev.next = node;
            node.prev = current.prev;
            node.next = current;
            current.prev = node;
        } else if (i == index - 1) {
            ListNode node = new ListNode(val);
            current.next = node;
            node.prev = current;
        }
    }

    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        int i = 0;
        ListNode current = head;
        while (i < index && current.next != null) {
            current = current.next;
            i++;
        }
        if (i == index) {
            current.prev.next = current.next;
            if(current.next != null) {
                current.next.prev = current.prev;
            }
        }
    }
}


//[61,61,85,37,23,-1,95,31,8,6,47,23,93,48,93,59]
//[61,61,85,37,23,39,55,31,8,6,47,55,85,89,85,59]
