package linkedlist;
import java.util.HashMap;


public class RemoveDups {
    public static void main(String[] args) {
        LinkedListExample1 linkedList = new LinkedListExample1();
        LinkedList.Node node = linkedList.getHead();
        LinkedList.Node laggingNode = null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    while (node != null) {
	        System.out.println(node.data);
	        if (map.containsKey(node.data)) {
                laggingNode.next = node.next;
            }
	        else {
                map.put(node.data, node.data);
                laggingNode = node;
            }
            node = node.next;
        }

	    // print linked list for confirmation
        node = linkedList.getHead();
	    System.out.println("Printing linkedList without duplicates!");
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }


    }

}
