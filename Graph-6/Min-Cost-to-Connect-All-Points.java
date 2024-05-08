class Solution {
    class Node 
    {
        int wt,i,j;
        Node(int w,int i,int j)
        {
            this.wt=w;
            this.i=i;
            this.j=j;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        List<Node> pq=new ArrayList<>();
        int l=points.length;
        for(int i=0;i<l;i++)
        {
            for(int j=i+1;j<l;j++)
            {
                int dis=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                pq.add(new Node(dis,i,j));
            }
        }
        Collections.sort(pq,new Comparator<Node>(){
            public int compare(Node i,Node j)
            {
              return i.wt-j.wt;
            }
        });
        DSU dsu=new DSU(l);
        int cost=0;
        for(Node n:pq)
        {
            if(!dsu.union(n.i,n.j))
             cost+=n.wt;
        }
        return cost;
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
}
