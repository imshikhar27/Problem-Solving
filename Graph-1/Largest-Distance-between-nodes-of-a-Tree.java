public class Solution {
    int maxAns;
    public int solve(ArrayList<Integer> A) {
        maxAns=0;
        Queue<Integer> q= new LinkedList<>();
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<A.size();i++)
        {
            int x=A.get(i);
            if(!map.containsKey(x))
             map.put(x,new ArrayList<>());
            map.get(x).add(i);
        }
        dfs(map,0);
        return maxAns;
    }
    public int dfs(HashMap<Integer,List<Integer>> map,int source)
    {
        List<Integer> l=map.get(source);
        int m1=0,m2=0;
        if(l==null || l.size()==0)
         return 1;
        for(int i=0;i<l.size();i++)
        {
            int ans=dfs(map,l.get(i));
            if(ans>m1)
            {
                m2=m1;
                m1=ans;
            }
            else if(ans>m2)
             m2=ans;
        }
        if(maxAns<(m1+m2))
         maxAns=m1+m2;
        return Math.max(m1,m2)+1;
    }
}

