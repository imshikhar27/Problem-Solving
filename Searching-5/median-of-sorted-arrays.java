class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=nums1.length,l2=nums2.length;
        if(l1<=l2)
         return find(nums1,l1,nums2,l2);
        return find(nums2,l2,nums1,l1);
    }
    public double find(int[] nums1,int l1,int[] nums2,int l2)
    {
        int s=0,e=l1;
        int k=(l1+l2+1)/2;
        while(s<=e)
        {
            int m1=(s+e)/2;
            int m2=k-m1;
            int al=(m1==0)?Integer.MIN_VALUE:nums1[m1-1];
            int ar=(m1==l1)?Integer.MAX_VALUE:nums1[m1];
            int bl=(m2==0)?Integer.MIN_VALUE:nums2[m2-1];
            int br=(m2==l2)?Integer.MAX_VALUE:nums2[m2];
            if(al<=br && bl<=ar)
            {
                if((l1+l2)%2==0)
                 return (double)(Math.max(al,bl)+Math.min(ar,br))/2;
                return Math.max(al,bl);
            }
            else if(al>br)
             e=m1-1;
            else if(bl>ar)
             s=m1+1;
        }
        return 0;
    }
}
