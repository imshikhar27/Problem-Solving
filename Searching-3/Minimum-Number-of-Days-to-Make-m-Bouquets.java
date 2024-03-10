class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m>bloomDay.length/k)
         return -1;
        
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++)
        {
            min=Math.min(bloomDay[i],min);
            max=Math.max(bloomDay[i],max);
        }
        while(min<max)
        {
            int mid=min+(max-min)/2;
            if(get(mid,bloomDay,m,k))
             max=mid;
            else
             min=mid+1;
          
        } 
        return max;
    }
    public boolean get(int mid,int[] bloomDay,int m,int k)
    {
        int curr=0,flow=0;
        for(int i:bloomDay)
        {
         if(i<=mid)
          curr++;
         else
          curr=0;
         if(curr>=k)
         {
             flow++;
             curr=0;
         }
        }
        return flow>=m;
    }
}
