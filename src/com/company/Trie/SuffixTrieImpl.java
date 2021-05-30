package com.company.Trie;

import java.util.HashMap;

public class SuffixTrieImpl {




    public static void main(String[] args) {


        String input = "hello";
        String suffixes[] = {"lo","ell","hello"};

        TrieSuff t= new TrieSuff();

        t.insert(input);

        for(String sf : suffixes){
            if(t.search(sf)){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }


    }
}

 class TrieSuff {
    class Node{
        char data;
        HashMap<Character, Node> m = new HashMap<>();
        boolean isTerminal;

        Node(Character d){
            data = d;
            isTerminal = false;
        }
    }

    Node root;

    TrieSuff(){
        root = new Node('\0');
    }

    //later
    void insert_helper(String word){

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

    public void insert(String word){
        //pick all substrings from (i, eos) and insert_helper
        for(int i=0; i<=word.length();i++)
        {
            insert_helper(word.substring(i));
        }
    }
}
