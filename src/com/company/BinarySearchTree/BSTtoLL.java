package com.company.BinarySearchTree;

public class BSTtoLL {

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

    class CustomLL{

        Node head;
        Node tail;
    }

    public CustomLL treetoLL(Node node){;

        CustomLL l1 = new CustomLL();

        if(node==null){
            l1.head=l1.tail=null;
            return l1;
        }

        if(node.left == null && node.right == null){
            l1.head = l1.tail = node;

        } else if (node.left !=null && node.right == null) {
            CustomLL leftLL = treetoLL(node.left);
            leftLL.tail.right = node;

            l1.head = leftLL.head;
            l1.tail = node;

        } else if(node.left == null && node.right !=null){
            CustomLL rightLL = treetoLL(node.right);
            node.right = rightLL.head;

            l1.head = node;
            l1.tail = rightLL.tail;
        } else {

            CustomLL leftLL = treetoLL(node.left);
            CustomLL rightLL = treetoLL(node.right);
            leftLL.tail.right = node;
            node.right = rightLL.head;

            l1.head = leftLL.head;
            l1.tail = rightLL.tail;
        }
        return l1;
    }

    public void display(){

        CustomLL ll =treetoLL(root);

        Node temp = ll.head;

        while(temp!=null){
        System.out.println(temp.value);
        temp = temp.right;
    }}


    class Node {

        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }


}
