class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ways=new int[m][n];
        ways[m-1][n-1]=1;
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
             if(j-1>=0)
              ways[i][j-1]+=ways[i][j];
             if(i-1>=0)
              ways[i-1][j]+=ways[i][j];
            }
        }
        return ways[0][0];
    }
}
