package com.data.structure.tree;

import java.util.Scanner;
import java.util.Stack;

public class MaximumElemTree {

    public static int maxInt(Node root){

        if (root.left == null && root.right == null) return root.data;

    int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
        if (root.left != null) {
        left = Math.max(maxInt(root.left), root.data);
    }
        if (root.right != null) {
        right = Math.max(maxInt(root.right), root.data);
    }
        return Math.max(Math.max(right, left), root.data);
}

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        System.out.println(maxInt(root));
    }
}

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}