package com.company.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;

public class angry_birds {
    public static boolean canPlaceBirds(int B,int N,ArrayList<Integer> nests,int sep) {
        int birds = 1;
        int location = nests.get(0);

        for(int i=1; i<=N-1; i++){
            int current_location = nests.get(i);
            if(current_location - location >= sep){
                birds++;
                location = current_location;

                if(birds==B){
                    return true;
                }
            }
        }
        return false;

    }
    public static void main(String[] args) {
        int b = 3;
        ArrayList<Integer> nests =new ArrayList<>();
        nests.add(1);
        nests.add(2);
        nests.add(4);
        nests.add(8);
        nests.add(9);

        Collections.sort(nests);
        int N = nests.size();
        //Binary Search
        int s = 0;
        int e = nests.get(N-1) - nests.get(0);
        int ans = -1;

        while(s<=e){
            int mid = (s+e)/2;

            boolean canPlace = canPlaceBirds(b,N,nests,mid);
            if(canPlace){
                ans = mid;
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
