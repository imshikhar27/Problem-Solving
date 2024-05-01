class Solution {
    int[][] dp;
    int m;
    public int numRollsToTarget(int n, int k, int target) {
        dp=new int[n+1][target+1];
        m=1000000007;
        for(int[] d:dp)
         Arrays.fill(d,-1);
        return roll(n,k,target);
    }
    public int roll(int n,int k,int tar)
    {
        if(n==0)
        {
            if(tar==0)
             return 1;
            return 0;
        }
        if(tar<=0)
         return 0;
        if(dp[n][tar]!=-1)
         return dp[n][tar];
        int ways=0;
        for(int i=1;i<=k;i++)
        {
         ways+=roll(n-1,k,tar-i);
         ways%=m;
        }
        return dp[n][tar]=ways;
    }
}
