package com.company.BinarySearch;

public class kpartition {
    public static void main(String[] args) {
        int a[] = {1,2,3,4};
        int n  = (a.length*4)/4;
        int k = 4;
        System.out.println( k_partition(a,n,k));

    }

    public static int k_partition(int arr[],int n,int k) {
        int e = 0;
        int s = 0;
        for(int i=0;i<n;i++){
            e += arr[i];
        }
        //mid
        int mid;
        int ans=0;
        //search range (s,e)
        while(s<=e){
            mid = (s+e)/2;

            boolean isPossible = divideAmongK(arr,n,k,mid);

            if(isPossible){
                s = mid + 1;
                ans = mid;
            }
            else{
                e = mid - 1;
            }
        }
        return ans;

    }

    private static boolean divideAmongK(int[] arr, int n, int k, int limit) {
        //return true if every partition gets atleast limit no of coins

        int cnt = 0;
        int current_sum = 0;

        for(int i=0;i<n;i++){
            if(current_sum + arr[i] >=limit){
                cnt +=1;
                current_sum = 0;
            }
            else{
                current_sum += arr[i];
            }
        }

        return cnt>=k;

    }
}
