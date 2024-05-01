class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu=new DSU(edges.length+1);
        for(int[] ed:edges)
        {
            int u=ed[0],v=ed[1];
            int pu=dsu.findParent(u),pv=dsu.findParent(v);
            if(pu==pv)
             return ed;
            dsu.union(u,v);
        }
        return new int[0];
    }
}
class DSU
{
    int[] rank,parent;
    DSU(int n)
    {
        rank=new int[n];
        parent=new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
            rank[i]=1;
        }
    }
    public int findParent(int node)
    {
        if(parent[node]==node)
         return node;
        return parent[node]=findParent(parent[node]);
    }
    public void union(int u,int v)
    {
        int pu=findParent(u);
        int pv=findParent(v);

        if(pu==pv)
         return;
        if(rank[pu]>=rank[pv])
        {
         if(rank[pu]==rank[pv])
          rank[pu]++;
         parent[pv]=pu;
        }
        else
         parent[pu]=pv;
    }
}
