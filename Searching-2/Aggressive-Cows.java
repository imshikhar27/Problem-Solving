class Solution {
    public static int solve(int n, int k, int[] stalls) {
        int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        Arrays.sort(stalls);
        for(int i=0;i<stalls.length;i++)
        {
         max=Math.max(max,stalls[i]);
         min=Math.min(min,stalls[i]);
        }
        int s=1,e=(max-min);
        int ans=0;
        while(s<=e)
        {
            int m=(s+e)/2;
            if(valid(stalls,k,m))
            {
                ans=m;
                s=m+1;
            }
            else
             e=m-1;
        }
        return ans;
    }
     public static boolean valid(int[] s,int k,int m)
    {
        int dis=0;
        k--;
        for(int i=1;i<s.length;i++)
        {
            dis+=s[i]-s[i-1];
            if(dis>=m)
            {
                dis=0;
                k--;
            }
            if(k==0)
             return true;
        }
        return false;
    }
}
