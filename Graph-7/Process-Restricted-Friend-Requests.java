class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        DSU dsu=new DSU(n+1);
        boolean[] ans=new boolean[requests.length];
        for(int i=0;i<requests.length;i++)
        {
            int u=requests[i][0],v=requests[i][1];
            if(dsu.checkRestriction(restrictions,u,v))
            {
             dsu.union(u,v);
             ans[i]=true;
            } 
        }
        return ans;
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
         return false;
        
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
        return true;
    }
    public boolean checkRestriction(int[][] rest,int u,int v)
    {
        int pu=this.findParent(u),pv=this.findParent(v);
        for(int[] r:rest)
        {
            int pru=this.findParent(r[0]),prv=this.findParent(r[1]);
            if((pru==pu && prv==pv) || (pru==pv&&prv==pu))
             return false;
        }
        return true;
    }
}
