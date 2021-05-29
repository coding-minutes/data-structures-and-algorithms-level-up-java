package com.company.Recursion;

public class KeyPad {

    public static void printKeypadOutput(String input,String output, int i, String[] keypad){

        if(input.isEmpty()){
            System.out.println(output);
            return;
        }

        //rec case
        char ch = input.charAt(0);
        input =input.substring(1);
        int current_digit = ch - '0';

        if(current_digit==0 || current_digit==1){
            printKeypadOutput(input,output,i+1,keypad);
        }

        //keypad
        for(int k=0; k<keypad[current_digit].length();k++){
            printKeypadOutput(input,output + keypad[current_digit].charAt(k),i+1, keypad);
        }

    }

    public static void main(String[] args) {

        String keypad[] = {"","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};

        String input ="23";
        String output= "";

        printKeypadOutput(input,"" ,0, keypad);

    }
}
