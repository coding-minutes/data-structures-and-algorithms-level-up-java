package com.company.BinarySearch;

import java.util.ArrayList;

public class frequency_count {
    public static int lower_bound(ArrayList<Integer> arr,int key) {
        int s=0;
        int e=arr.size()-1;

        int ans=-1;

        while(s<=e)
        {
            int mid = (s+e)/2;

            if(arr.get(mid)==key)
            {
                ans=mid;
                e=mid-1;
            }
            else if(arr.get(mid)>key)
            {
                e=mid-1;
            }
            else
            {
                s=mid+1;
            }
        }
        return ans;

    }

    public static int upper_bound(ArrayList<Integer> arr,int key) {
        int s=0;
        int e=arr.size()-1;

        int ans=-1;

        while(s<=e)
        {
            int mid = (s+e)/2;

            if(arr.get(mid)==key)
            {
                ans=mid;
                s=mid+1;
            }
            else if(arr.get(mid)>key)
            {
                e=mid-1;
            }
            else
            {
                s=mid+1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr= new ArrayList<Integer>();
        arr.add(0);
        arr.add(1);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(5);
        arr.add(5);
        arr.add(10);

        System.out.println(upper_bound(arr,3)-lower_bound(arr,3)+1);

    }
}
