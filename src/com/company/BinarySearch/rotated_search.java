package com.company.BinarySearch;

import java.util.ArrayList;
import java.util.Scanner;

public class rotated_search {
    public static int rotated_search(ArrayList<Integer> arr,int key) {
    int s=0;
    int e=arr.size()-1;
    while (s<=e)
    {
        int mid=(s+e)/2;
        if(arr.get(mid)==key){
            return mid;
        }
        if(arr.get(s)<=arr.get(mid))
        {
            if(key>=arr.get(s) && key<=arr.get(mid))
            {
                e=mid-1;
            }
            else
            {
                s=mid+1;
            }
        }
        else
        {
            if(key>=arr.get(mid)&&key<=arr.get(e))
            {
                s=mid+1;
            }
			else{
                e = mid - 1;
            }
        }
    }
    return  -1;

    }
    public static void main(String[] args) {
        Scanner read=new Scanner(System.in);
        int key = read.nextInt();
        ArrayList<Integer> arr= new ArrayList<Integer>();
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(3);

        System.out.println(rotated_search(arr,key));



    }
}
