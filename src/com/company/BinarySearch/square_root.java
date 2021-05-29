package com.company.BinarySearch;

import java.util.Scanner;

public class square_root {
    public static float square_root(int N,int P) {
        int s = 0;
        int e = N ;
        float ans = 0;

        //Binary Search (Search Space 0....N)
        while(s<=e){
            int mid = (s+e)/2;
            if(mid*mid==N){
                return mid;
            }
            else if(mid*mid < N){
                ans = mid;
                s = mid + 1;
            }

            else{
                e = mid - 1;
            }

        }

        //Linear Search for each place (for floating part)
        float inc = 0.1f;

        for(int place=1;place<=P;place++){

            //do linear search
            while(ans*ans <=N){
                ans += inc;
            }

            //take one step back
            ans = ans - inc;
            inc = inc/10.0f;
        }


        return ans;
    }
    public static void main(String[] args) {
        Scanner read=new Scanner(System.in);
        int n = read.nextInt();
        int p = read.nextInt();
        System.out.println(square_root(n,p));

    }
}
