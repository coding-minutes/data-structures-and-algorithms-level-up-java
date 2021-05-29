package com.company.SortingandSearching;

import java.util.Scanner;

public class SparseSearch {

    public static int sparse_search(String[] a,int n,String key){

        // sparse search
        int s=0;
        int e = n-1;
        while(s<=e){
            int mid = (s+e)/2;
            int mid_left = mid - 1;
            int mid_right = mid + 1;
            if(a[mid].equals("")){
                while(true){
                    if(mid_left<s && mid_right>e){
                        return -1;
                    }
                else if(mid_right<=e && !a[mid_right].equals("")){
                        mid = mid_right;
                        break;
                    }
                else if(mid_left>=s && !a[mid_left].equals("")){
                        mid = mid_left;
                        break;
                    }
                    mid_left--;
                    mid_right++;
                }
            }
            if(a[mid].equals(key)){
                return mid;
            }
            else if(a[mid].compareTo(key)>0){
                e = mid - 1;
            }
            else{
                s = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner s= new Scanner(System.in);

        String[] arr = {"ai", "", "","bat", "","","car","cat","","","dog",""};

        int n = 12;

        String str = s.nextLine();

        System.out.println(sparse_search(arr,n,str));

    }
}
