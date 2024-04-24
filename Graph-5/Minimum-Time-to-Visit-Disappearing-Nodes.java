class Solution {
    class Node
    {
     int dst,time,disapp;
     Node(int d,int l,int dis){
        this.dst=d;
        this.time=l;
        this.disapp=dis;
     }
    }
    class Pair implements Comparable<Pair>
    {
        int src,time;
        Pair(int s,int t)
        {
            this.src=s;
            this.time=t;
        }
        public int compareTo(Pair p)
        {
            return this.time-p.time;
        }
    }
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<List<Node>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
         adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0],v=edges[i][1],len=edges[i][2];
            adj.get(u).add(new Node(v,len,disappear[v]));
            adj.get(v).add(new Node(u,len,disappear[u]));
        }
        int[] dis=new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0;
        int[] vis=new int[n];
        PriorityQueue<Pair> q=new PriorityQueue<>();
        q.add(new Pair(0,0));
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int src=p.src,time=p.time;
            if(vis[src]==1)
             continue;
            vis[src]=1;
            List<Node> l=adj.get(src);
            for(Node nd:l)
            {
                int dst=nd.dst,t=nd.time,disap=nd.disapp;
                if(dis[dst]>time+t && time+t<disap)
                {
                    dis[dst]=time+t;
                    q.add(new Pair(dst,time+t));
                }
            }
        }
        for(int i=0;i<dis.length;i++)
         if(dis[i]==Integer.MAX_VALUE)
          dis[i]=-1;
        return dis;
    }
}
