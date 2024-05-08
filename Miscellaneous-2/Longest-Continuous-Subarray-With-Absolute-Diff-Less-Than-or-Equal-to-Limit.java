class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min=new LinkedList<>();
        Deque<Integer> max=new LinkedList<>();
        int i=0,j=0;
        int ans=0;
        while(j<nums.length)
        {
            int num=nums[j];
            while(!max.isEmpty() && nums[max.peekLast()]<num)
             max.pollLast();
            max.addLast(j);

            while(!min.isEmpty() && nums[min.peekLast()]>num)
             min.pollLast();
            min.addLast(j);
            
            while(nums[max.peekFirst()]-nums[min.peekFirst()]>limit)
            {
                i++;
                while(max.peekFirst()<i)
                 max.pollFirst();
                while(min.peekFirst()<i)
                 min.pollFirst();
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}
