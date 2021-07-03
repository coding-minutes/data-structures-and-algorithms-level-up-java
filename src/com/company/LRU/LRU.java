package com.company.LRU;



import java.util.HashMap;
import java.util.LinkedList;

public class LRU {

    static class Node {
        String key;
        int value;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    ;


    //LRU Cache Data Structure
    static class LRUCache {
        int maxSize;
        LinkedList<Node> l = new LinkedList<>();
        HashMap<String, Node> m = new HashMap<>();

        LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
        }

        void insertKeyValue(String key, int value) {
            //2 cases
            if (m.containsKey(key)) {
                //replace the old value and update

                for (Node node : l) {

                    if (node.key.equals(key)) {
                        node.value = value;
                    }
                }

            } else {
                //check if cache if full or not
                //remove the least recently used item from cache
                if (l.size() == maxSize) {
                    Node last = l.getLast();
                    m.remove(last.key); //remove from hashmap
                    l.removeLast(); //remove from linked list
                }

                Node n = new Node(key, value);
                l.addFirst(n);
                m.put(key, l.getFirst());
            }
        }

        Integer getValue(String key) {

            if (m.containsKey(key)) {
                for (Node node : l) {
                    if (node.key.equals(key)) {
                        int value = node.value;
                        l.addFirst(new Node(node.key, node.value));
                        l.remove(node);
                        m.put(key, l.getFirst());
                        return l.getFirst().value;
                    }
                }
            }
            return null;

        }

        String mostRecentKey() {
            return l.getFirst().key;
        }

    }

    ;

    public static void main(String[] args){
        LRUCache lru = new LRUCache(3);
        lru.insertKeyValue("mango", 10);
        lru.insertKeyValue("apple", 20);
        lru.insertKeyValue("guava", 30);
        System.out.println(lru.mostRecentKey());

        lru.insertKeyValue("mango", 40);
        System.out.println(lru.mostRecentKey());

        Integer orders = lru.getValue("mango");
        if (orders != null) {
            System.out.println(orders);
        }

        lru.insertKeyValue("banana", 20);

        if (lru.getValue("apple") == null) {
            System.out.println("apple doesn't exist");
        }

        if (lru.getValue("guava") == null) {
            System.out.println("guava doesn't exist");
        }

        if (lru.getValue("banana") == null) {
            System.out.println("banana doesn't exist");
        }
        if (lru.getValue("mango") == null) {
            System.out.println("mango doesn't exist");
        }
    }
}