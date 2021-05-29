package com.company.SlidingWindow;

public class Housing {

    public static void housing(int[] arr, int n, int k) {

        int i = 0;
        int j = 0;
        int cs = 0;

        while (j < n) {

            //expand to right
            cs += arr[j];
            j++;

            //remove elements from the left till cs > sum and i<j
            while (cs > k && i < j) {
                cs = cs - arr[i];
                i++;
            }

            //check if any given point
            if (cs == k) {
                //print that window
                System.out.println(i + " - " + (j - 1));
                ;
            }

        }
    }

    public static void main(String[] args) {

        int plots[] = {1, 3, 2, 1, 4, 1, 3, 2, 1, 1};
        int n = plots.length;
        int k = 8;

        housing(plots, n, k);

    }
}