class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        int n=colors.length();
        for(int i=0;i<n;i++)
         adj.add(new ArrayList<>());
        for(int[] e:edges)
         adj.get(e[0]).add(e[1]);
        int max=-1;
        int[][] freq=new int[n][26];
        int[] vis=new int[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
             max=Math.max(max,dfs(i,adj,freq,vis,colors));
        }
        return (max==(int)1e9)?-1:max;
    }
    public int dfs(int node,List<List<Integer>> adj,int[][] freq,int[] vis,String colors)
    {
        if(vis[node]==2)
         return (int)1e9;
        if(vis[node]==1)
         return 0;
        vis[node]=2;
        int max=1;
        int ans=1;
        List<Integer> l=adj.get(node);
        char ch=colors.charAt(node);
        freq[node][ch-'a']++;
        for(int dst:l)
        {
         if(dfs(dst,adj,freq,vis,colors)==(int)1e9)
          return (int)1e9;
         for(int i=0;i<26;i++)
         {
            int a=(i==ch-'a')?1:0;
            freq[node][i]=Math.max(freq[node][i],a+freq[dst][i]);
            max=Math.max(max,freq[node][i]);
         }
        }
        vis[node]=1;
        return max;
    }
}
