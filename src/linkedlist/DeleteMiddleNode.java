package linkedlist;
import java.util.ArrayList;
import java.util.List;
import static linkedlist.RemoveDups.printLinkedList;

public class DeleteMiddleNode {
    // Implement an algorithm to delete a node in the middle of a linked list--
    // we are only given access to the middle of the list, not the head
    public static void main(String[] args) {
        LinkedListExample1 linkedList = new LinkedListExample1();
        List<LinkedList.Node> middleElement = getMiddleOfLinkedList(linkedList);
        // get the middle node (for this example we will just take first of n1 list)
        LinkedList.Node node = middleElement.get(0);
        while (node.next != null) {
            node.data = node.next.data;
            node = node.next;
        }
        printLinkedList(linkedList);
    }

    private static List<LinkedList.Node> getMiddleOfLinkedList(LinkedListExample1 linkedList) {
        // Here we are solving the problem of how to get the middle of a linked list with only one iteration
        // solution is to have two iterators, second goes through the list at half the speed of the first
        // when the first hits null we know the second is at the middle (or one of the middle nodes depending on if
        //   there is an even or odd total number of nodes)
        int counter = 1;
        LinkedList.Node n1 = linkedList.getHead();
        LinkedList.Node n2 = linkedList.getHead();
        while (n1.next != null) {
            n1 = n1.next;
            if (counter % 2 == 0) {
                n2 = n2.next;
            }
            counter++;
        }
        // if counter is even, then we need to return n2 and n2.next
        List<LinkedList.Node> returnArray = new ArrayList<LinkedList.Node>();
        returnArray.add(n2);
        if (counter % 2 == 0) {
            returnArray.add(n2.next);
        }
        return returnArray;
    }
}
