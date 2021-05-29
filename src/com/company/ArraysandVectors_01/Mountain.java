package com.company.ArraysandVectors_01;

public class Mountain {

    public static int highest_mountain(int[] a){
        int n = a.length;

        int largest = 0;

        for(int i=1;i<=n-2;){

            //check a[i] is peak or not
            if(a[i]>a[i-1] && a[i]>a[i+1]){
                //do some work
                int cnt = 1;
                int j = i;
                //cnt backwards (left)
                while(j>=1 && a[j]>a[j-1]){
                    j--;
                    cnt++;
                }
                //cnt forwards (right)
                while(i<=n-2 && a[i]>a[i+1]){
                    i++;
                    cnt++;
                }
                largest = Math.max(largest,cnt);

            }
		else{
                i++;
            }
        }
        return largest;

    }
}
