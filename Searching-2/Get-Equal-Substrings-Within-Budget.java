class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] cost=new int[s.length()];
        for(int i=0;i<s.length();i++)
        {
            char c1=s.charAt(i),c2=t.charAt(i);
            cost[i]=Math.abs(c1-c2);
        }
        int st=0,e=s.length(),ans=0;
        while(st<=e)
        {
            int m=(st+e)/2;
            if(valid(cost,m,maxCost))
            {
                ans=m;
                st=m+1;
            }
            else
             e=m-1;
        }
        return ans;
    }
    public boolean valid(int[] cost,int m,int maxCost)
    {
        int i=0,j=0,curr=0;
        while(j<cost.length)
        {
         curr+=cost[j];
         while(curr>maxCost)
         {
            curr-=cost[i];
            i++;
         }
         if((j-i+1)>=m)
          return true;
         j++;
        }
        return false;
    }
}
