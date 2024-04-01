class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
         return null;
        if(head.next==null)
         return new TreeNode(head.val);
        ListNode mid=getMid(head);
        TreeNode node=new TreeNode(mid.val);
        node.left=sortedListToBST(head);
        node.right=sortedListToBST(mid.next);
        return node;
    }
    public ListNode getMid(ListNode head)
    {
        ListNode slow=head,fast=head,prev=null;
        while(fast!=null && fast.next!=null)
        {
         prev=slow;
         slow=slow.next;
         fast=fast.next;
         if(fast!=null)
          fast=fast.next;
        }
        prev.next=null;
        return slow;
    }
}
