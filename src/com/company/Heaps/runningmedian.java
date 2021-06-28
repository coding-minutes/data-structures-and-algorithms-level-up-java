package com.company.Heaps;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class runningmedian {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        PriorityQueue<Integer> leftheap = new PriorityQueue<>(Collections.reverseOrder()); //maxheap
        PriorityQueue<Integer> rightheap = new PriorityQueue<>(); //min heap

        int d = s.nextInt();

        leftheap.add(d);

        float med = d;
        System.out.println(med + "");
        d= s.nextInt();
        while (d != -1) {
            //left or right or equal
            if (leftheap.size() > rightheap.size()) {
                if (d < med) {
                    rightheap.add(leftheap.peek());
                    leftheap.remove();
                    leftheap.add(d);
                } else {
                    rightheap.add(d);
                }
                med = (leftheap.peek() + rightheap.peek()) / 2.0f;
            } else if (leftheap.size() == rightheap.size()) {
                if (d < med) {
                    leftheap.add(d);
                    med = leftheap.peek();
                } else {
                    rightheap.add(d);
                    med = rightheap.peek();
                }

            } else {
                if (d < med) {
                    leftheap.add(d);
                } else {
                    leftheap.add(rightheap.peek());
                    rightheap.remove();
                    rightheap.add(d);
                }
                med = (leftheap.peek() + rightheap.peek()) / 2;

            }

            System.out.println(med + "");
            d= s.nextInt();
        }
    }
}