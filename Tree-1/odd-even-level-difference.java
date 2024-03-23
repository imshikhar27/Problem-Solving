class Solution
{
	int getLevelDiff(Node root)
	{
	    //code here
	    Queue<Node> q=new LinkedList<>();
	    q.add(root);
	    int o=0,e=0;
	    int t=1;
	    while(q.size()!=0)
	    {
	        int l=q.size();
	        for(int i=0;i<l;i++)
	        {
	            Node n=q.poll();
	            if((t&1)==0)
	             e+=n.data;
	            else
	             o+=n.data;
	            if(n.left!=null)
	             q.add(n.left);
	            if(n.right!=null)
	             q.add(n.right);
	        }
	        t+=1;
	    }
	    return o-e;
	}
}
