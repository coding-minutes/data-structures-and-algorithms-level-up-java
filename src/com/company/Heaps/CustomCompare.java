package com.company.Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CustomCompare {

    public static void main(String[] args) {
        int arr[] = {10, 15, 20, 13, 6, 90};
        int n = arr.length;

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int x : arr) {
            heap.add(x);
        }

        while (!heap.isEmpty()) {
            System.out.println(heap.peek());
            heap.remove();
        }
    }
}
