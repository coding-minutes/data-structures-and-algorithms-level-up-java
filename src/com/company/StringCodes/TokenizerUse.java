package com.company.StringCodes;

import java.util.StringTokenizer;

public class TokenizerUse {
    public static void main(String[] args) {


        String s = "Hello there Everyone";

        StringTokenizer str = new StringTokenizer(s);

        while (str.hasMoreTokens()){
            System.out.println(str.nextToken());
        }

    }
}
