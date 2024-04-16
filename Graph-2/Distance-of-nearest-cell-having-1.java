class Solution
{
    class Pair
    {
        int i,j,pi,pj;
        Pair(int i,int j,int pi,int pj)
        {
            this.i=i;
            this.j=j;
            this.pi=pi;
            this.pj=pj;
        }
        
    }
    int m,n;
    public int[][] nearest(int[][] grid)
    {
        m=grid.length;
        n=grid[0].length;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    q.add(new Pair(i,j,i,j));
                    grid[i][j]=0;
                }
                else
                 grid[i][j]=Integer.MAX_VALUE;
            }
        }
        
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int x=p.i,y=p.j,pi=p.pi,pj=p.pj;
            
            for(int i=-1;i<=1;i++)
            {
             for(int j=-1;j<=1;j++)
             {
                int r=x+i,c=y+j;
                int cal=Math.abs(r-pi)+Math.abs(c-pj);
                if(r>=0 && r<m && c>=0 && c<n && (grid[r][c] > cal) )
                {
                  grid[r][c]=cal;
                  q.add(new Pair(r,c,pi,pj));
                }
                
             }
            }
        }
        return grid;
    }
    
}
