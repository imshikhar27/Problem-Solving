import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int n=sc.nextInt();
	    int[] ele=new int[n];
	    int max=-1;
	    for(int i=0;i<n;i++)
	    {
	     ele[i]=sc.nextInt();
	     max=Math.max(ele[i],max);
	    }
	    int a=sc.nextInt();
	    int[] freq=new int[max+1];
	    for(int i=0;i<n;i++)
	    {
	     freq[ele[i]]++;
	    }
	    Arrays.sort(freq);
	    int s=0,e=n;
	    while(s<e)
	    {
	        int mid=(s+e)/2;
	        if(valid(mid,freq,a))
	         s=mid;
	        else 
	         e=mid-1;
	    }
		System.out.println(s);
	}
	public static boolean valid(int mid,int[] freq,int a)
	{
	    int i=freq.length-1;
	    while(i>=0&&a>0)
	    {
	        int item=freq[i];
	        int div=item/mid;
	        if(div==0)
	         return false;
	        a-=div;
	        i--;
	    }
	    if(a<=0)
	     return true;
	    return false;
	}
}

