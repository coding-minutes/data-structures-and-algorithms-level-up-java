package com.company.ArraysandVectors_01;

import java.util.*;

public class MinSwap {
  public static void main(String[] args) {
    int[] input = new int[]{10,11,5,4,3,2,1};
    int ans = 0;
    Map<Integer,Integer> map = new HashMap<>();
    for(int i=0;i<input.length;i++){
      map.put(input[i],i);
    }
    // get the index of the input and make the sort and store the index in sortIndex
    Arrays.sort(input);
    List<Integer> sortIndex = new ArrayList<>();
    for(int i:input){
      sortIndex.add(map.get(i));
    }
    List<Boolean> visited = new ArrayList<>(Collections.nCopies(input.length,false));
    for(int i=0;i<input.length;i++){
      if(sortIndex.get(i) == i || visited.get(i)){
        continue;
      }
      int cycle = 0;
      int node = i;
      while(!visited.get(node)){
        visited.set(node,true);
        node = sortIndex.get(node);
        cycle += 1;
      }
      ans+=cycle-1;
    }
    System.out.println(ans);
  }
}
