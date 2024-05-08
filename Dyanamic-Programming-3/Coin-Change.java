class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++)
        {
            for(int j=0;j<amount+1;j++)
            {
                dp[i][j]=-1;
            }
        }
        int ans=coin(coins,amount,coins.length-1,dp);
        return (ans==1e9)?-1:ans;
    }
    public int coin(int[] coins,int amount,int i,int[][] dp)
    {
     if(amount==0)
      return 0;
     if(i<0)
      return (int)1e9;
     if(dp[i][amount]!=-1)
      return dp[i][amount];
     int notTake=coin(coins,amount,i-1,dp);
     int take=Integer.MAX_VALUE;
     if(amount>=coins[i])
      take=1+coin(coins,amount-coins[i],i,dp);
     dp[i][amount]=Math.min(notTake,take);
     return dp[i][amount];
    }
}
