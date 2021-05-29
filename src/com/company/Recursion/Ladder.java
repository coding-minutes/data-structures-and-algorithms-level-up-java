package com.company.Recursion;

public class Ladder {

    public static int countWays(int n){
        //Base
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }

        //Recursive
        return countWays(n-1) + countWays(n-2) + countWays(n-3);

    }

    public static void main(String[] args) {

    }
}
