class Solution
{
    int m=1000000007;
    long[] dp;
    public long countFriendsPairings(int n) 
    { 
     dp=new long[n+1];
     dp[0]=1;
     dp[1]=1;
     for(int i=2;i<=n;i++)
     {
        long single=dp[i-1];
        long mingle=(i-1)*dp[i-2];
        dp[i]=(single+mingle)%m;
     }
     return dp[n];
    }
}   
