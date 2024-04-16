class Solution {
    int m,n;
    public boolean hasValidPath(int[][] grid) {
        m=grid.length;n=grid[0].length;
        if(m==1&&n==1)
         return true;
        int[][] vis=new int[m][n];
        if(dfs(grid,vis,0,0,"",-1))
            return true;                 
        return false;
    }
    public boolean dfs(int[][] grid,int[][] vis,int i,int j,String ps,int prev)
    {
        if(i<0 || i>=m || j<0 || j>=n)
         return false;
        int gridVal=grid[i][j];
        if(!prevCheck(ps,prev,gridVal) && !(i==0 && j==0))
         return false;
        if(i==m-1 && j==n-1)
         return true;
        if(vis[i][j]==1)
         return false;
        vis[i][j]=1;
        if(grid[i][j]==1)
            return dfs(grid,vis,i,j-1,"L",gridVal)||dfs(grid,vis,i,j+1,"R",gridVal);
        else if(grid[i][j]==2)
            return dfs(grid,vis,i-1,j,"U",gridVal)||dfs(grid,vis,i+1,j,"D",gridVal);
        else if(grid[i][j]==3)
            return dfs(grid,vis,i,j-1,"L",gridVal)||dfs(grid,vis,i+1,j,"D",gridVal);
        else if(grid[i][j]==4)
            return dfs(grid,vis,i,j+1,"R",gridVal)||dfs(grid,vis,i+1,j,"D",gridVal);
        else if(grid[i][j]==5)
            return dfs(grid,vis,i,j-1,"L",gridVal)||dfs(grid,vis,i-1,j,"U",gridVal);
       // else if(grid[i][j]==6)
            return dfs(grid,vis,i,j+1,"R",gridVal)||dfs(grid,vis,i-1,j,"U",gridVal);
    }
    public boolean prevCheck(String ps,int prev,int gridVal)
    {
     if(prev==1)
     {
        if(ps.equals("L") && (gridVal==1||gridVal==4||gridVal==6))
         return true;
        else if(ps.equals("R") && (gridVal==1||gridVal==3||gridVal==5))
         return true;
     }
     else if(prev==2)
     {
        if(ps.equals("U") && (gridVal==3||gridVal==4||gridVal==2))
         return true;
        else if(ps.equals("D") && (gridVal==2||gridVal==5||gridVal==6))
         return true;
     }
     else if(prev==3)
     {
        if(ps.equals("L") && (gridVal==1||gridVal==4||gridVal==6))
         return true;
        else if(ps.equals("D") && (gridVal==2||gridVal==5||gridVal==6))
         return true;
     }
     else if(prev==4)
     {
        if(ps.equals("R") && (gridVal==1||gridVal==3||gridVal==5))
         return true;
        else if(ps.equals("D") && (gridVal==2||gridVal==5||gridVal==6))
         return true;
     }
     else if(prev==5)
     {
        if(ps.equals("L") && (gridVal==1||gridVal==4||gridVal==6))
         return true;
        else if(ps.equals("U") && (gridVal==2||gridVal==3||gridVal==4))
         return true;
     }
     else if(prev==6)
     {
        if(ps.equals("R") && (gridVal==1||gridVal==3||gridVal==5))
         return true;
        else if(ps.equals("U") && (gridVal==2||gridVal==3||gridVal==4))
         return true;
     }
     return false;
    }
}
