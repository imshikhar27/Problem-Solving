import java.util.ArrayList;

public class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int e=0,s=Integer.MIN_VALUE;
        for(int i:boards)
        {
            s=Math.max(s,i);
            e+=i;
        }
        while(s<e)
        {
            int mid=s+(e-s)/2;
            if(valid(boards,mid,k))
             e=mid;
            else
             s=mid+1;
        }
        return e;
    }
    public static boolean valid(ArrayList<Integer> boards,int mid,int k)
    {
        int s=0;
        for(int i:boards)
        {
            s+=i;
            if(s>mid)
            {
                s=i;
                k--;
            }
            if(k==0)
             return false;
        }
        return true;
    }
}
