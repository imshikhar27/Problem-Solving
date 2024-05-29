class Solution {
    int[][] dp;
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        dp=new int[nums.size()][target+1];
        for(int[] d:dp)
         Arrays.fill(d,-1001);
        int x=find(0,nums,target);
        return (x>0)?x:-1;
    }
    public int find(int ind,List<Integer> nums,int target)
    {
        if(ind==nums.size())
        {
            if(target==0)
             return 0;
            return Integer.MIN_VALUE;
        }
        if(dp[ind][target]!=-1001)
        return dp[ind][target];
        int pick=Integer.MIN_VALUE,notpick=Integer.MIN_VALUE;
        if(target>=nums.get(ind))
         pick=1+find(ind+1,nums,target-nums.get(ind));
        notpick=find(ind+1,nums,target);
        return dp[ind][target]=Math.max(pick,notpick);
    }
}
