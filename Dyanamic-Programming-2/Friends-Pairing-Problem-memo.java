class Solution
{
    int m=1000000007;
    long[] dp;
    public long countFriendsPairings(int n) 
    { 
     dp=new long[n+1];
     Arrays.fill(dp,-1);
     dp[0]=0;
     dp[1]=1;
     dp[2]=2;
     dp[3]=4;
     return cal(n);
    }
    public long cal(int n)
    {
        if(dp[n]!=-1)
         return dp[n];
        
        long s=0;
        s+=cal(n-1);
        s%=m;
        for(int i=2;i<=n;i++)
        {
            s+=cal(n-2);
            s%=m;
        }
        return dp[n]=s;
    }
}    
