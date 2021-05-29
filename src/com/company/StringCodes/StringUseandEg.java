package com.company.StringCodes;

import java.util.ArrayList;
import java.util.Scanner;

public class StringUseandEg {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i <4 ; i++) {
            list.add(scanner.nextLine());
        }

        String s = "hello";  //custom input

        System.out.println(s);

        System.out.println(list); //to print all the elements in list in string format

        for (int i = 0; i <list.size() ; i++) {   // to use the all the string individually
            System.out.println(list.get(i));
        }
    }
}
