class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] cost=new int[n][n];
        for(int[] c:cost)
         Arrays.fill(c,1000000000);
        for(int[] e:edges)
        {
          cost[e[0]][e[1]]=e[2];
          cost[e[1]][e[0]]=e[2];
        }
        for(int i=0;i<n;i++)
         cost[i][i]=0;
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    cost[i][j]=Math.min(cost[i][j],cost[i][k]+cost[k][j]);
                }
            }
        }
        int ansCount=n+1,ans=0;
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=0;j<n;j++)
            {
                if(cost[i][j]<=distanceThreshold)
                 count++;
            }
            if(ansCount>=count)
            {
                ansCount=count;
                ans=i;
            }
        }
        return ans;
    }
}
