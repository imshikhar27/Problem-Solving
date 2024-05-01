class Solution {
    long[] dp;
    public long mostPoints(int[][] questions) {
        dp=new long[questions.length];
        Arrays.fill(dp,-1);
        return mostPoints(questions,0);
    }
    public long mostPoints(int[][] ques,int ind)
    {
        if(ind>=ques.length)
         return 0;
        if(dp[ind]!=-1)
         return dp[ind];

        long notTake=mostPoints(ques,ind+1);
        long take=ques[ind][0]+mostPoints(ques,ind+ques[ind][1]+1);
        return dp[ind]=Math.max(notTake,take);
    }
}
