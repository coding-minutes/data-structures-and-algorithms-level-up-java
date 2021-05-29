package com.company.Heaps;

import java.util.ArrayList;
import java.util.HashMap;

public class Heaps<T extends Comparable<T>> {

    ArrayList<T> list = new ArrayList<>();

    HashMap<T,Integer> map = new HashMap<>();

    public void insert(T element){

        list.add(element);
        map.put(element, list.size()-1);
        upheap(list.size()-1);
    }

    private void upheap(int index) {

        if (index == 0) {
            return;
        }

        int parent = parent(index);

        if(list.get(parent).compareTo(list.get(index))>0){
            swap(parent,index);
            upheap(parent);
        }
    }

    public T remove(){

        swap(0,list.size()-1);

        T temp = list.remove(list.size()-1);

        downheap(0);

        return temp;
    }

    public boolean isEmpty(){

        return list.isEmpty();
    }

    private void downheap(int index) {

        int min = index;

        int left = leftchild(index);
        int right =rightchild(index);

        if(left<list.size() && list.get(left).compareTo(list.get(min))<0){
            min = left;
        }

        if(right<list.size() &&list.get(right).compareTo(list.get(min))<0){
            min =right;
        }

        if(min !=index){
            swap(min,index);
            downheap(min);
        }

    }

    public void swap(int first, int second){

        T temp = list.get(first);
        T temp1 = list.get(second);

        list.set(first,list.get(second));
        list.set(second,temp);

        map.put(temp,second);
        map.put(temp1,first);

    }

    public void update(T pair){

        int index = map.get(pair);
        upheap(index);
    }

    public int parent(int index){

        return (index-1)/2;
    }

    public int leftchild(int index){
        return 2*index+1;
    }

    public int rightchild(int index){
        return 2*index+2;
    }

    public void display(){
        System.out.println(list);
    }
}
