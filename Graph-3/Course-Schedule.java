class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
         adj.add(new ArrayList<>());
        int[] indeg=new int[numCourses];
        for(int[] i:prerequisites)
        {
         (adj.get(i[0])).add(i[1]);
         indeg[i[1]]++;
        }
        int n=numCourses;
        Queue<Integer> q=new LinkedList<>();
        int count=0;
        for(int i=0;i<n;i++)
         if(indeg[i]==0)
         {
           q.add(i);
           count++;
         }
        while(q.size()!=0)
        {
            int i=q.remove();
            for(int j:adj.get(i))
            {
                indeg[j]--;
                if(indeg[j]==0)
                {
                 count++;
                 q.add(j);
                }
            }
        }
        return count==n;
    }
}
