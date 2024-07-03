class Node{
    int data;
    Node left,right;
    public Node(int item){
        data = item;
        left=right=null;
    }
}

public class LengthOfBinarySearch {
    Node root;
    int size(){
        return size(root);
    }
    int size(Node node){
        if(node==null){
            return 0;
        }else{
            return (size(node.left)+1+size(node.right));
        }
    }
    public static void main(String args[]){
        LengthOfBinarySearch tree = new LengthOfBinarySearch();
        tree.root = new Node(0);
        tree.root.left = new Node(1);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(6);
        System.out.println("Length of the tree "+tree.size());
    }
}
