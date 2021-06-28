package com.company.StringCodes;

import java.util.Scanner;

public class Stringfind {

    public static void main(String[] args) {

        String str = "hello all. Welcome to coding minutes";

        Scanner s = new Scanner(System.in);

        String word = s.next();

        int index = str.indexOf(word);

        if(index!= -1){
            System.out.println(index);
        }

        int index1 = str.indexOf(word, index+1);

        if(index!= -1){
            System.out.println(index);
        }
    }
}
