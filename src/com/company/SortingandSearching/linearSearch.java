package com.company.SortingandSearching;

public class linearSearch{

    public static void main(String[] args){

        int arr[] = {4,8,3,7,1,8,9};
        int n = arr.length;
        int element =  8;

        for(int i=0;i<n;i++)
        {
            if(arr[i] == element)
            {
                System.out.println("Element found");
                break;
            }
        }
    }
}