package com.company.LinkedList;


import java.util.Stack;

public class LinkedList {

    Node head;
    int size = 0;
    Node tail;

    public void insertfirst(int element){

        Node node = new Node(element);
        node.next= head;
        head = node;

        if(tail==null){
            tail=head;
        }

        size++;
    }

    public void insertlast(int element){

        if(size==0){
            insertfirst(element);
            return;
        }

        Node node = new Node(element);

        tail.next = node;

        tail = node;

        size++;
    }

    public int deletefirst(){

        if(size == 0){
            System.out.println("Khaali he yaar ");
            return -1;
        }

        int temp = head.value;

        head = head.next;

        if(head == null ){
            tail =null;
        }
        size--;

        return temp;

    }

    public int deletelast(){

        if(size<2){
            return deletefirst();
        }

        Node temp = head;

        while(temp.next!=tail){

            temp = temp.next;
        }

        int del = temp.next.value;

        temp.next =null;

        tail = temp;

        size--;

        return del;
    }

    public Node get(int index){

        Node temp = head;

        for (int i = 0; i <index ; i++) {

            temp = temp.next;
        }

        return temp;
    }

    public void insertmid(int index, int element){

        if(index==0){
            insertfirst(element);
            return;
        }

        if(index ==size){
            insertlast(element);
            return;
        }

        Node prev = get(index - 1);

        Node node = new Node(element);

        node.next = prev.next;

        prev.next = node;

        size++;
    }

    public int deleteindex(int index)
    {

        if(index==0)
        {
           return deletefirst();
        }
        if(index==size-1)
        {
            return deletelast();
        }


        Node prev = get(index-1);
        int temp= prev.next.value;
        prev.next= prev.next.next;

        size--;
        return temp;
    }

    public void reverse(){

        reverse(head);
    }

    private void reverse(Node node) {

        if(node == tail){
            head = tail;
            return;
        }

        reverse(node.next);

        tail.next=node;
        node.next =null;
        tail=node;
    }

    public Node mid(){

        Node slow = head;
        Node fast = head;

        while( fast.next!=null && fast.next.next!=null){


            slow= slow.next;
            fast= fast.next.next;


        }

        return slow;


        /*   if you need mid as 5 in 1,2,5,6,8   */

//        while( fast!=null && fast.next!=null){
//
//            slow= slow.next;
//            fast= fast.next.next;

//        }



    }

    public int kthfromlast(int k){

        Node slow = head;
        Node fast = head;


        for (int i = 0; i <k; i++) {
            fast = fast.next;
        }

        while(fast!=null){

            slow = slow.next;
            fast = fast.next;
        }

        return slow.value;
    }

    public LinkedList merge(LinkedList l1, LinkedList l2){

        LinkedList l3 = new LinkedList();

        Node first = l1.head;
        Node second = l2.head;


        while(first!=null && second!=null){

            if(first.value<second.value){

                l3.insertlast(first.value);
                first = first.next;
            }

            else{
                l3.insertlast(second.value);
                second = second.next;
            }
        }

        while(first!=null){

            l3.insertlast(first.value);
            first = first.next;
        }

        while (second!=null){

            l3.insertlast(second.value);
            second = second.next;
        }

        return l3;
    }


    public LinkedList mergesort(LinkedList list){

        if(list.size==1){
            return list;
        }

        Node mid = list.mid();
        LinkedList first =new LinkedList();

        first.head =list.head;
        first.tail= mid;
        first.size= (list.size+1)/2;

        LinkedList second = new LinkedList();

        second.head= mid.next;
        second.tail = list.tail;
        second.size = list.size/2;

        mid.next =null;

        first = mergesort(first);
        second= mergesort(second);

        return merge(first, second);

    }

    public void kreverse(int k){

        Node prev = null;

       Stack<Node> stack = new Stack<>();

       Node temp= head;

       while(temp!=null){

           int cnt =1;

           while(temp!=null && cnt <=k){

               stack.push(temp);
               temp =temp.next;
               cnt=cnt+1;
           }

           while (!stack.isEmpty()){

               if(prev == null){
                   prev = stack.pop();
                   head = prev;
               }

               else{

                   prev.next=stack.pop();
                   prev = prev.next;
               }
           }
       }

       prev.next=null;
       tail = prev;
    }

    public void display(){

        Node temp = head;

        while(temp!=null){

            System.out.print(temp.value +"->");
            temp=temp.next;
        }

        System.out.println("null");
    }



    public class Node{

        int value ;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
