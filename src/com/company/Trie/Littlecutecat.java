package com.company.Trie;

import java.util.HashMap;
import java.util.Vector;

public class Littlecutecat {
    class Node{
        char data;
        HashMap<Character, Node> children= new HashMap<>();
        boolean isTerminal;

        Node(Character d){
            data = d;
            isTerminal = false;
        }
    };


    public class Trie {

        Node root;

        Trie() {
            root = new Node(null);
        }

        //later
        void insert(String word) {

            Node temp = root;

            for (int i = 0; i < word.length(); i++) {

                char ch = word.charAt(i);

                if (!temp.children.containsKey(ch)) {
                    Node n = new Node(ch);
                    temp.children.put(ch, n);
                }
                temp = temp.children.get(ch);
            }

            temp.isTerminal = true;

        }

        void searchHelper(Trie t, String document, int i, HashMap<String, Boolean> m) {

            Node temp = t.root;
            for (int j = i; j < document.length(); j++) {
                char ch = document.charAt(j);
                if (!temp.children.containsKey(ch)) {
                    return;
                }
                temp = temp.children.get(ch);
                if (temp.isTerminal) {
                    //history part
                    String out = substringutil(document, i, j - i + 1);
                    m.put(out, true);
                }

            }

        }

        private String substringutil(String str, int start_window, int i) {

            int inc = start_window;
            StringBuilder str1 = new StringBuilder();

            while (i != 0) {

                str1.append(str.charAt(inc));
                inc++;
                i--;
            }

            return str1.toString();
        }


        void documentSearch(String document, Vector<String> words) {

            //1. Create a trie of words
            Trie t = new Trie();
            for (String w : words) {
                t.insert(w);
            }

            //2. Searching (Helper Fn)
            HashMap<String, Boolean> m = new HashMap<>();
            for (int i = 0; i < document.length(); i++) {
                searchHelper(t, document, i, m);
            }

            //3. You can check which words are marked as True inside Hashmap
            for (String w : words) {
                if (m.containsKey(w)) {
                    System.out.println(w + " : True");
                } else {
                    System.out.println(w + " : False");
                }
            }

        }
    }}