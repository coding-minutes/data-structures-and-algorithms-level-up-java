package com.company.SortingandSearching;

import java.util.Arrays;

public class Smallest_String {


    public static void main(String[] args) {

        String[] arr = {"a","ab","aba"};

        Arrays.sort(arr, (o1, o2) -> (o1+o2).compareTo(o2+o1));
        System.out.println(Arrays.toString(arr));

        for (String s: arr) {
            System.out.print(s);
        }
    }

}
