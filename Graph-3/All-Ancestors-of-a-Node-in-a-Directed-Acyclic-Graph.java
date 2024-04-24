class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Arrays.sort(edges,new Comparator<int[]>(){
            public int compare(int[] i,int[] j)
            {
                return i[0]-j[0];
            }
        });
        HashMap<Integer,Integer> adj=new HashMap<>();
        int[] indegree=new int[n];
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0],v=edges[i][1];
            if(!adj.containsKey(u))
             adj.put(u,i);
            indegree[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++)
         if(indegree[i]==0)
          q.add(i);
        List<TreeSet<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++)
          ans.add(new TreeSet<>());
        

        while(q.size()!=0)
        {
            int node=q.poll();
            int start=(!adj.containsKey(node))?edges.length:adj.get(node);
            while(start<edges.length && edges[start][0]==node)
            {
                int v=edges[start][1];
                indegree[v]--;
                ans.get(v).addAll(ans.get(node));
                ans.get(v).add(node);
                if(indegree[v]==0)
                 q.add(v);
                start++;
            }
        }

        List<List<Integer>> a=new ArrayList<>();
        for(TreeSet<Integer> t:ans)
         a.add(new ArrayList<>(t));
        return a;
    }
}
