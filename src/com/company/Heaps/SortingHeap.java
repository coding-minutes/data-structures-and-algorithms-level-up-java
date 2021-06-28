package com.company.Heaps;

import java.util.PriorityQueue;

public class SortingHeap {

    public static void main(String[] args) {

        int arr[] = {10, 15, 20, 13, 6, 90};
        int n = arr.length;

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int x : arr) {
            heap.add(x);
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.peek());
            heap.remove();
        }
    }


}
