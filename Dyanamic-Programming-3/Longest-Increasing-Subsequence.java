class Solution {
    List<Integer> sub;
    public int lengthOfLIS(int[] nums) {
        sub=new ArrayList<>();
        for(int n:nums)
        {
            if(sub.isEmpty() || sub.get(sub.size()-1)<n)
             sub.add(n);
            else
            {
             int lowerBound=lowerBound(sub,n);
             sub.set(lowerBound+1,n);
            }
        }
        return sub.size();
    }
    public int lowerBound(List<Integer> sub,int n)
    {
        int s=0,e=sub.size()-1,ans=-1;
        while(s<=e)
        {
            int m=s+(e-s)/2;
            if(sub.get(m)<n)
            {
                ans=m;
                s=m+1;
            }
            else
             e=m-1;
        }
        return ans;
    }
}
