class Solution {
    class Pair
    {
        int i,j;
        Pair(int i,int j)
        {
            this.i=i;
            this.j=j;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                 q.add(new Pair(i,j));
                else if(grid[i][j]==1)
                 fresh++;
            }
        }
        if(fresh==0)
         return 0;
        return count(grid,q,fresh);
    }
    public int count(int[][] grid,Queue<Pair> q,int fresh)
    {
      int m=grid.length,n=grid[0].length;
      int[][] vis=new int[m][n];
      int t=-1;
      int[] rd=new int[]{1,-1,0,0};
      int[] cd=new int[]{0,0,-1,1};
      while(q.size()!=0)
      {
          int l=q.size();
          for(int k=0;k<l;k++)
          {
              Pair p=q.remove();
              int i=p.i;
              int j=p.j;
              grid[i][j]=2;
              vis[i][j]=1;
              for(int x=0;x<4;x++)
              {
                int r=i+rd[x],c=j+cd[x];
                if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==1 && vis[r][c]!=1)
                {
                    q.add(new Pair(r,c));
                    vis[r][c]=1;
                    fresh--;
                }
              }
          }
          t++;
      }
      return (fresh==0)?t:-1;
    }
}
