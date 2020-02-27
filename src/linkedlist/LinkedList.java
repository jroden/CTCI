package linkedlist;

import java.lang.reflect.Array;

public class LinkedList {
    public Node head;

    public class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static LinkedList convertArrayToLinkedList(int[] arrayToBeConverted) {
        LinkedList returnLinkedList = new LinkedList();
        Node laggingNode = null;
        for (int i = 0; i < arrayToBeConverted.length; i++) {
            Node n1 = returnLinkedList.new Node(arrayToBeConverted[i]);
            if (laggingNode not null) {
                laggingNode.next = n1;
            }
            laggingNode = n1;
        }
        return
    }
}
