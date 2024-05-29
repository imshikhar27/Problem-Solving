class Solution {
    class Pair 
    {
        int ind,par;
        Pair(int ind,int par)
        {
            this.ind=ind;
            this.par=par;
        }
    }
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> edge=adj(edges,n);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            ans=Math.min(bfs(edge,i),ans);
        }
        return (ans==Integer.MAX_VALUE)?-1:ans;
    }
    public int bfs(List<List<Integer>> edge,int ind)
    {
        int ans=Integer.MAX_VALUE;
        Queue<Pair> q=new LinkedList<>();
        int n=edge.size();
        int[] vis=new int[n];
        int[] dist=new int[n];
        q.add(new Pair(ind,-1));
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int e=p.ind,par=p.par;
            if(vis[e]==1)
            {
             ans=Math.min(dist[par]+1+dist[e],ans);
             continue;
            }
            vis[e]=1;
            if(par!=-1)
            dist[e]=dist[par]+1;
            List<Integer> ls=edge.get(e);
            for(int e1:ls)
            {
             if(e1==par)
              continue;
             q.add(new Pair(e1,e));
            }
        }
        return ans;
    }
    public List<List<Integer>> adj(int[][] edges,int n)
    {
        List<List<Integer>> edge=new ArrayList<>();
        for(int i=0;i<n;i++)
         edge.add(new ArrayList<>());
        for(int[] i:edges)
        {
            edge.get(i[0]).add(i[1]);
            edge.get(i[1]).add(i[0]);
        }
        return edge;
    }  
}
