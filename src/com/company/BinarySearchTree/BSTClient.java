package com.company.BinarySearchTree;

public class BSTClient {

    public static void main(String[] args) {

        BSTtoLL  closestDiff= new BSTtoLL();

        int[] ar = {8,3,10,1,6,14,4,7,13};

        for (int i = 0; i <ar.length ; i++) {

            closestDiff.insert(ar[i]);
        }

        closestDiff.display();
//        int[] pre= {7, 4, 2, 5 ,15, 10, 25};

////
//        bst.inrange(5,5);

//        bst.sort();

//        System.out.println(bst.successor(4));

    }
}
