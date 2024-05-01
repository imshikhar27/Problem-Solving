class Solution {
     int[] dp;
    public int climbStairs(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return cal(n);
    }
    public int cal(int n)
    {
        if(n<0)
         return 0;
        if(n==0)
         return 1;
        if(dp[n]!=-1)
         return dp[n];
        return dp[n]=cal(n-1)+cal(n-2);
    }
}
