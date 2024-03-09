class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
         return 0;
        int s=0,e=nums.length-1;
        while(s<=e)
        {
            int m=(s+e)/2;
            int pre=(m==0)?Integer.MIN_VALUE:nums[m-1];
            int next=(m==nums.length-1)?Integer.MIN_VALUE:nums[m+1];
            if(pre<nums[m] &&  nums[m]>next)
             return m;
            if(pre<nums[m] && nums[m]<next)
             s=m+1;
            else if(pre>nums[m] && nums[m]>next)
             e=m-1;
            else
             s=m+1;
        }
        return -1;
    }
}
