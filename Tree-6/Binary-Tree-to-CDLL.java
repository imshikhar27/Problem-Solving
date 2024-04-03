class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
    static Node prev,head,tail;
    Node bTreeToClist(Node root)
    {
        //your code her
        head=null;
        tail=null;
        convertCDLL(root);
        head.left=tail;
        tail.right=head;
        return head;
    }
    public static void convertCDLL(Node root)
    {
        if(root==null)
         return;
         
        convertCDLL(root.left);
        
        if(head==null)
         head=root;
        tail=root;
        if(prev!=null)
         prev.right=root;
        root.left=prev;
        prev=root;
        
        convertCDLL(root.right);
        
    }
    
}