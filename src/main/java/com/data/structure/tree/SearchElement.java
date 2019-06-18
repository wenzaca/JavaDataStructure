package com.data.structure.tree;

import java.util.Scanner;

public class SearchElement {

    public static Boolean findElement(Node root, int desiredElem){

        if (root.data == desiredElem) return true;

        return root.left != null ? findElement(root.left, desiredElem) : false || root.right != null ? findElement(root.right, desiredElem) : false;
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
        System.out.print("\nType the desired element: ");
        int elem = scan.nextInt();
        scan.close();
        System.out.println(findElement(root, elem));
    }
}

