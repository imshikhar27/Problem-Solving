class Solution {
    class Set implements Comparable<Set>
    {
        int i,j,diff;
        Set(int i,int j,int diff)
        {
         this.i=i;
         this.j=j;
         this.diff=diff;
        }
        public int compareTo(Set s)
        {
            if(this.diff<s.diff)
             return -1;
            if(this.diff==s.diff)
             return 1;
            return 1;
        }
    }
    int[] rd,cd;
    public int minimumEffortPath(int[][] heights) {
        rd=new int[]{-1,1,0,0};
        cd=new int[]{0,0,1,-1};
        PriorityQueue<Set> q=new PriorityQueue<>();
        int row=heights.length,col=heights[0].length;
        int[][] diff=new int[row][col];
        for(int[] d:diff)
         Arrays.fill(d,Integer.MAX_VALUE);
        diff[0][0]=0;
        q.add(new Set(0,0,0));
        while(!q.isEmpty())
        {
          Set s=q.poll();
          int ui=s.i,uj=s.j;
          for(int i=0;i<4;i++)
          {
            int vi=ui+rd[i],vj=uj+cd[i];
            if(vi>=0 && vi<row && vj>=0 && vj<col)
            {
             int val=heights[vi][vj];
             int dif=Math.max(Math.abs(heights[ui][uj]-val),s.diff);
             if(diff[vi][vj]>dif)
             {
                diff[vi][vj]=dif;
                q.add(new Set(vi,vj,dif));
             }
            }
          }
        }
        return diff[row-1][col-1];
    }
}
