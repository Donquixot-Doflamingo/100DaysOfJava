package Day70;

import java.util.Scanner;

import BinarySearchTree.BinarySearchTree;

public class Day70 {
    /* ******************************** Started learning about Binary Search Tree Part 1 ******************************** */

    // Binary Search Tree Basics

    public static void BinarySearchTreeUse(){
        // Used the BST handmade class

        // Implemented a static tree structure

        BinarySearchTree<Integer> root = new BinarySearchTree<Integer>(10);
        BinarySearchTree<Integer> rootLeft = new BinarySearchTree<Integer>(20);
        BinarySearchTree<Integer> rootRight = new BinarySearchTree<Integer>(30);
        
        root.left = rootLeft;
        root.right = rootRight;

        BinarySearchTree<Integer> rootLeftRight = new BinarySearchTree<Integer>(40);
        BinarySearchTree<Integer> rootRightLeft = new BinarySearchTree<Integer>(50);

        rootLeft.right = rootLeftRight;
        rootRight.left = rootRightLeft;

        printBinaryTree(root);
    }

    public static void printBinaryTree(BinarySearchTree<Integer > bst){
        // base case
        if(bst == null)
            return;

        // main function 

        System.out.print(bst.data + " : ");
        if(bst.left != null){
            System.out.print(" L "+bst.left.data + ", ");
        }
        if(bst.right != null){
            System.out.print(" R "+bst.right.data);
        }
        System.out.println();
        printBinaryTree(bst.left);
        printBinaryTree(bst.right);
    }

    public static BinarySearchTree<Integer> takeTreeInput(){
        System.out.println("Enter root data");
        Scanner s = new Scanner(System.in);
        int rootData = s.nextInt();

        // base case if user entered -1 to no continue filling tree
        if(rootData == -1){
            s.close();
            return null;
        }

        BinarySearchTree<Integer> root = new BinarySearchTree<Integer>(rootData);

        // making recusrsion to help us make the whole tree again
        BinarySearchTree<Integer> leftChild = takeTreeInput();
        BinarySearchTree<Integer> rightChild = takeTreeInput();

        // making connections
        root.left = leftChild;
        root.right = rightChild;
        s.close();
        return root;
    }
    
    public static void main(String[] args){
        int n = 3;
        int i = 1, j = 1, k =1;
        while(i<= n){
                while(j<= n-i){
                System.out.print(" ");
            }
            j=1;
            while(k<= 2*i-1){
                System.out.print("*");
            }}
            k=1;
            System.out.println();
            i = i + 1;    
        }
    }