import java.util.*;
public class Main
{
    static int[] dp;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		dp=new int[n+1];
		int ans=find(n);
		System.out.println(ans);
	}
	public static int find(int n)
	{
	    if(n==1)
	     return 0;
	    if(n<1)
	     return (int)1e9;
	    if(dp[n]!=0)
	     return dp[n];
	     
	    int a=1+find(n-1);
	    int b=Integer.MAX_VALUE,c=b;
	    if(n%2==0)
	     b=1+find(n/2);
	    if(n%3==0)
	     c=1+find(n/3);
	    return dp[n]=Math.min(a,Math.min(b,c));
	}
}

