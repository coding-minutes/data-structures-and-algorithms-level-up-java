//package com.company.BinarySearch;
//
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.Deque;
//

/** In progress*/
//public class max_subarray_sliding_window_deque {
//    public static void main(String[] args) {
//        int k = 3;
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(1);
//        arr.add(2);
//        arr.add(3);
//        arr.add(1);
//        arr.add(4);
//        arr.add(5);
//        arr.add(2);
//        arr.add(3);
//        arr.add(5);
//        maxSubArrayK(arr,k);
//    }
//
//    public static void maxSubArrayK(ArrayList<Integer> a,int k) {
//        int n = a.size();
//        Deque<Integer> Q = new ArrayDeque<Integer>();
//        //1. Process only the first K elements
//        int i;
//
//        for(i=0;i<k;i++){
//            //Logic here ...
//
//            while(!Q.isEmpty() && a.get(i) > a.get(Q.getLast())){
//                Q.removeLast();
//            }
//
//            Q.addLast(i);
//
//        }
//
//        //2. Remaining the elements of the array
//        for( ;i<n;i++){
//            System.out.print(a.get(Q.getFirst())+" ");
//            //Remove element from the left (contraction when an index lies outside the current window)
//            while(!Q.isEmpty() && Q.getFirst() <=i-k){
//                Q.removeFirst();
//            }
//            while(!Q.isEmpty() && a.get(i) >=a.get(Q.getLast())){
//                Q.removeLast();
//            }
//
//            //always
//            Q.addLast(i);
//        }
//        System.out.println();
//        System.out.println(a.get(Q.getFirst()));
//    }
//}
