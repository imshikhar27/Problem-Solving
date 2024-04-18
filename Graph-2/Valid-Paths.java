public class Solution {
    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        int[][] vis=new int[A+1][B+1];
        return (dfs(0,0,vis,D,E,F,A,B)==true)?"YES":"NO"; 
    }
    public boolean dfs(int x,int y,int[][] vis,int r,ArrayList<Integer> X,ArrayList<Integer> Y,int A,int B)
    {
        if(x<0 || y<0 || x>=vis.length || y>=vis[0].length)
         return false;
        if(vis[x][y]==1 || insideCircle(x,y,X,Y,r))
         return false;
        if(x==A && y==B)
         return true;
        
        vis[x][y]=1;
        for(int i=-1;i<=1;i++)
        {
            for(int j=-1;j<=1;j++)
            {
                int nr=x+i,nc=y+j;
                if(dfs(nr,nc,vis,r,X,Y,A,B))
                 return true;
            }
        }
        return false;
    }
    public boolean insideCircle(int x,int y,ArrayList<Integer> X,ArrayList<Integer> Y,int r)
    {
        for(int i=0;i<X.size();i++)
        {
            int cx=X.get(i),cy=Y.get(i);
            int dis=(int)Math.pow(cx-x,2)+(int)Math.pow(cy-y,2);
            if(dis<=r*r)
             return true;
        }
        return false;
    }
}

