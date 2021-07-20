package com.dsalgo.trees;

public class BinarySearchTree {

    Node first = null, middle = null, last = null,  prev = null;
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Node root = new Node(6);
        root.left = new Node(10);
        root.right = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.right = new Node(12);
        root.right.left = new Node(7);
        binarySearchTree.printInorder(root);
        binarySearchTree.correctBST(root);
        System.out.println();
        binarySearchTree.printInorder(root);
    }

    private void correctBST(Node root) {
        findIncorrectElements(root);

        if(first != null && last != null) {
            int temp = first.data;
            first.data = last.data;
            last.data = temp;
        } else if(first != null && middle != null) {
            int temp = first.data;
            first.data = middle.data;
            middle.data = temp;
        }
    }

    private void findIncorrectElements(Node root) {
        if(root != null) {
            findIncorrectElements(root.left);

            if(prev != null && root.data < prev.data) {
                if(first == null) {
                    first = prev;
                    middle = root;
                } else {
                    last = root;
                }
            }
            prev = root;

            findIncorrectElements(root.right);
        }
    }

    private void printInorder(Node root) {
        if(root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(" " + root.data + " ");
        printInorder(root.right);
    }


}

class Node {
    int data;
    Node left, right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}