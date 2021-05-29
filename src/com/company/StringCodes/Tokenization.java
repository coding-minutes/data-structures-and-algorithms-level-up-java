package com.company.StringCodes;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Tokenization {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        String input = s.nextLine();

        //"this is a sunny day"

        //create a string stream object

        StringTokenizer stringTokenizer = new StringTokenizer(input);


        int  i= stringTokenizer.countTokens();

        System.out.println(i);


    }
}
