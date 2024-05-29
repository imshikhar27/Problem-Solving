class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()][word2.length()];
        for(int[] r:dp)
         Arrays.fill(r,-1);
        return minop(word1,0,word2,0,dp);
    }

    public int minop(String word1,int i,String word2,int j,int[][] dp)
    {
     if(i==word1.length() && j==word2.length())
        return 0;
     if(i==word1.length())
        return word2.length()-j; //Add characters
     if(j==word2.length())
        return word1.length()-i; //remove characters
     if(dp[i][j]!=-1)
      return dp[i][j];
     char c1=word1.charAt(i);
     char c2=word2.charAt(j);
     
     int ans=0;
     if(c1==c2)
      ans=minop(word1,i+1,word2,j+1,dp);
     else
     {
        int replace=minop(word1,i+1,word2,j+1,dp);
        int delete=minop(word1,i+1,word2,j,dp);
        int insert=minop(word1,i,word2,j+1,dp);        

        ans=1+Math.min(insert,Math.min(delete,replace)); 
     }
     dp[i][j]=ans;
     return ans;
    } 
}

