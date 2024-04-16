class Solution {
    int m,n;
    public void solve(char[][] board) {
        m=board.length;
        n=board[0].length;
        int[][] vis=new int[m][n];
        for(int i=0;i<n;i++)
        {
          if(board[0][i]=='O' && vis[0][i]==0)
           dfs(board,0,i,vis);
          if(board[m-1][i]=='O' && vis[m-1][i]==0)
           dfs(board,m-1,i,vis);
        }     
        for(int i=0;i<m;i++)
        {
          if(board[i][0]=='O' && vis[i][0]==0)
           dfs(board,i,0,vis);
          if(board[i][n-1]=='O' && vis[i][n-1]==0)
           dfs(board,i,n-1,vis);
        } 
       
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='O' && vis[i][j]==0)
                 board[i][j]='X';
            }
        }
    }
    public void dfs(char[][] board,int i,int j,int[][] vis)
    {
        vis[i][j]=1;
        if(i>0 && board[i-1][j]=='O' && vis[i-1][j]==0)
         dfs(board,i-1,j,vis);
        if(i<m-1 && board[i+1][j]=='O' && vis[i+1][j]==0)
         dfs(board,i+1,j,vis);
 
        if(j>0 && board[i][j-1]=='O' && vis[i][j-1]==0)
         dfs(board,i,j-1,vis);
        if(j<n-1 && board[i][j+1]=='O' && vis[i][j+1]==0)
         dfs(board,i,j+1,vis);
    }
}
