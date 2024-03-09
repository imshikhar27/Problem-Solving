class Solution {
    public int singleNonDuplicate(int[] nums) {
        int s=0,e=nums.length-1;
        while(s<=e)
        {
            int m=(s+e)/2;
            if(m==0||m==nums.length-1)
             return nums[m];
            if(m%2==0)
            {
                if(nums[m]==nums[m+1])
                 s=m+1;
                else if(nums[m]==nums[m-1])
                 e=m-1;
                else
                 return nums[m];
            }
            else
            {
                if(nums[m]==nums[m-1])
                 s=m+1;
                else if(nums[m]==nums[m+1])
                 e=m-1;
                else
                 return nums[m];
            }
        }
        return -1;
    }
}
