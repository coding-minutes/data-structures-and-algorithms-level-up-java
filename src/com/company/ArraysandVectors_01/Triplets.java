package com.company.ArraysandVectors_01;

import java.util.Collections;
import java.util.Vector;

public class Triplets {

    public static Vector<Vector<Integer>> triplets(Vector<Integer> arr, int targetSum){
        //Logic
        int n = arr.size();
        Collections.sort(arr);
        Vector<Vector<Integer>> result = new Vector<>();

        // Pick every a[i], pair sum for remaining part
        for(int i=0; i<=n-3;i++){

            int j = i + 1;
            int k = n - 1;

            //two pointer approach
            while(j < k){
                int current_sum = arr.get(i);
                current_sum += arr.get(j);
                current_sum += arr.get(k);

                if(current_sum==targetSum){
                    Vector<Integer> vector = new Vector();
                    vector.add(arr.get(i));
                    vector.add(arr.get(j));
                    vector.add(arr.get(k));
                    result.add(vector);
                    j++;
                    k--;
                }
                else if(current_sum > targetSum){
                    k--;
                }
                else{
                    j++;
                }
            }

        }
        return result;

    }

}
