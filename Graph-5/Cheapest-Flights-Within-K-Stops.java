class Solution {
    class Node 
    {
        int pos,price,k;
        Node(int p,int pr,int k)
        {
            this.pos=p;
            this.price=pr;
            this.k=k;
        }
    }
    class Pair
    {
        int dest,price;
        Pair(int d,int p)
        {
            this.dest=d;
            this.price=p;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
         adj.add(new ArrayList<>());
        for(int[] i:flights)
            adj.get(i[0]).add(new Pair(i[1],i[2]));
        Queue<Node> q=new LinkedList<>();
        q.add(new Node(src,0,0));
        int[] dis=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        while(!q.isEmpty())
        {
            Node node=q.poll();
            int prevSrc=node.pos,prevCost=node.price,stop=node.k;
            if(stop>k || prevSrc==dst)
                 continue;
            List<Pair> arr=adj.get(prevSrc);
            for(Pair p:arr)
            {
                int newDest=p.dest,cost=p.price;
                if(dis[newDest]>=prevCost+cost)
                {
                    dis[newDest]=prevCost+cost;
                    q.add(new Node(newDest,prevCost+cost,stop+1));
                }
            }
        } 
        return dis[dst]==Integer.MAX_VALUE?-1:dis[dst];
    }
}
