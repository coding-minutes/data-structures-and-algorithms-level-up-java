package com.company.StringCodes;

public class StringUtils {

    public static void main(String[] args) {


        String str = "This is a great course. great it is";

        System.out.println(str.length());

        System.out.println(str.charAt(0)); //prints char at mentioned index

        findword(str);
    }

    public static void findword(String str){

        int index = str.indexOf("great");

        System.out.println(index);   //it prints the first index where we find is so the answer will be 10.

        index = str.lastIndexOf("great");

        System.out.println(index);

    }

}
