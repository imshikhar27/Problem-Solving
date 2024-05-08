class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int s=0,e=Math.max(houses[houses.length-1],heaters[heaters.length-1]);
        int ans=0;
        while(s<=e)
        {
            int r=s+(e-s)/2;

            if(check(heaters,houses,r))
            {
                ans=r;
                e=r-1;
            }
            else
             s=r+1;
        }
        return ans;
    }
    public boolean check(int[] heaters,int[] houses,int rad)
    {
        int i=0,j=0;
        while(i<heaters.length)
        {
         int heat=heaters[i];
         while(j<houses.length)
         {
          int house=houses[j];
          if(house<heat && house+rad<heat)
           break;
          else if(house>heat && house-rad>heat)
           break;
          j++;
         }
         i++;
        }
        if(j==houses.length)
         return true;
        return false;
    }
}
