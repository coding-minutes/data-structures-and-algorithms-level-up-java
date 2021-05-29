package com.company.ArraysandVectors_01;

import java.util.Arrays;
import java.util.Vector;

public class RainwaterTap {

    public static int trappedWater(Vector<Integer> heights) {

        //Complete
        int n = heights.size();
        if(n<=2){
            return 0;
        }

        //Left Max, Right Max
        Vector<Integer> left = new Vector<>(0);
        Vector<Integer> right = new Vector<>(5);

        for (int i = 0; i <n ; i++) {
            left.add(0);
            right.add(0);
        }

        left.set(0,heights.get(0));
        right.set(n-1, heights.get(n-1));

        for(int i=1;i<n;i++){
            left.set(i, Math.max(left.get(i-1),heights.get(i)));
            right.set(n-i-1, Math.max(right.get(n-i),heights.get(n-i-1)));
        }

        //water
        int water = 0;
        for(int i=0;i<n;i++){
            water += Math.min(left.get(i),right.get(i)) - heights.get(i);
        }

        return water;
    }


    public static void main(String[] args) {

        Integer[] water = {0,1,0,2,1,0,1,3,2,1,2,1};

        Vector<Integer> vector =
                new Vector<Integer>(Arrays.asList(water));

        System.out.println(trappedWater(vector));
    }

}
