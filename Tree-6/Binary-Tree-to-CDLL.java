class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
    static Node head,tail;
    static class Pair
    {
        Node min,max;
        Pair(Node min,Node max)
        {
            this.min=min;
            this.max=max;
        }
    }
    Node bTreeToClist(Node root)
    {
        head=null;
        tail=null;
        traverse(root);
        head.left=tail;
        tail.right=head;
        return head;
    }
    static Pair traverse(Node root)
    {
        if(root==null)
         return new Pair(null,null);
        if(root.left==null && root.right==null)
        {
            if(head==null)
             head=root;
            tail=root;
            return new Pair(root,root);
        }
        Pair l=traverse(root.left);
        if(head==null)
         head=root;
        tail=root;
        Pair r=traverse(root.right);
        
        Node largeOfLeft=l.max;
        Node smallOfRight=r.min;
        root.left=largeOfLeft;
        if(largeOfLeft!=null)
         largeOfLeft.right=root;
        root.right=smallOfRight;
        if(smallOfRight!=null)
         smallOfRight.left=root;
         
        Node left=(l.min==null)?root:l.min;
        Node right=(r.max==null)?root:r.max;
        return new Pair(left,right);
    }
    
}
    

