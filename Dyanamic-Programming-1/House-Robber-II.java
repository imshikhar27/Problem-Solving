class Solution {
    int[][] dp;
    public int rob(int[] nums) {
        dp=new int[2][nums.length];
        Arrays.fill(dp[0],-1);
        Arrays.fill(dp[1],-1);
        return rob(nums,nums.length-1,0);
    }
    public int rob(int[] nums,int ind,int last)
    {
        if(ind==0)
        {
            if(last==1)
             return 0;
            return nums[ind];
        }
        if(ind<0)
         return 0;
        if(dp[last][ind]!=-1)
         return dp[last][ind];
    
        int notTake=rob(nums,ind-1,last);
        last=(ind==nums.length-1)?1:last;
        int take=nums[ind]+rob(nums,ind-2,last);
        return dp[last][ind]=Math.max(notTake,take);
    }
}
