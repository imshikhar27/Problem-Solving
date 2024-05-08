class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int l1=str1.length();
        int l2=str2.length();
        int lon=0;
        int[][] dp=new int[l1+1][l2+1];
        for(int i=1;i<=l1;i++)
        {
            for(int j=1;j<=l2;j++)
            {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                 dp[i][j]=1+dp[i-1][j-1];
                else
                 dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int l=l1+l2-dp[l1][l2];
        char[] ch=new char[l];
        int i=l1,j=l2;
        while(i>0 &&  j>0)
        {
            if(str1.charAt(i-1)==str2.charAt(j-1))
            {
             ch[l-1]=str2.charAt(j-1);
             j--;
             i--;
            }
            else
            {
                int a1=dp[i-1][j],a2=dp[i][j-1];
                if(a1<=a2)
                    ch[l-1]=str2.charAt(--j);
                else
                    ch[l-1]=str1.charAt(--i);
            }
            l--;
        }
        while(i>0)
        {
            ch[l-1]=str1.charAt(--i);
            l--;
        }
        while(j>0)
        {
            ch[l-1]=str2.charAt(--j);
            l--;
        }
        return new String(ch);
    }
}
