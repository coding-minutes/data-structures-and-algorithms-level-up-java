package com.company.StackandQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Vector;

public class MaxSubArray {

    public static void maxSubArrayK(Vector<Integer> a, int k){

        //Algorithm
        int n = a.size();

        ArrayDeque<Integer> Q= new ArrayDeque<>(3);
        //1. Process only the first K elements
        int i;

        for(i=0;i<k;i++){
            //Logic here ...

            while(!Q.isEmpty() && a.get(i) > a.get(Q.peekLast())){
                Q.removeLast();
            }

            Q.addLast(i);

        }

        //2. Remaining the elements of the array
        for( ;i<n;i++){
            System.out.println(a.get(Q.peekFirst()));
            //Remove element from the left (contraction when an index lies outside the current window)
            while(!Q.isEmpty() && Q.peekFirst() <=i-k){
                Q.removeFirst();
            }
            while(!Q.isEmpty() && a.get(i) >= a.get(Q.peekLast())){
                Q.removeLast();
            }

            //always
            Q.addLast(i);
        }

        System.out.println(a.get(Q.peekFirst()));

    }

    public static void main(String[] args) {

        int k =3;

        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);

        vector.add(3);
        vector.add(1);

        vector.add(4);

        vector.add(5);

        vector.add(2);

        vector.add(3);

        vector.add(6);

        maxSubArrayK(vector, k);
    }
}
