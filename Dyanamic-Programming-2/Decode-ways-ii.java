class Solution {
    int[] dp;
    int m;
    public int numDecodings(String s) {
        dp=new int[s.length()];
        m=1000000007;
        Arrays.fill(dp,-1);
        return count(s,0);
    }
    public int count(String s,int ind)
    {
     if(ind==s.length())
        return 1;
     if(dp[ind]!=-1)
      return dp[ind];
     if(s.charAt(ind)=='0')
      return 0;

     int cnt=0;
     int cnt1=( ((s.charAt(ind)=='*')?9:1)*count(s,ind+1) )%m;
     
     if(ind<s.length()-1)
     {
      if( s.charAt(ind)=='1')
      {
       cnt+=( ((s.charAt(ind+1)=='*')?9:1)*count(s,ind+2) )%m;
      }
      else if(s.charAt(ind)=='2')
      {
        if(s.charAt(ind+1)=='*')
         cnt+=( 6*count(s,ind+2) )%m;
        else if(s.charAt(ind+1)>='0' && s.charAt(ind+1)<='6')
         cnt+=( count(s,ind+2) )%m;
      }
      else if(s.charAt(ind)=='*')
      {
        if(s.charAt(ind+1)=='*')
          cnt+=( 15*count(s,ind+2) )%m; 
        else if(s.charAt(ind+1)>='0' && s.charAt(ind+1)<='6')
         cnt+=( 2*count(s,ind+2) )%m;
        else
         cnt+=count(s,ind+2)%m;
      }
     }
     return dp[ind]=( cnt%m + cnt1%m )%m;
    }
}
