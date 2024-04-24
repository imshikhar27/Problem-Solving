class Solution {
    class Pair
    {
        int dst;
        double wt;
        Pair(int n,double d)
        {
            this.dst=n;
            this.wt=d;
        }

    }
    class Node implements Comparable<Node>
    {
        int src;
        double Wt;
        Node(int s,double w)
        {
            this.src=s;
            this.Wt=w;
        }
        public int compareTo(Node n)
        {
            if(this.Wt<n.Wt)
             return 1;
            return -1;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
         adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0],v=edges[i][1];
            double prob=succProb[i];
            adj.get(u).add(new Pair(v,prob));
            adj.get(v).add(new Pair(u,prob));
        } 
        double[] prob=new double[n];
        prob[start_node]=1;
        PriorityQueue<Node> q=new PriorityQueue<>();
        q.add(new Node(start_node,1));
        while(!q.isEmpty())
        {
            Node par=q.poll();
            int src=par.src;double Wt=par.Wt;
            List<Pair> l=adj.get(src);
            for(Pair p:l)
            {
                int dst=p.dst;double wt=p.wt;
                double newProb=Wt*wt;
                if(prob[dst]<newProb)
                {
                    prob[dst]=newProb;
                    q.add(new Node(dst,newProb));
                }
            }
        }
        return prob[end_node];
    }
}
