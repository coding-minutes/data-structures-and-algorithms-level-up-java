package com.company.DP1;

public class LCSIterative {


    public static int LCSIterativeDP(String s1, String s2, int[][] mem){

        for (int i = 0; i <=s1.length() ; i++) {

            for (int j = 0; j <=s2.length(); j++) {


                if (i==0 || j==0){
                    mem[i][j]=0;
                }

                else{

                    if(s1.charAt(i-1)==s2.charAt(j-1)){

                        mem[i][j] = mem[i-1][j-1] + 1;
                    }

                    else{

                        mem[i][j]= Math.max(mem[i-1][j],mem[i][j-1]);
                    }
                }
            }
        }
        return mem[s1.length()][s2.length()];
    }

    public static void main(String[] args) {

    }
}
