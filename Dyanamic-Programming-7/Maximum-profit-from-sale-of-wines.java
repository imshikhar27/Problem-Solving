import java.util.*;
public class Main
{
    static int[][] dp,order;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] prices=new int[n];
		for(int i=0;i<n;i++)
		 prices[i]=sc.nextInt();
		dp=new int[n][n];
		order=new int[n][n];
		int ans=find(n,0,n-1,prices);
		int l=0,r=n-1;
		while(l<=r)
		{
		    if(order[l][r]==0){
		     System.out.print("beg ");
		     l++;
		    }
		    else{
		     System.out.print("end ");
		     r--;
		    }
		}
		System.out.println("\n"+ans);
	}
	public static int find(int n,int l,int r,int[] prices)
	{
	    int mul=n-(r-l);
	    if(l==r)
	     return mul*prices[l];
	    if(dp[l][r]!=0)
	     return dp[l][r];
	    int first=prices[l]*mul+find(n,l+1,r,prices);
	    int last=prices[r]*mul+find(n,l,r-1,prices);
	    if(first>=last)
	        order[l][r]=0;
	    else
	        order[l][r]=1;
	    return dp[l][r]=Math.max(first,last);
	}
}

