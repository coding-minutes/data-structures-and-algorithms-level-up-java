package com.company.Recursion;

public class Countsubset {

    public static int countSubsets(int[] arr,int n,int i,int X){

        //base case
        if(i==n){
            if(X==0){
                return 1;
            }
            return 0;
        }

        //recusive case
        int inc  = countSubsets(arr,n,i+1,X - arr[i]);
        int exc = countSubsets(arr,n,i+1,X);
        return inc + exc;
    }

    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5};
        int X = 10;

        System.out.println(countSubsets(arr, arr.length,0,X));
    }
}
