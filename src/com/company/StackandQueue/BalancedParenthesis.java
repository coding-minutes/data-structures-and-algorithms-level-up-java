package com.company.StackandQueue;

import java.util.Stack;

public class BalancedParenthesis {

    public static boolean isBalanced(String input){

        Stack<Character> s = new Stack<>();
        for(int i=0; i< input.length(); i++){

            switch(input.charAt(i)){
                case '(':
                case '[':
                case '{': s.push(input.charAt(i));
                    break;

                case ')': if(!s.empty() && s.peek()=='('){
                    s.pop();
                }
					  else{
                    return false;
                }
                break;

                case ']': if(!s.empty() && s.peek()=='['){
                    s.pop();
                }
					  else{
                    return false;
                }
                break;

                case '}': if(!s.empty() && s.peek()=='{'){
                    s.pop();
                }
					  else{
                    return false;
                }
                break;
                default :
            }
        }

        return s.empty();
    }

    public static void main(String[] args) {

        String s = "((a+b+c)+[d])";//{ a + (b+c) + ([d+e]*f)) } + k";

        if(isBalanced(s)){
            System.out.println("Balanced!");
        }
        else{
            System.out.println("not balanced");
        }
    }
}
