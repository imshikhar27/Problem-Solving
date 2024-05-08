class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int count=0;
        DSU alice=new DSU(n+1);
        DSU bob=new DSU(n+1);
        for(int type=3;type>=1;type--)
        {
         for(int[] i:edges)
         {
            if(type!=i[0])
             continue;
            int u=i[1],v=i[2];
            if(type==3)
            {
                boolean al=alice.union(u,v);
                boolean bo=bob.union(u,v);
                if(al&&bo)
                 count++;
            }
            else if(type==1 && alice.union(u,v))
             count++;
            else if(type==2 && bob.union(u,v))
             count++;
         }
        }
        
        return (alice.traversable() && bob.traversable())?count:-1;
    }
}
class DSU
{
    int[] size,parent;
    DSU(int n)
    {
        this.size=new int[n];
        this.parent=new int[n];
        for(int i=0;i<n;i++)
        {
            this.size[i]=0;
            this.parent[i]=i;
        }
    }
    public int findParent(int v)
    {
        if(this.parent[v]==v)
         return v;
        return this.parent[v]=this.findParent(this.parent[v]);
    }
    public boolean union(int u,int v)
    {
        int pu=this.findParent(u),pv=this.findParent(v);
        if(pu==pv)
         return true;
        
        if(this.size[pu]>=this.size[pv])
        {
            this.size[pu]+=this.size[pv];
            this.parent[pv]=pu;
        }
        else
        {
         this.size[pv]+=this.size[pu];
         this.parent[pu]=pv;
        }
        return false;
    }
    public boolean traversable()
    {
        int c=0;
        for(int i=1;i<this.parent.length;i++)
        {
            if(this.parent[i]==i)
             c++;
            if(c==2)
             return false;
        }
        return true;
    }
}
