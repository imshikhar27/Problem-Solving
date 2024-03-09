class Solution {
    public int mySqrt(int x) {
       int s=0,e=x;
       int ans=0;
       while(s<=e)
       {
        int m=(s+e)/2;
        if((long)m*m<=x)
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
