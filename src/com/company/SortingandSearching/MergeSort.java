package com.company.SortingandSearching;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] ar = {4,3,5,2,1};
        System.out.println(Arrays.toString(divide(ar)));
    }

    public static int[] divide(int[] ar){

        if(ar.length==1){
            return ar;
        }

        int mid = ar.length/2;

        int[] first = divide(Arrays.copyOfRange(ar,0,mid));
        int[] second = divide(Arrays.copyOfRange(ar,mid,ar.length));

        return merger(first,second);
    }


    public static int[] merger(int[] first, int[] second){

        int i=0;
        int j=0;
        int k=0;

        int[] mix = new int[first.length+second.length];

       while(i<first.length && j<second.length){

           if(first[i]<second[j]){
               mix[k]=first[i];
               k++;
               i++;
           }
           else{
               mix[k]=second[j];
               k++;
               j++;
           }
       }

       while(i<first.length){
           mix[k]=first[i];
           k++;
           i++;
       }

       while(j<second.length){
           mix[k]=second[j];
           k++;
           j++;
       }

       return mix;
    }
}
