import java.util.*;
public class Main
{
    static int[][] dp;
    static int n,x,y,z;
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    n=sc.nextInt();
	    int[] arr=new int[n];
	    for(int i=0;i<n;i++)
	     arr[i]=sc.nextInt();
	    x=sc.nextInt();
	    y=sc.nextInt();
	    z=sc.nextInt();
	    dp=new int[arr.length][3];
	    for(int[] d:dp)
	     Arrays.fill(d,-1);
		System.out.println(cal(arr,0,0));
	}
	public static int cal(int[] arr,int k,int ind)
	{
	    if(k==3)
	     return 0;
	    if(ind==arr.length)
	     return Integer.MIN_VALUE;
	    if(dp[ind][k]!=-1)
	     return dp[ind][k];
	    int notTake=cal(arr,k,ind+1);
	    int take=0;
	    if(k==0)
	     take+=x*arr[ind];
	    else if(k==1)
	     take+=y*arr[ind];
	    else 
	     take+=z*arr[ind];
	    int c=cal(arr,k+1,ind);
	    take+=(c==Integer.MIN_VALUE)?-take:c;
	    
	    return dp[ind][k]=Math.max(notTake,take); 
	}
}

