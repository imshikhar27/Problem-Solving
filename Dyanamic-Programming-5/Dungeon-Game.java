class Solution {
    int[][] dp;
    public int calculateMinimumHP(int[][] dungeon) {
        dp=new int[dungeon.length][dungeon[0].length];
        for(int[] i:dp)
         Arrays.fill(i,-1);
        return cal(dungeon,0,0)+1;
    }
    public int cal(int[][] d,int i,int j)
    {   
        if(i>=d.length || j>=d[0].length)
         return (int)1e9;
        if( i==d.length-1 && j==d[0].length-1)
         return (d[i][j]>=0)?0:-d[i][j];
        if(dp[i][j]!=-1)
         return dp[i][j];

        int right=cal(d,i,j+1);
        int down=cal(d,i+1,j);
        int req=Math.min(right,down);
        if(d[i][j]>=req)
         return dp[i][j]=0;
        else if(d[i][j]>=0)
         return dp[i][j]=req-d[i][j];
        return dp[i][j]=-d[i][j]+req;
    } 
}
