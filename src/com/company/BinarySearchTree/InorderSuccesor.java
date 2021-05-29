package com.company.BinarySearchTree;

public class InorderSuccesor {

    Node root;

    public void insert(int value){

        this.root = insert(root, value);

    }

    private Node insert(Node node, int value) {

        if(node == null){
            return new Node(value);
        }

        if(node.value>value){
            node.left =insert(node.left, value);
        }

        else{
            node.right= insert(node.right, value);
        }

        return node;
    }


    public void display(){

        display(root, "");
    }

    private void display(Node node, String indent) {

        if(node == null){
            return;
        }

        System.out.println(indent+node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }


    public int successor(int value){

        Node success = null;

        Node current = root;


        while(current!=null){


            if(current.value>value){

                success = current;
                current=current.left;
            }

            else{
                current = current.right;
            }
        }

        if(success == null){
            return -1;
        }

        else {
            return success.value;
        }
    }

    class Node {

        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
