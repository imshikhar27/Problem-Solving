class Solution {
    class Pair implements Comparable<Pair>
    {
        int prev,cost;
        Pair(int p,int c)
        {
            this.prev=p;
            this.cost=c;
        }
        public int compareTo(Pair p)
        {
            if(this.cost<p.cost)
             return -1;
            return 1;
        }
    }
    class Node
    {
        int dest,time;
        Node(int d,int t)
        {
            this.dest=d;
            this.time=t;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++)
         adj.add(new ArrayList<>());
        for(int[] i:times)
         adj.get(i[0]).add(new Node(i[1],i[2]));
        int[] dis=new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[k]=0;
        PriorityQueue<Pair> q=new PriorityQueue<>();
        q.add(new Pair(k,0));  
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int prevSrc=p.prev,prevCost=p.cost;
            List<Node> l=adj.get(prevSrc);
            for(Node no:l)
            {
                int dest=no.dest,time=no.time;
                if(dis[dest]>prevCost+time)
                {
                    dis[dest]=prevCost+time;
                    q.add(new Pair(dest,prevCost+time));
                    
                }
            }

        }
        int ans=0;
        for(int i=1;i<dis.length;i++)
         ans=Math.max(ans,dis[i]);
         return ans==Integer.MAX_VALUE?-1:ans;
    }
}
