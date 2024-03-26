public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(q.size()!=0)
        {
            TreeNode node=q.poll();
            if(node==null)
             sb.append("null,");
            else
            {
                sb.append(Integer.toString(node.val)+",");
                q.add(node.left);
                q.add(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] st=data.split(",");
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode root=null;
        if((st[0]).equals("null"))
         return root;
        root=new TreeNode();
        root.val=Integer.parseInt(st[0]);
        q.add(root);
        int i=1;
        while(q.size()!=0)
        {
            TreeNode node=q.poll();
            if(!(st[i]).equals("null"))
            {
             TreeNode left=new TreeNode();
             node.left=left;
             left.val=Integer.parseInt(st[i]);
             q.add(left);
            }
            i++;
            if(!(st[i]).equals("null"))
            {
             TreeNode right=new TreeNode();
             node.right=right;
             right.val=Integer.parseInt(st[i]);
             q.add(right);
            }
            i++;
        }
        return root;
    }
}
