class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp=new int[s.length()][p.length()];
        return (match(s,0,p,0,dp)==1)?true:false;
    }
    public int match(String s,int i,String p,int j,int[][] dp)
    {
        if(i==s.length() && j==p.length())
         return 1;
        if(i==s.length())
        {
            while(j<p.length())
            {
                if(p.charAt(j)!='*')
                 return -1;
                j++;
            }
            return 1;
        }
        if(j==p.length())
         return -1;
        
        if(dp[i][j]!=0)
         return dp[i][j];
        char c1=s.charAt(i);
        char c2=p.charAt(j);
         
        int ans=0;
        if(c2=='*')
        {
            ans=match(s,i+1,p,j,dp);
            if(ans==1)
            {
                dp[i][j]=1;
                return 1;
            }
            ans=match(s,i,p,j+1,dp);
            dp[i][j]=ans;
            return ans;
        }
        else if(c2>='a' && c2<='z')
        {
            if(c1!=c2)
             ans=-1;
            else
             ans=match(s,i+1,p,j+1,dp);             
        }
        else if(c2=='?')
         ans=match(s,i+1,p,j+1,dp);

        dp[i][j]=ans;
        return ans;
    }
}
