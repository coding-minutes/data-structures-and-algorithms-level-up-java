package com.company.Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapClient {

    public static void main(String[] args) {

//        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -(o1 - o2));
//
//        pq.add(5);
//        pq.add(4);
//        pq.add(1);
//        pq.add(6);


        Heaps<Integer> heap = new Heaps<>();
        for (int i = 10; i>=0 ; i--) {
            heap.insert(i);
            heap.display();
        }
    }
}
