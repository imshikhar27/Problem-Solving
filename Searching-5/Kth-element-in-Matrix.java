class Solution
{
	public static int kthSmallest(int[][]mat,int n,int k)
	{
        //code here.
        int min=Integer.MAX_VALUE,max=-1;
        for(int i=0;i<mat.length;i++)
        {
            max=Math.max(max,mat[i][n-1]);
            min=Math.min(min,mat[i][0]);
        }
        int ans=0;
        while(min<max)
        {
            int mid=min+(max-min)/2;
            int countLessThanMid=0;
            for(int i=0;i<mat.length;i++)
             countLessThanMid+=count(mat,i,mid);
            if(countLessThanMid<k)
                min=mid+1;
            else
             max=mid;
        }
        return max;
    }
    public static int count(int[][] mat,int i,int mid)
    {
        int s=0,e=mat[0].length-1;
        while(s<=e)
        {
            int m=s+(e-s)/2;
            if(mat[i][m]<=mid)
             s=m+1;
            else
             e=m-1;
        }
        return s;
    }
}
