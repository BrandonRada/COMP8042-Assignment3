package com.trees;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import com.trees.TreeNodes.GenericTreeNode;

public class BSTChecker{
    boolean isBinarySearchTree(GenericTree<Integer> tree){
        return isBST(tree.getRoot(), null, null);
    }

    // Helper function that recursively checks each node and their children until it is finished.
    private boolean isBST(GenericTreeNode<Integer> node, Integer min, Integer max) {
        if (node == null) return true;
        if (min != null && node.getValue().compareTo(min) <= 0) return false;
        if (max != null && node.getValue().compareTo(max) >= 0) return false;
        if (node.getChildren().size() > 2) return false;
        boolean left = true;
        if (node.getChildren().size() >= 1) {
            left = isBST(node.getChildren().get(0), min, node.getValue());
        }
        boolean right = true;
        if (node.getChildren().size() >= 2) {
            right = isBST(node.getChildren().get(1), node.getValue(), max);
        }
        return left && right;
    }


    // Helper main function to read the files, and format them, then calls the BSTChecker
    public static void main(String[] args){
        if (args.length == 0){
            System.out.println("Usage: <file_name>");
            return;
        }

        DotFileReader dotReader = new DotFileReader();

        for (String file : args) {
            try {
                GenericTree<Integer> tree = dotReader.createTreeFromDotFile(file, Integer::valueOf);
                BSTChecker checker = new BSTChecker();
                boolean isBinarySearchTreeCorrect = checker.isBinarySearchTree(tree);
                if (isBinarySearchTreeCorrect){
                    System.out.println(file + ": The tree contained in the file is a Binary Search Tree!");
                } else {
                    System.out.println(file + ": The tree contained in the file is NOT a Binary Search Tree!");
                }
            } catch (IOException e) {
                System.out.println("Error reading file " + file + ": " + e.getMessage());
            }
        }
    }
}