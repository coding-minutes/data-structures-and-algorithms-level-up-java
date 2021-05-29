package com.company.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class max_sub {

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

        static class Pair{

            int inc;
            int exc;

            public Pair(){

            }

            public Pair(int inc, int exc) {
                this.inc = inc;
                this.exc = exc;
            }
        }

        Pair maxSubsetSum (Node  root) {
            Pair p =new Pair();
            if (root == null) {
                p.inc = p.exc = 0;
                return p;
            }

            Pair Left = maxSubsetSum(root.left);
            Pair Right = maxSubsetSum(root.right);

            p.inc = root.data + Left.exc + Right.exc;
            p.exc = Math.max(Left.inc, Left.exc) + Math.max(Right.inc, Right.exc);

            return p;
        }

    }
