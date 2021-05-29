package com.company.StackandQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FirstNonRepeatingQueue {


    public static void main(String[] args) {

        //First Non-Repeating character in the running stream
        Scanner s = new Scanner(System.in);
        Queue<Character> q = new LinkedList<>();
        int[] freq = new int[27] ; //a-z

        char ch =s.nextLine().charAt(0);

        while(ch!='.'){

            //letter
            q.add(ch);
            freq[ch - 'a']++;

            //query -> remove all chars from front of queue till you get a char with freq 1
            while(!q.isEmpty()){
                int idx = q.peek() - 'a';
                if(freq[idx]>1){
                    q.remove();
                }
                else{
                    System.out.println(q.peek());
                    break;
                }
            }

            if(q.isEmpty()){
                System.out.println("-1");
            }
            ch = s.next().charAt(0);
        }
    }
}
