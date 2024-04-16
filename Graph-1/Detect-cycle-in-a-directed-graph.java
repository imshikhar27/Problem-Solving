class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] vis=new int[V];
        for(int i=0;i<adj.size();i++)
        {
            if(vis[i]==0)
            {
                boolean cycle=dfs(adj,vis,i);
                if(cycle)
                 return true;
            }
        }
        return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int[] vis,int source)
    {
        if(vis[source]==2)
         return true;
        if(vis[source]==1)
         return false;
        vis[source]=2;
        
        ArrayList<Integer> l=adj.get(source);
        for(int i=0;i<l.size();i++)
        {
            boolean cycle=dfs(adj,vis,l.get(i));
            if(cycle)
             return true;
        }
        vis[source]=1;
        return false;
    }
}
