package com.company.ArraysandVectors;

import java.util.Vector;

public class OneDVector {

    public static void main(String[] args) {


        Vector<Integer> arr = new Vector<>();
        arr.add(2);
        arr.add(3);



        for(int number : arr){
            System.out.println(number);
        }
    }
}
