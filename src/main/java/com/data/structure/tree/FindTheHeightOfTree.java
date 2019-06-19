package com.data.structure.tree;

import java.util.ArrayDeque;
import java.util.Scanner;

public class FindTheHeightOfTree {

    public static int fillStack(Node root){

        int size = CalculateSizeOfTree.calculateSize(root);
        ArrayDeque<Node> stack = new ArrayDeque<>(size);

        int height = 0;
        stack.addFirst(root);

        while(!stack.isEmpty()){
            int counter = 0;
            int lastSize = stack.size();
            while(counter<lastSize){
                root = stack.pop();
                if(root.right!=null){
                    stack.addLast(root.right);
                }
                if(root.left!=null){
                    stack.addLast(root.left);
                }

                counter++;
            }
            height++;
        }

        return height-1;
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
        System.out.println(fillStack(root));
    }
}
