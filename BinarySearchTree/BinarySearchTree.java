package BinarySearchTree;

public class BinarySearchTree<T> {
    public T data;
    public BinarySearchTree<T> left;
    public BinarySearchTree<T> right;

    public BinarySearchTree(T data){
        this.data = data;
    }

    public static void printTree(BinarySearchTree<Integer > bst){
        if(bst == null)
            return;
        System.out.println(bst.data);
        printTree(bst.left);
        printTree(bst.right);
    }

}

