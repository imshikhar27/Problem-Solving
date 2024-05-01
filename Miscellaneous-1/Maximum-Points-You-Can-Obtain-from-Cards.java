class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int s=0;
        int a=0,b=0,sub=0,min=Integer.MAX_VALUE;
        for(int i=0;i<cardPoints.length;i++)
        {
         s+=cardPoints[i];
         sub+=cardPoints[i];
         if(i>=(cardPoints.length-k))
             sub-=cardPoints[a++]; 
         if(i>=(cardPoints.length-k-1))
          min=Math.min(min,sub);
        } 
        return s-min;
    }
}
