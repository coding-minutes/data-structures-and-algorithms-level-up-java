package com.company.StringCodes;

public class CheckSubset {

    public static boolean isSubset(String s1,String s2){

        int i = s1.length() - 1;
        int j = s2.length()-1;

        while(i>=0 && j>=0){
            if(s2.charAt(j)==s1.charAt(i)){
                i--;
                j--;
            }
            else{
                i--;
            }
        }
        if(j==-1){
            return true;
        }
        return false;

    }
}
