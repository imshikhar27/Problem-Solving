class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> ls=new ArrayList<>();
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++)
         ls.add(new ArrayList<>());
        for(int[] i:edges)
        {
          ls.get(i[0]).add(i[1]);
          ls.get(i[1]).add(i[0]);
        }
        int[] vis=new int[n];
        return dfs(ls,vis,source,destination,dp);
    }
    public boolean dfs(List<List<Integer>> ls,int[] vis,int source,int destination,int[] dp)
    {
        if(source==destination)
         return true;
        if(dp[source]!=-1)
         return dp[source]==1?true:false;
        vis[source]=1;
        List<Integer> l=ls.get(source);
        for(int i=0;i<l.size();i++)
        {
            if(vis[l.get(i)]!=1 && dfs(ls,vis,l.get(i),destination,dp))
            {
             dp[source]=1;
             return true;
            }
        }
        vis[source]=0;
        dp[source]=0;
        return false;
    }
}
