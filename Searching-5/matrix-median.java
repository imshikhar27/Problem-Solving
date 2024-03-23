public class Solution {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int min=Integer.MAX_VALUE,max=-1,n=A.size(),m=(A.get(0)).size();
        int k=(n*m)/2+1;
        for(int i=0;i<n;i++)
        {
            ArrayList<Integer> arr=A.get(i);
            max=Math.max(max,arr.get(m-1));
            min=Math.min(min,arr.get(0));
        }
        int ans=0;
        while(min<max)
        {
            int mid=min+(max-min)/2;
            int countLessThanMid=0;
            for(int i=0;i<n;i++)
             countLessThanMid+=count(A,i,mid);
            if(countLessThanMid<k)
                min=mid+1;
            else
             max=mid;
        }
        return max;
    }
    public static int count(ArrayList<ArrayList<Integer>> A,int i,int mid)
    {
        int s=0,e=(A.get(i)).size()-1;
        while(s<=e)
        {
            int m=s+(e-s)/2;
            if((A.get(i)).get(m)<=mid)
             s=m+1;
            else
             e=m-1;
        }
        return s;
    }
}

