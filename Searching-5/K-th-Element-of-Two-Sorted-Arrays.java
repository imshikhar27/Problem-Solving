import java.util.ArrayList;
public class Solution {
    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
        // Write your coder here
        if(m<n)
         return kthElement(arr2,arr1,m,n,k);

        int s=Math.max(0,k-m),e=Math.min(k,n);
        while(s<=e)
        {
            int m1=s+(e-s)/2;
            int m2=k-m1;
            int al=(m1==0)?Integer.MIN_VALUE:arr1.get(m1-1);
            int ar=(m1==n)?Integer.MAX_VALUE:arr1.get(m1);
            int bl=(m2==0)?Integer.MIN_VALUE:arr2.get(m2-1);
            int br=(m2==m)?Integer.MAX_VALUE:arr2.get(m2);
            if(al<=br && bl<=ar)
             return Math.max(al,bl);
            else if(al>br)
             e=m1-1;
            else if(bl>ar)
             s=m1+1;
        }
        return 0;
    }
}
