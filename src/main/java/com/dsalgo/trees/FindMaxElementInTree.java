package com.dsalgo.trees;

public class FindMaxElementInTree {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(30);
        root.setLeft(new BinaryTreeNode(20));
        root.setRight(new BinaryTreeNode(40));
        root.getLeft().setLeft(new BinaryTreeNode(10));
        root.getLeft().setRight(new BinaryTreeNode(12));
        root.getRight().setLeft(new BinaryTreeNode(50));
        root.getRight().setRight(new BinaryTreeNode(28));

        System.out.println("Maximum element in tree : " + getMaximumElementInTree(root));
    }

    private static Integer getMaximumElementInTree(BinaryTreeNode root) {
        if (root == null)
            return null;
        if (root.getRight() == null && root.getLeft() == null) {
            return root.getData();
        }
        Integer maxInLeftTree = getMaximumElementInTree(root.getLeft());
        Integer maxInRightTree = getMaximumElementInTree(root.getRight());
        Integer maxElement = Math.max(maxInLeftTree, maxInRightTree);

        if (root.getData() > maxElement) {
            return root.getData();
        }
        return maxElement;
    }
}
