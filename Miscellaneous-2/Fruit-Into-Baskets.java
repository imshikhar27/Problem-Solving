class Solution {
    public int totalFruit(int[] fruits) {
        int type1=-1,t1Start=-1,t1End=-1;
        int type2=-1,t2Start=-1,t2End=-1;
        int ans=-1;
        for(int i=0;i<fruits.length;i++)
        {
            int type=fruits[i];
            if(type1==-1 || type==type1)
            {
             if(t1Start==-1)
              t1Start=i;
             t1End=i;
             type1=type;
            }
            else if(type2==-1||type==type2)
            {
                if(t2Start==-1)
                 t2Start=i;
                t2End=i;
                type2=type;
            }
            else
            {
                ans=Math.max(ans,Math.max(t2End,t1End)-Math.min(t1Start,t2Start)+1);
                t1Start=Math.min(t1End,t2End)+1;
                t1End=Math.max(t1End,t2End);
                type1=fruits[t1Start];
                type2=type;
                t2Start=i;
                t2End=i;
            }
        }
        if(type2==-1)
         return fruits.length;
        return ans=Math.max(ans,Math.max(t2End,t1End)-Math.min(t1Start,t2Start)+1);
    }
}
