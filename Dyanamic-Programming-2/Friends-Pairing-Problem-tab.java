class Solution
{
    int m=1000000007;
    long[] dp;
    public long countFriendsPairings(int n) 
    { 
     dp=new long[n+1];
     dp[0]=0;
     dp[1]=1;
     dp[2]=2;
     dp[3]=4;
     
     int s=0;
     for(int i=4;i<=n;i++)
     {
         s=0;
         s+=dp[i-1];
         s%=m;
         for(int j=2;j<=i;j++)
         {
             s+=dp[i-2];
             s%=m;
         }
         dp[i]=s;
     }
     return dp[n];
    }
}    
 
