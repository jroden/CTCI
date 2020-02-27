package linkedlist;

import com.sun.tools.javac.util.ArrayUtils;

import static linkedlist.LinkedList.convertArrayToLinkedList;
import static linkedlist.LinkedList.printLinkedList;

public class SumLists {
    // Problem:
    // Solution: Iterate through linked list with two pointers, one is k elements behind the other
    //  when the first one hits null, we know the second is the kth to last element
    // Time Complexity: O(n) since we are only looping through the list once
    // Space Complexity: O(n) since we are only storing the input linkedList

    public static void main(String[] args) {
        LinkedList linkedListOne = convertArrayToLinkedList(new int[]{3, 4, 2});
        LinkedList linkedListTwo = convertArrayToLinkedList(new int[]{8, 2, 9, 8, 3, 4});
        printLinkedList(sumTheListsInReverseOrder(linkedListOne, linkedListTwo));
    }

    private static LinkedList sumTheListsInReverseOrder(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList.Node LL1Node = linkedListOne.head;
        LinkedList.Node LL2Node = linkedListTwo.head;
        LinkedList sumLinkedList = new LinkedList();
        int sum, carry = 0;
        LinkedList.Node lagNode = null;
        while (true) {
            // calculate sum
            if (LL1Node == null) { sum = LL2Node.data + carry; }
            else if (LL2Node == null) { sum = LL1Node.data + carry; }
            else { sum = LL1Node.data + LL2Node.data + carry; }
            // calculate carry
            carry = (int) Math.floor(sum / 10);
            // assign sum to new node in return linked list
            LinkedList.Node node = sumLinkedList.new Node(sum);
            if (lagNode != null) { lagNode.next = node; }
            else { sumLinkedList.head = node; }
            lagNode = node;
            // increment nodes
            if (LL1Node != null) { LL1Node = LL1Node.next; }
            if (LL2Node != null) { LL2Node = LL2Node.next; }
            // break if at the end of both nodes
            if (LL1Node == null && LL2Node == null) { break; }
        }
        return sumLinkedList;
    }

    private static LinkedList sumTheListsInStandardOrder(LinkedList linkedListOne, LinkedList linkedListTwo) {
        // extract linked lists into arrays in reverse order
        LinkedList.Node LL1Node = linkedListOne.head;
        int[] LL1Array = {};
        while (true) {
            LL1Array = new ArrayUtils.add(LL1Array, 0, LL1Node.data);
        }
        LinkedList.Node LL2Node = linkedListTwo.head;
        LinkedList sumLinkedList = new LinkedList();

        return sumLinkedList;
    }
}
