package com.dsalgo.trees;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinaryTreeNode {
    public BinaryTreeNode(Integer data) {
        this.data = data;
    }
    private Integer data;
    private BinaryTreeNode left, right;
}
