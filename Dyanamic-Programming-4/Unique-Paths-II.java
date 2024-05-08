class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
     int[][] p=new int[m][n];
     p[0][0]=1;
     for(int i=0;i<m;i++)
     {
         for(int j=0;j<n;j++)
         {
             if(obstacleGrid[i][j]==1)
             {
                 p[i][j]=0;
             }
             else
             {
                 if(i>0)
                  p[i][j]+=p[i-1][j];
                 if(j>0)
                  p[i][j]+=p[i][j-1];
             }
         }
     }   
     return p[m-1][n-1];
    }
}
