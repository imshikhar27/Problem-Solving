class Solution{
    static int maxSum(int N, int mat[][])
    {
        int[] dp=new int[N];
        Arrays.fill(dp,-1);
        return maxSum(N,mat,dp);
    }
    static int maxSum(int N, int mat[][],int[] dp)
    {
        if(N<=0)
         return 0;
        if(dp[N-1]!=-1)
         return dp[N-1];
        int a=mat[0][N-1]+maxSum(N-2,mat,dp);
        int b=mat[1][N-1]+maxSum(N-2,mat,dp);
        int c=maxSum(N-1,mat,dp);
        return dp[N-1]=Math.max(a,Math.max(b,c));
    }
    
}
