class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length;
        int c=matrix[0].length;
         if(r==1)
          return bin(matrix,target,0,c);
        int rs=0,re=r-1,cs=0,ce=c-1;
        while(rs<(re-1))
        {
         int rm=rs+(re-rs)/2;
         int cm=cs+(ce-cs)/2;
         if(matrix[rm][cm]==target)
          return true;
         if(matrix[rm][cm]>target)
          re=rm;
         else
          rs=rm;
        }
        boolean a=bin(matrix,target,rs,c);
        if(a==true)
         return true;
        return bin(matrix,target,re,c);
    }
    public boolean bin(int[][] matrix,int target,int r,int c)
    {
     int cs=0,ce=c-1;
     while(cs<=ce)
     {
     int mid=cs+(ce-cs)/2;
     if(matrix[r][mid]==target)
      return true;
     if(matrix[r][mid]>target)
      ce=mid-1;
     else
      cs=mid+1;
     }
     return false;
    }
}
