class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static class Pair
    {
        Node node;
        int col;
        Pair(Node n,int c)
        {
            this.node=n;
            this.col=c;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        Queue<Pair> q=new LinkedList<>();
        TreeMap<Integer,Integer> map=new TreeMap<>();
	    q.add(new Pair(root,0));
	    int t=1;
	    while(q.size()!=0)
	    {
	        int l=q.size();
	        for(int i=0;i<l;i++)
	        {
	            Pair p=q.poll();
	            Node n=p.node;
	            int col=p.col;
	            if(!map.containsKey(col))
	             map.put(col,n.data);
	            if(n.left!=null)
	             q.add(new Pair(n.left,col-1));
	            if(n.right!=null)
	             q.add(new Pair(n.right,col+1));
	        }
	    }
	    ArrayList<Integer> ans=new ArrayList<>();
	    for(int i:map.values())
	     ans.add(i);
	    return ans;
        
        
    }
}
