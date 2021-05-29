package com.company.BinarySearchTree;

public class ClosestDiff {

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

    public int closestdiff(int target){
        return closestdiff(root,target);
    }
    public int closestdiff(Node root, int target){

        int closest = 0;
        int diff = Integer.MAX_VALUE;

        Node temp = root;

        while(temp != null){
            int current_diff = Math.abs(temp.value - target);

            if(current_diff == 0){
                return temp.value;
            }

            if(current_diff < diff){
                diff = current_diff;
                closest = temp.value;
            }

            if(temp.value < target){

                temp =temp.right;

            } else {

                temp = temp.left;

            }
        }
        return closest;
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
