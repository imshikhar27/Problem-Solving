class Solution {
    int[] dp;
    public int jump(int[] nums) {
        int n=nums.length;
        dp=new int[n];
        dp[n-1]=0;
        for(int i=nums.length-2;i>=0;i--)
        {
            int min=Integer.MAX_VALUE;
            int step=nums[i];
            for(int j=1;j<=step;j++)
            {
                if(i+j>=nums.length)
                 break;
                min=Math.min(min,dp[i+j]);
            }
            dp[i]=1+((min==Integer.MAX_VALUE)?(int)1e9:min);
        }
        return dp[0];
    }
}
