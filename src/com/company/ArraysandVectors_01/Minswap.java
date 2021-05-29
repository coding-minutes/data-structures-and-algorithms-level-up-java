package com.company.ArraysandVectors_01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class Minswap {

    public static Vector<Integer> pairSum(Vector<Integer> arr, int Sum) {
        //Logic
        Set<Integer> s = new HashSet<>();
        Vector<Integer> result = new Vector<>();

        for (int i = 0; i < arr.size(); i++) {

            int x = Sum - arr.get(i);
            if (s.contains(x)) {
                result.add(x);
                result.add(arr.get(i));
                return result;
            }
            //insert the current no inside set
            s.add(arr.get(i));
        }

        return null;
    }

    public static void main(String[] args) {
        Integer[] ar = {10, 5, 2 , 3, -6, 9 , 11};
        int S = 4;

        Vector<Integer> arr = new Vector<>(Arrays.asList(ar));

        Vector<Integer> p = pairSum(arr,S);
        if(p.size()==0){
            System.out.println("no such pair");
        }
        else{
            System.out.println(p.get(0)+" , "+ p.get(1));
        }
    }
}
