package com.company.Heaps;

import java.util.PriorityQueue;

public class Heap02Rope {

    public static int join_ropes(Integer[] ropes, int n) {

        //min heap
        PriorityQueue<Integer>  pq = new PriorityQueue<>();
        for (int i = 0; i <n ; i++) {
            pq.add(ropes[i]);
        }

        //logic
        int cost = 0;

        while(pq.size() > 1){

            int A = pq.peek();
            pq.remove();

            int B = pq.peek();
            pq.remove();


            int new_rope = (A+B);
            cost  += new_rope;
            pq.add(new_rope);


        }

        return cost;

    }

    public static void main(String[] args) {
        Integer ropes[] = {4, 3, 2, 6};
        int n = 4;

        System.out.println(join_ropes(ropes, n));
    }
}
