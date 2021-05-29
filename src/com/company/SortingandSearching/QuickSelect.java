package com.company.SortingandSearching;

import java.util.ArrayList;
import java.util.Vector;

public class QuickSelect {

    public static int partition(ArrayList<Integer> a, int s, int e){

        int pivot = a.get(e);
        int i = s - 1;

        for(int j=s;j<e;j++){
            if(a.get(j) < pivot){
                i++;
                swap(a, i, j);
            }
        }

        swap(a,i+1, e);
        return i + 1;

    }

    public static void swap(ArrayList<Integer> ar, int first, int second){

        int temp = ar.get(first);

        ar.set(first, ar.get(second));

        ar.set(second, temp);

    }

   public static int quickselect(ArrayList<Integer> a, int s, int e, int k){

        //assuming that k will be inside the array

        int p = partition(a,s,e);
        if(p==k){
            return a.get(p);
        }
        else if(k<p){
            return quickselect(a,s,p-1,k);
        }
        else{
            return quickselect(a,p+1,e,k);
        }

    }

    public static void main(String[] args) {

        ArrayList<Integer> ar = new ArrayList<>();

        ar.add(5);
        ar.add(4);
        ar.add(2);
        ar.add(3);
        ar.add(1);

        int n = ar.size();
        int k = 0;

        System.out.println(quickselect(ar, 0, n-1, k));
    }
}
