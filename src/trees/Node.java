package trees;

public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value){
        this.value = value;
    }

    public static void printTreeInOrderDFS(Node n){
        if(n != null){
            printTreeInOrderDFS(n.left);
            System.out.println(n.value);
            printTreeInOrderDFS(n.right);
        }
    }

    public static void printTreePreOrderDFS(Node n){
        if(n != null){
            System.out.println(n.value);
            printTreeInOrderDFS(n.left);
            printTreeInOrderDFS(n.right);
        }
    }

    public static void printTreePostOrderDFS(Node n){
        if(n != null){
            printTreeInOrderDFS(n.left);
            printTreeInOrderDFS(n.right);
            System.out.println(n.value);
        }
    }

}
