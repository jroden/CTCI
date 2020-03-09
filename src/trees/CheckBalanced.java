package trees;

import linkedlist.LinkedList;

import java.util.ArrayList;
import java.util.Queue;

import static trees.MinimalTree.createMinimalTree;
import static trees.Node.breadthFirstSearch;

public class CheckBalanced {
    // Problem: Implement a function to check if a binary tree is balanced.  For this question a balanced tree is a tree
    //  where the heights of the twi subtrees of any node never differ by more than one
    // Solution: For a perfect binary tree know that each layer of the tree should have 2*n the number of elements in the previous layer
    //  thus we can determine, if we encounter a layer with less than 2*n elements, there may only be one additional layer- else(fail)
    // Time Complexity: O(n) because we are doing a breadth-first search
    // Space Complexity: O(n) because we are only storing the input tree


    public static void main(String[] args){
        int[] inputArray = {1,2,3,4,5,6,7,8,9};
        Node n = createMinimalTree(inputArray, 0, inputArray.length - 1);
        // test with balanced tree
        System.out.println(isTreeBalanced(n));
        // test with rudimentary unbalanced tree
        n = new Node(3);
        n.left = new Node(3);
        n.left.left = new Node(3);
        System.out.println(isTreeBalanced(n));
    }

    public static boolean isTreeBalanced(Node n){
        boolean imbalanceEncountered = false;
        Queue<Node> currentQueue = new java.util.LinkedList<>();
        currentQueue.add(n);
        while (currentQueue.size() > 0) {
            Queue<Node> nextQueue = new java.util.LinkedList<>();
            for(Node currentNode: currentQueue) {
                if (currentNode.left != null) { nextQueue.add(currentNode.left); }
                if (currentNode.right != null) { nextQueue.add(currentNode.right); }
            }
            // if the length of the next layer is greater than zero, but not equal to 2*n where n is the number of nodes at the previous layer,
            //  we know that there is an imbalance.  Fail if there has been a previous imbalance
            if(nextQueue.size() != currentQueue.size()*2 && nextQueue.size() > 0){
                if(imbalanceEncountered){ return false; }
                imbalanceEncountered = true;
            }
            currentQueue = nextQueue;
        }
        return true;
    }
}
