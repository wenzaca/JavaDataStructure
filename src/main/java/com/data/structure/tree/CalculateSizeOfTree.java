package com.data.structure.tree;

import java.util.Scanner;

public class CalculateSizeOfTree {

    public static int calculateSize(Node root){
        return calculateSize(root, 0) + 1;
    }

    public static int calculateSize(Node root, int size){

        if(root.left != null){
            size = calculateSize(root.left, size+1);
        }
        if(root.right != null){
            size = calculateSize(root.right, size+1);
        }
        return size;
    }


    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
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
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        System.out.println(calculateSize(root));
    }
}
