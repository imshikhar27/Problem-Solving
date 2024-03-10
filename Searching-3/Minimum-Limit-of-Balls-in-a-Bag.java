class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int s=1,e=-1;
        for(int i:nums)
         e=Math.max(e,i);
        while(s<e)
        {
            int m=s+(e-s)/2;
            if(valid(nums,m,maxOperations))
             e=m;
            else
             s=m+1;
        }
        return e;
    }
    public boolean valid(int[] nums,int mid,int maxOp)
    {
        for(int i:nums)
        {
            int t=i;
            if(t%mid==0)
             maxOp-=(t/mid)-1;
            else
             maxOp-=(t/mid);
            if(maxOp<0)
                return false;
        
        }
        return true;
    }
}
