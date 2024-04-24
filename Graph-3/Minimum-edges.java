class Solution {
    static class Pair
    {
        int pos,cost;
        Pair(int d,int c)
        {
            this.pos=d;
            this.cost=c;
        }
    }
    public static int minimumEdgeReversal(int[][] edges, int n, int m, int src, int dst) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++)
         adj.add(new ArrayList<>());
        for(int[] e:edges)
        {
            adj.get(e[0]).add(new Pair(e[1],0));
            adj.get(e[1]).add(new Pair(e[0],1));
        }
        
        Deque<Pair> q=new ArrayDeque<>();
        q.addFirst(new Pair(src,0));
        int[] dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        
        while(!q.isEmpty())
        {
            Pair source=q.pollFirst();
            int pos=source.pos,Wt=source.cost;
            List<Pair> l=adj.get(pos);
            for(Pair dest:l)
            {
               int d=dest.pos,wt=dest.cost;
               if(dis[d]>dis[pos]+wt)
               {
                   dis[d]=dis[pos]+wt;
                   if(wt==0)
                    q.offerFirst(new Pair(d,wt));
                   else
                    q.offerLast(new Pair(d,wt));
               }
            }
        }
        return (dis[dst]==Integer.MAX_VALUE)?-1:dis[dst];
    }
}
        

