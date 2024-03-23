class Solution {
    class Tuple
    {
        int row;
        int col;
        TreeNode node;
        Tuple(TreeNode node,int row,int col)
        {
        this.node=node;
        this.row=row;
        this.col=col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<>();
        int row;
        int col;
        TreeNode node;
        q.add(new Tuple(root,0,0));
        while(q.size()!=0)
        {   
            Tuple t=q.remove();
            row=t.row;
            col=t.col;
            node=t.node;
            if(!map.containsKey(row))
             map.put(row,new TreeMap<>());
            if(!map.get(row).containsKey(col))
             map.get(row).put(col,new PriorityQueue<Integer>());
            map.get(row).get(col).add(node.val);
            if(node.left!=null)
                q.add(new Tuple(node.left,row-1,col+1));
            if(node.right!=null)
                q.add(new Tuple(node.right,row+1,col+1));
        }   
        List<List<Integer>> ls=new LinkedList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> m:map.values())
        {
            List<Integer> in=new LinkedList<>();
            for(PriorityQueue<Integer> qs:m.values())
            {
                while(!qs.isEmpty())
                 in.add(qs.poll());
            }
            ls.add(in);
        }
        return ls; 
    }
}
