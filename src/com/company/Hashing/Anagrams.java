package com.company.Hashing;

import java.util.*;

public class Anagrams {

    public static List<Integer> getHashValue(String s, int i, int j){

        Integer[] freq = new Integer[26];

        freq[0] = 0;

        for (int k = 1; k <freq.length ; k++) {

            freq[k] = 0;
        }

        List<Integer> list = new ArrayList<>(Arrays.asList(freq));

        //iterate over the original string from i to j to fill this vector
        for(int k=i;k<=j;k++){
            char ch = s.charAt(k);
            list.set((ch - 'a'), list.get(ch-'a')+1) ;
        }

        return list;
    }

    public static int anagrams_substrings(String s){

        HashMap<List<Integer> , Integer> m = new HashMap<>();

        for(int i=0;i<s.length();i++){
            for(int j=i; j<s.length();j++){

                //Substring S[i...j]
                List<Integer> h = getHashValue(s,i,j);
                //put it inside a map

                if(m.containsKey(h)) {
                    m.put(h, m.get(h) + 1);
                }
                else{
                    m.put(h,1);
                }
            }
        }

        //pairs
        int ans = 0;
        for(List<Integer> p : m.keySet()){

            int freq = m.get(p);
            if(freq>=2){
                ans += (freq)*(freq-1)/2;
            }

        }
        return ans;

    }

    public static void main(String[] args) {

        String s= "abba";

        System.out.println(anagrams_substrings(s));
    }
}
