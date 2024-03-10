import java.util.*;
public class Binary
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int s=sc.nextInt();
        System.out.println(find(arr,n,s));
    }
    public static int find(int[] arr,int n,int S)
    {
        for(int a:arr)
            if(a>S)
                return 0;
        int s=1,e=n;
        int ans=0;
        while(s<e)
        {
            int x=s+(e-s)/2;
            if(valid(arr,x,S))
            {
                ans=x;
                s=x+1;
            }
            else
                e=x-1;
        }
        return ans;
    }
    public static boolean valid(int[] arr,int x,int s)
    {
        int sum=0;
        for(int i=0;i<x;i++)
            sum+=arr[i];
        if(sum>s)
            return false;
        int i=0,j=x;
        while(j<arr.length)
        {
            sum+=arr[j++];
            sum-=arr[i++];
            if(sum>s)
                return false;
        }
        return true;
    }
}


