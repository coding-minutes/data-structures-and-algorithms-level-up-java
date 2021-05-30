package com.company.Trie;

import java.util.HashMap;

public class Introduction {

    class Node{
        char data;
        HashMap<Character, Node> m= new HashMap<>();
        boolean isTerminal;

        Node(Character d){
            data = d;
            isTerminal = false;
        }
    };


    public class Trie {

        Node root;

        Trie(){
            root = new Node(null);
        }

        //later
        void insert(String word){

            Node temp = root;

            for (int i = 0; i <word.length() ; i++) {

                char ch = word.charAt(i);

                if(!temp.m.containsKey(ch)){
                    Node n = new Node(ch);
                    temp.m.put(ch,n);
                }
                temp = temp.m.get(ch);
            }

            temp.isTerminal = true;

        }

        public boolean search(String word){

            Node temp = root;

            for (int i = 0; i <word.length() ; i++) {

                char ch = word.charAt(i);

                if(!temp.m.containsKey(ch)){
                    return false;
                }
                temp = temp.m.get(ch);


            }
            return temp.isTerminal;
        }
    }

    public static void main(String[] args) {

        String input = "this is a suffix trie";

    }
}
