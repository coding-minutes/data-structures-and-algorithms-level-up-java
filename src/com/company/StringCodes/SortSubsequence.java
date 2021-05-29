package com.company.StringCodes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

public class SortSubsequence {

    public static void subsequence(String s,String o, Vector<String> v){
        //base case
        if(s.length()==0){
            v.add(o);
            return;
        }

        //rec case
        char ch = s.charAt(0);
        String reduced_input = s.substring(1);

        //includes
        subsequence(reduced_input, o + ch, v);

        //excludes
        subsequence(reduced_input, o , v);
    }

    public static void main(String[] args) {
        String s= "vcab";

        Vector<String> vector = new Vector<>();
        String output ="";

        subsequence(s,output,vector);

        vector.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length()==s2.length()){
                    return s1.compareTo(s2);
                }
                return s1.length() < s2.length() ? -1: 1;
            }
        });

        System.out.println(vector);

    }

}
