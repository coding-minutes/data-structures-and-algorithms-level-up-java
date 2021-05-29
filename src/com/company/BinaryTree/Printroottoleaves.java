package com.company.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class Printroottoleaves {


    static class Node {

        int data;
        Node left;
        Node right;

        Node(int d) {
            data = d;
            left = null;
            right = null;
        }
    }

    ;

    //Input :
//1
// 2
// 4
// -1
// -1
// 5
// 7
// -1
// -1
// -1
// 3
// -1
// 6
// -1
// -1
    public HeightBalanced.Node buildTree() {

        Scanner s = new Scanner(System.in);
        int d = s.nextInt();
        if (d == -1) {
            return null;
        }

        HeightBalanced.Node n = new HeightBalanced.Node(d);
        n.left = buildTree();
        n.right = buildTree();

        return n;
    }

    public void levelOrderPrint(HeightBalanced.Node root) {

        Queue<HeightBalanced.Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            HeightBalanced.Node temp = q.peek();
            if (temp == null) {
                System.out.println();
                q.remove();
                //insert a new null for the next level
                if (!q.isEmpty()) {
                    q.add(null);
                }
            } else {
                q.remove();
                System.out.print(temp.data + " ");

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }

        }
    }
    void printRoot2LeafPaths(Node root, Vector<Integer> path){

        if(root==null){
            return;
        }
        //end at leaft node, print the path
        if(root.left==null && root.right==null){
            for(int data:path){
                System.out.println(data +"->3" +
                        "");
            }
            System.out.println(root.data+" ");
            System.out.println();
            return;
        }
        path.add(root.data);
        printRoot2LeafPaths(root.left,path);
        printRoot2LeafPaths(root.right,path);
        path.remove(path.size()-1);
    }
}
