class Solution {
    int[][] dp;
    public int minPathCost(int[][] grid, int[][] moveCost) {
        dp=new int[grid.length][grid[0].length];
        int ans=Integer.MAX_VALUE;
        for(int j=0;j<grid[0].length;j++)
         ans=Math.min(ans,find(0,j,grid,moveCost));

        return ans;
    }
    public int find(int i,int j,int[][] grid,int[][] moveCost)
    {
        if(grid.length==i)
         return 0;
        if(dp[i][j]!=0)
         return dp[i][j];
        int ans=Integer.MAX_VALUE;
        int val=grid[i][j];
        for(int j1=0;j1<grid[0].length;j1++)
        {
            int mv=(i==grid.length-1)?0:moveCost[val][j1];
            ans=Math.min(ans,val+mv+find(i+1,j1,grid,moveCost));
        }
        return dp[i][j]=ans;
    }
}
