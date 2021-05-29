package com.company.DP1;

public class LCS {

    public static int LCSrecDP(String s1, String s2, int[][] mem) {

        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        }

        if(mem[s1.length()][s2.length()]!=0){

            return mem[s1.length()][s2.length()];
        }

        char f = s1.charAt(0);
        char s = s2.charAt(0);

        if (f == s) {
            mem[s1.length()][s2.length()] = LCSrecDP(s1.substring(1), s2.substring(1),mem) + 1;
        } else {
            mem[s1.length()][s2.length()] = Math.max(LCSrecDP(s1.substring(1), s2,mem), LCSrecDP(s1, s2.substring(1),mem));
        }

        return mem[s1.length()][s2.length()];
    }

    public static void main(String[] args) {

    }
}
