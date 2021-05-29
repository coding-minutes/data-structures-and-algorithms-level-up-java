package com.company.SortingandSearching;

import java.util.Vector;

public class inversion_count {

    public static int merge(Vector<Integer> array, int s, int e){
        int i = s;
        int m = (s+e)/2;
        int j = m + 1;

        Vector<Integer> temp = new Vector<>();

        int cnt = 0;

        while(i<=m && j<=e){
            if(array.get(i) < array.get(j)){
                temp.add(array.get(i));
                i++;
            }
            else{
                cnt += (m - i + 1);
                temp.add(array.get(j));
                j++;
            }
        }

        //copy rem elements from first array
        while(i<=m){
            temp.add(array.get(i++));
        }

        // or copy rem elements from second array
        while(j<=e){
            temp.add(array.get(j++));
        }

        //copy back the eleemtns from temp to original array
        int k = 0 ;
        for(int idx = s; idx <=e ;idx++){
            array.set(idx, temp.get(k++));
        }
        return cnt;
    }

    public static int inversion_count(Vector<Integer> arr,int s,int e){
        //base case
        if(s>=e){
            return 0;
        }
        //rec case
        int mid = (s+e)/2;
        int C1 = inversion_count(arr,s,mid);
        int C2 = inversion_count(arr,mid+1,e);
        int CI =  merge(arr,s,e);
        return C1 + C2 + CI;
    }

    public static void main(String[] args) {

        Vector<Integer> arr= new Vector<>();

        arr.add(5);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);

        int s = 0;
        int e = arr.size()-1;
        System.out.println(inversion_count(arr,s,e));
    }
}
