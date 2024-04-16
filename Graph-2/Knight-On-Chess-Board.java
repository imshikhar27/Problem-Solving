public class Solution {
    class Pair{
        int i,j;
        Pair(int i,int j)
        {
            this.i=i;
            this.j=j;
        }
    }
    public int knight(int A, int B, int C, int D, int E, int F) {
        int m=A,n=B,x=E,y=F;
        if(C==x && D==y)
         return 0;
        int[][] vis=new int[m+1][n+1];
        
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(C,D));
        
        vis[C][D]=1;
        int[] rd=new int[]{-2,-2,-1,+1,-1,+1,+2,+2};
        int[] cd=new int[]{-1,+1,-2,-2,+2,+2,-1,+1};
        int step=0;
        while(!q.isEmpty())
        {
            int l=q.size();
            for(int k=0;k<l;k++)
            {
             Pair p=q.poll();
             int i=p.i,j=p.j;
             for(int s=0;s<8;s++)
             {
                 int r=i+rd[s],c=j+cd[s];
                 if(r>=1 && r<=m && c>=1 && c<=n && vis[r][c]==0)
                 {
                  if(r==x && c==y)
                   return step+1;
                  q.add(new Pair(r,c));
                  vis[r][c]=1;
                 }
             }
             
            }
            step++;
        }
        return -1;
    }
}

