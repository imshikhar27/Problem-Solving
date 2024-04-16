class Solution {
    public int findCircleNum(int[][] isConnected) {
        int start=0,c=0;
        int[] vis=new int[isConnected.length];
            for(int i=0;i<isConnected.length;i++)
            {
              if(vis[i]==0)
              {
               c++;
               dfs(isConnected,i,vis);
              } 
            }
            
        return c;
    }
    public void dfs(int[][] c,int ele,int[] vis)
    {
        vis[ele]=1;
        for(int i=0;i<c[0].length;i++)
        {
            if(c[ele][i]==1 && vis[i]==0)
            {
                dfs(c,i,vis);
            }
        }
    }
}
