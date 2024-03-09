class Solution
{
    public int NthRoot(int n, int m)
    {
        // code here
        int s=1,e=m;
        int ans=-1;
        while(s<=e)
        {
            int mid=(s+e)/2;
            int cal=(int)Math.pow(mid,n);
            if(cal==m)
                ans=(int)mid;
            if(cal<m)
             s=mid+1;
            else
             e=mid-1;
        }
        return ans;
    }
}
