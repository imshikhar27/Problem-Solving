class Solution {
    public int rob(int[] nums) {
        int[] s=new int[nums.length];
        for(int i=0;i<nums.length;i++)
         s[i]=-1;
        return max(nums,s,nums.length-1);
    }
    public int max(int[] nums,int[] s,int i)
    {
        if(i<0)
         return 0;
        if(i==0)
         return nums[0];
        if(s[i]!=-1)
         return s[i];
        
        int a=max(nums,s,i-2);
        if(i-2>=0)
         s[i-2]=a;
        int b=nums[i]+a;
        int c=max(nums,s,i-1);
        if(i-1>=0)
         s[i-1]=c;
        return Math.max(b,c);
    }
}
