package com.company.StackandQueue;

import java.util.Stack;

public class CheckRedun {

    public static boolean checkRedundant(String str){
        //Complete
        Stack<Character> s = new Stack<>();

        for(int i=0;i< str.length();i++){
            char ch = str.charAt(i);
            if(ch!=')'){
                s.push(ch); // a,b, + , - , ( ....
            }
            else{
                // ')'
                boolean operator_found = false;

                while(!s.empty()  && s.peek()!='('){
                    char top = s.peek();
                    if(top=='+' || top=='-' || top=='*' || top=='/'){
                        operator_found = true;
                    }
                    s.pop();
                }
                s.pop(); //pop the opening bracked after the loop if over

                if(operator_found == false){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
