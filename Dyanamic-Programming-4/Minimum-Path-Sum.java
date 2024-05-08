class Solution {
    public int minPathSum(int[][] grid) {
     int m=grid.length,n=grid[0].length;
     int[][] p=new int[m][n];
     p[0][0]=grid[0][0];
     for(int i=0;i<m;i++)
     {
         for(int j=0;j<n;j++)
         {
             p[i][j]=grid[i][j];
             int min=Integer.MAX_VALUE;
             if(i==0 && j==0)
              min=0;
             if(i>0)
              min=p[i-1][j];
             if(j>0)
              min=Math.min(min,p[i][j-1]);
             p[i][j]+=min;
         }
     }   

     return p[m-1][n-1];
    }
}
