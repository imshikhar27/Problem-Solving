class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return count(s,0);
    }
    public int count(String s,int ind)
    {
     if(ind==s.length())
        return 1;
     if(dp[ind]!=-1)
      return dp[ind];
    
     int cnt=0;

     if(s.charAt(ind)=='0')
      return 0;

     cnt+=count(s,ind+1);
     
     if(ind<s.length()-1)
     {
      if( (s.charAt(ind)=='1' && s.charAt(ind+1)>='0' && s.charAt(ind+1)<='9') || 
      (s.charAt(ind)=='2' && s.charAt(ind+1)>='0' && s.charAt(ind+1)<='6'))
      {
        cnt+=count(s,ind+2);
      }
     }
     return dp[ind]=cnt;
    }
}
