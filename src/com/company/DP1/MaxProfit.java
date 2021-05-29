package com.company.DP1;

public class MaxProfit {

    public static int max_profit(int prices[],int n){
        //base case
        if(n<=0){
            return 0;
        }

        //rec case
        int ans = Integer.MIN_VALUE;

        for(int i=0;i < n;i++){
            int cut = i + 1;

            int current_ans = prices[i] + max_profit(prices,n - cut);
            ans = Math.max(ans,current_ans);

        }
        return ans;
    }



    //bottom up solution
    public static int max_profit_dp(int[] prices,int n){

        int[] dp = new int[n+1];
        dp[0] = 0;


        for(int len=1;len<=n;len++){

            int ans = Integer.MIN_VALUE;
            for(int i=0;i<len;i++){
                int cut = i + 1;
                int current_ans = prices[i] + dp[len - cut];
                ans = Math.max(current_ans,ans);
            }
            //computed the ans for dp[len]
            dp[len] = ans;

        }

        return dp[n];
    }

}
