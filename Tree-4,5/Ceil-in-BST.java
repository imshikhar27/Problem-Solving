class Tree {
    // Function to return the ceil of given number in BST.
    int findCeil(Node root, int key) {
        if (root == null) 
         return -1;
        int ans=0;
        if(root.data==key)
         return key;
        if(root.data<key)
         ans=findCeil(root.right,key);
        else
         ans=findCeil(root.left,key);
         
        if(root.data<key)
         return ans;
        if(ans==-1)
         return root.data;
         
        ans=(Math.abs(root.data-key)<Math.abs(ans-key))?root.data:ans;
        return ans;
    }
    
}

