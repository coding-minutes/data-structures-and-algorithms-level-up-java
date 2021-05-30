package com.company.Trie;

public class Xor_trie {
    class node{

        node left; //0
        node right; // 1
    };

    class trie{
        node root;

        trie(){
            root = new node();
        }

        public void insert(int n){
            //bits of that number in the trie
            node temp = root;
            for(int i=31;i>=0;i--){
                int bit = (n>>i)&1;
                if(bit==0){
                    if(temp.left==null){
                        temp.left = new node();
                    }
                    //go to that node
                    temp = temp.left;
                }
                else{
                    if(temp.right==null){
                        temp.right = new node();
                    }
                    temp = temp.right;
                }
            }
            //Insertion is Done
        }

        int max_xor_helper(int value){

            int current_ans = 0;
            node temp = root;

            for(int j=31;j>=0;j--){
                int bit =(value>>j)&1;

                if(bit==0){
                    //find the opp value
                    if(temp.right!=null){
                        temp = temp.right;
                        current_ans += (1<<j);
                    }
                    else{
                        temp = temp.left;
                    }
                }
                else{
                    //look for a zero
                    if(temp.left!=null){
                        temp = temp.left;
                        current_ans += (1<<j);
                    }
                    else{
                        temp = temp.right;
                    }
                }

            }
            return current_ans;

        }
        public int max_xor(int[] input,int n){

            int max_xor = 0;
            for(int i=0;i<n;i++){
                int value = input[i];
                insert(value);
                int current_xor = max_xor_helper(value);
                max_xor = Math.max(max_xor,current_xor);
            }

            return max_xor;
        }

    };
}
