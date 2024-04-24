class Solution {
    int[] vis;
    public boolean isBipartite(int[][] graph) {
        vis=new int[graph.length];
        Arrays.fill(vis,-1);
        for(int i=0;i<vis.length;i++)
        {
            if(vis[i]==-1)
            {
              if(!is(graph,i,0))
               return false;
            }
             
        }
        return true;
    }
    public boolean is(int[][] graph,int i,int flag)
    {
     vis[i]=flag;
     for(int x=0;x<graph[i].length;x++)
     {
         int n=graph[i][x];
          if(vis[n]==-1)
          {
           if(!is(graph,n,(flag+1)%2))
            return false;
          }
          else
          {
           if(flag==1 && vis[n]==1)
            return false;
           else if(flag==0 && vis[n]==0)
            return false;
          }
     }
     return true;
    }
}
