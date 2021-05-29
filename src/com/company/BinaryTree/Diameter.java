package com.company.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Diameter {

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

//Input :
//1
//        2
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
/* Todo: Implement Level Order Traversal
Expected Output
1
2 3
4 5 6
7
*/

    public void levelOrderPrint(Node root){

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node temp = q.peek();
            if(temp==null){
                System.out.println();
                q.remove();
                //insert a new null for the next level
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
            else{
                q.remove();
                System.out.print(temp.data + " ");

                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }

        }
        return;
    }
    //Helper Function : Height of the Tree
    int height(Node root){
        if(root==null){
            return 0;
        }
        int h1 = height(root.left);
        int h2 = height(root.right);
        return 1 + Math.max(h1,h2);
    }

    // Diameter
// Time Complexity?
    public int diameter(Node root){
        //base case
        if(root==null){
            return 0;
        }

        //rec case
        int D1 = height(root.left) + height(root.right);
        int D2 = diameter(root.left);
        int D3 = diameter(root.right);

        return Math.max(D1,Math.max(D2,D3));
    }

    //---------Diameter Optimised
    static class HDPair{
        int height;
        int diameter;
    };

    HDPair optDiameter(Node root){

        HDPair p = new HDPair();

        if(root==null){
            p.height = p.diameter = 0;
            return p;
        }

        //otherwise
        HDPair Left = optDiameter(root.left);
        HDPair Right = optDiameter(root.right);

        p.height = Math.max(Left.height,Right.height) + 1;

        int D1 = Left.height + Right.height;
        int D2 = Left.diameter;
        int D3 = Right.diameter;

        p.diameter = Math.max(D1,Math.max(D2,D3));
        return p;
    }

    public static void main(String[] args) {

        Diameter d = new Diameter();

        Node root = d.buildTree();
        d.levelOrderPrint(root);
        System.out.println(d.diameter(root));

        System.out.println(" Opt Diameter is " + d.optDiameter(root).diameter);

    }
}
