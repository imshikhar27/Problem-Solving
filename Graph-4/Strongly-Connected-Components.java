class Solution
{
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> st=new Stack<>();
        int[] vis=new int[V];
        for(int i=0;i<V;i++)
         if(vis[i]==0) 
          dfs(i,adj,st,vis);
        
        ArrayList<ArrayList<Integer>> rev=new ArrayList<>();
        for(int i=0;i<V;i++)
         rev.add(new ArrayList<>());
        for(int i=0;i<V;i++)
        {
            ArrayList<Integer> aj=adj.get(i);
            for(int j:aj)
            {
                rev.get(j).add(i);
            }
        }
        
        int c=0;
        while(!st.isEmpty())
        {
            int i=st.pop();
            if(vis[i]==1)
            {
                c++;
                dfs1(i,vis,rev);
            }
        }
        return c;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st,int[] vis)
    {
        if(vis[node]==1)
         return;
        vis[node]=1;
        ArrayList<Integer> l=adj.get(node);
        for(int v:l)
         dfs(v,adj,st,vis);
        st.push(node);
    }
    public void dfs1(int node,int[] vis,ArrayList<ArrayList<Integer>> adj)
    {
        if(vis[node]==0)
         return;
        vis[node]=0;
        ArrayList<Integer> a=adj.get(node);
        for(int i:a)
         dfs1(i,vis,adj);
    }
}

