class Solution {
    HashMap<Integer,HashMap<Integer,Integer>> map;
    public int maximumScore(int[] nums, int[] multipliers) {
        map=new HashMap<>();
        return find(nums,0,nums.length-1,multipliers);
    }
    public int find(int[] nums,int l,int r,int[] multipliers)
    {
        int n=nums.length;
        int mul=n-(r-l)-1;
        if(mul>=multipliers.length)
         return 0;
        if(l==r)
         return nums[l]*multipliers[mul];
        if(map.containsKey(l) && map.get(l).containsKey(r))
             return map.get(l).get(r);

        int first=nums[l]*multipliers[mul]+find(nums,l+1,r,multipliers);
        int last=nums[r]*multipliers[mul]+find(nums,l,r-1,multipliers);
        int ans=Math.max(first,last);
        if(!map.containsKey(l))
         map.put(l,new HashMap<>());
        map.get(l).put(r,ans);
        return ans;
    }
}
