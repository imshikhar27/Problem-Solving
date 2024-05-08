class Solution {
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int curr=1;
        int e=0;
        while(e<nums.length)
        {
            curr*=nums[e];
            if(curr>max)
             max=curr;
            if(curr==0)
             curr=1;
            e++;
        }
        e=nums.length-1;
        curr=1;
        while(e>-1)
        {
            curr*=nums[e];
            if(curr>max)
             max=curr;
            if(curr==0)
             curr=1;
            e--;
        }
        return max;
    }
}
