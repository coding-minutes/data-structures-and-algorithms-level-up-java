package com.company.StringCodes;

import java.util.Scanner;

public class StringFindAll {

    public static void main(String[] args) {

        String str = "hello all. Welcome to coding minutes";
        Scanner s = new Scanner(System.in);

        String word =s.next();

        findoccurence(str, word);
    }


    public static void findoccurence(String str, String word){

        int index = 0;

        while(true){

            index = str.indexOf(word,index);

            if (index == -1) {

                break;
            }

            System.out.println(index);
            index=index+1;

        }
    }
}
