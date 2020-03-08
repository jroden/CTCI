package trees;

import linkedlist.LinkedList;

import java.util.ArrayList;
import java.util.Queue;

import static trees.MinimalTree.createMinimalTree;
import static trees.Node.breadthFirstSearch;

public class ListOfDepths {
    // Problem: Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
    // Solution: breadth first search with counter, add the LinkedList.Node equivalent of the current node to the
    //  corresponding depth LinkedList depending on the counter value
    // Time Complexity: O(n) since we are only looping through the tree once
    // Space Complexity: O(n) since the linked lists size is linearly related to the input tree

    public static void main(String[] args){
        // first, create the tree from an input array using a previous problem
        int[] inputArray = {1,2,3,4,5,6,7,8,9};
        Node n = createMinimalTree(inputArray, 0, inputArray.length - 1);
        ArrayList<LinkedList> linkedListArray = createLinkedListsFromTree(n);
        // print results for visual verification
        System.out.println("BFS results of input");
        breadthFirstSearch(n);
        System.out.println("Print output results");
        for(int depth = 0; depth < linkedListArray.size(); depth++){
            LinkedList linkedList = linkedListArray.get(depth);
            LinkedList.Node node = linkedList.head;
            System.out.println("Depth layer: "  + depth);
            while(node != null){
                System.out.println(node.data);
                node = node.next;
            }
        }
    }

    public static ArrayList<LinkedList> createLinkedListsFromTree(Node n) {
        ArrayList<LinkedList> linkedListArray = new ArrayList<>();
        LinkedList linkedList = new LinkedList();
        Queue<Node> bfsQueue = new java.util.LinkedList<>();
        bfsQueue.add(n);
        int counter = 1, currentDepth = 0;
        LinkedList.Node previousNode = null, currentLinkedListNode;
        while (!bfsQueue.isEmpty()) {
            Node currentNode = bfsQueue.remove();
            if (currentNode.left != null) { bfsQueue.add(currentNode.left); }
            if (currentNode.right != null) { bfsQueue.add(currentNode.right); }
            // if the counter is equal to 1 or a power of 2, we know that we have reached a new depth layer of the tree
            //  initialize new depth layer linkedList
            if(isPowerOfTwo(counter) || counter == 1){
                linkedList = new LinkedList();
                linkedListArray.add(linkedList);
                currentLinkedListNode = linkedList.new Node(currentNode.value);
                linkedList.head = currentLinkedListNode;
                currentDepth++;
            }
            // if we haven't reached new layer of the tree, append current node to last node and continue
            else {
                currentLinkedListNode = linkedList.new Node(currentNode.value);
                previousNode.next = currentLinkedListNode;
            }
            previousNode = currentLinkedListNode;
            counter++;
        }
        return linkedListArray;
    }


    static boolean isPowerOfTwo(int n)
    {
        if(n==0)
            return false;
        return (int)(Math.ceil((Math.log(n) / Math.log(2)))) ==
                (int)(Math.floor(((Math.log(n) / Math.log(2)))));
    }
}
