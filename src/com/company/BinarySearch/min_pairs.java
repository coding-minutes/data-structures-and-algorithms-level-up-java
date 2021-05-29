package com.company.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class min_pairs {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(-1, 5, 10, 20, 3));
        ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(-1, 5, 10, 20, 3));

        min_pair(a1,a2);
    }

    public static int lower_bound(ArrayList<Integer> ar,int k)
    {
        int s=0;
        int e=ar.size();
        while (s !=e)
        {
            int mid = s+e>>1;
            if (ar.get(mid) <k)
            {
                s=mid+1;
            }
            else
            {
                e=mid;
            }
        }
        if(s==ar.size())
        {
            return -1;
        }
        return s;
    }

    public static void min_pair(ArrayList<Integer> a1,ArrayList<Integer> a2) {
        Collections.sort(a2);

        int p1=0,p2=0;
        int diff = Integer.MAX_VALUE;
        for(int x : a1){
            int lb = Collections.binarySearch(a2,x) - a2.get(0);

            //left
            if(lb>=1 && x - a2.get(lb-1)< diff){
                diff = x - a2.get(lb-1);
                p2 = x;
                p1 = a2.get(lb-1);
            }
            //greater / right
            if(lb!=a2.size() && a2.get(lb)-x < diff){
                diff = a2.get(lb) - x;
                p1 = x;
                p2 = a2.get(lb);
            }

        }
        System.out.println("Min Pair "+p1+" and "+p2);
    }
}
