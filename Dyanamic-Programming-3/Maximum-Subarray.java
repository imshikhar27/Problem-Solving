class Solution {
    public int maxSubArray(int[] nums) {
        int s=0,ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            s+=nums[i];
            ans=Math.max(s,ans);
            if(s<0)
             s=0;
        }
        return ans;
    }
}
