package com.company.Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class TipletsGp {

    public static int count_triplets(Long[] arr,int r){

        int n = arr.length;
        HashMap<Long,Long> right = new HashMap<>();
        HashMap<Long,Long> left = new HashMap<>();


        //Init the Right Map with freq, Left map = 0
        for(Long x : arr){
            if(!right.containsKey(x)){
                right.put(x, 1L);
            } else {
                right.put(x, right.get(x)+1);
            }

            left.put(x, 0L);
        }

        //compute by iterating left to right
        int ans = 0;
        for(int i = 0; i < n; i++){


            right.put(arr[i],right.get(arr[i])-1);

            if(arr[i]%r==0){
                long b = arr[i];
                long a = arr[i]/r;
                long c = arr[i]*r;

                ans += (left.containsKey(a)? left.get(a): 0 ) * (right.containsKey(c)?right.get(c): 0);
            }

            left.put(arr[i],left.get(arr[i])+1);

        }
        return ans;

    }

     public static void main(String[] args) {

        Scanner s= new Scanner(System.in);
        int n = 6 ;
        int r = 4;

        Long[] arr = new Long[n];
        for(int i=0;i<n;i++){
            arr[i]= s.nextLong();
        }

        System.out.println(count_triplets(arr, r));
    }
}
