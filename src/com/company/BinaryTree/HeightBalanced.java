package com.company.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HeightBalanced {

    static class Node{

        int data;
        Node left;
        Node right;

        Node(int d){
            data = d;
            left = null;
            right = null;
        }
    };

    public Node buildTree(){

        Scanner s = new Scanner(System.in);
        int d = s.nextInt();
        if(d==-1){
            return null;
        }

        Node n = new Node(d);
        n.left = buildTree();
        n.right = buildTree();

        return n;
    }



    // O(N) time
    pair<Integer,Boolean> isHeightBalanced(Node root){

        pair<Integer,Boolean> p  = new pair<>();
        pair<Integer,Boolean> Left  = new pair<>();

        pair<Integer,Boolean> Right  = new pair<>();

//                Left, Right;

        if(root==null){
            p.value1 = 0; //height
            p.value2 = true; // balanced
            return p;
        }

        //rec case (Postorder Traversal)
        Left = isHeightBalanced(root.left);
        Right = isHeightBalanced(root.right);

        int height = Math.max(Left.value1, Right.value1) + 1;

        if(Math.abs(Left.value1 - Right.value1)<=1 && Left.value2 && Right.value2){
            return new pair<>(height,true);
        }
        return new pair<>(height,false);
    }

    static class pair<K,V>{

        K value1;
        V value2;

        public pair(){

        }

        public pair(K value1, V value2) {
            this.value1 = value1;
            this.value2 = value2;
        }
    }

    public static void main(String[] args) {

        HeightBalanced h= new HeightBalanced();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);
        root.left.right.right.left = new Node(9);
        root.left.right.right.right = new Node(10);

        pair<Integer, Boolean> p = h.isHeightBalanced(root);
        if(p.value2){
            System.out.println("Yes, its height balanced");
        }
        else{
            System.out.println("Not a height balanced tree");
        }
    }

}
