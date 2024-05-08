class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length+1][amount+1];

        for(int i=0;i<coins.length+1;i++)
         dp[i][0]=1;

        for(int i=1;i<coins.length+1;i++)
        {
            for(int j=1;j<amount+1;j++)
            {
               int notTake=dp[i-1][j];
               int take=0;
               if(j>=coins[i-1])
                take=dp[i][j-coins[i-1]];
               dp[i][j]=notTake+take;
            }
        }
        return dp[coins.length][amount];
    }
}
