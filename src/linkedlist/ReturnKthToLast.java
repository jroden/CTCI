package linkedlist;

public class ReturnKthToLast {
    // this problem asks us to return the data at node k from the end of a singly linked list

    public static void main(String[] args){
        // iterate through linked list with two pointers, one is k elements behind the other
        // when the first one hits null, we know the second is the kth to last element
        LinkedListExample1 linkedList = new LinkedListExample1();
        LinkedList.Node n1 = linkedList.getHead();
        LinkedList.Node n2 = linkedList.getHead();
        int k = 8, counter = 0;
        while (n1.next != null) {
            if (counter >= k) {
                n2 = n2.next;
            }
            n1 = n1.next;
            counter++;
        }
        System.out.println("Data at node " + k + "'th to end is: " + n2.data);
    }
}
