import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
		    a[i]=sc.nextInt();
		System.out.println(find(0,a,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}
	public static boolean find(int i,int[] a,int min,int max)
	{
	    if(i==a.length-1)
	    {
	      if(a[i]>min && a[i]<max)
	       return true;
	      return false;
	    }
	    if(a[i]<min && a[i]>max)
	     return false;
	    int next=a[i+1];
	    if(a[i]<next)
	     return find(i+1,a,a[i],max);
	    return find(i+1,a,min,a[i]);
	}
}

