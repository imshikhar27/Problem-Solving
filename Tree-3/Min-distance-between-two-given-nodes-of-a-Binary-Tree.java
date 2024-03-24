class GfG {
    int findDist(Node root, int a, int b) {
        // Your code here
        Node lca=LCA(root,a,b);
        int dis=0;
        dis+=find(lca,b);
        dis+=find(lca,a);
        return dis;
    }
    Node LCA(Node root,int a,int b)
    {
        if(root==null)
         return null;
        if(root.data==a || root.data==b)
         return root;
        Node l=LCA(root.left,a,b);
        Node r=LCA(root.right,a,b);
        if(l==null)
         return r;
        if(r==null)
         return l;
        return root;
    }
    int find(Node root,int x)
    {
        if(root==null)
         return (int)1e9;
        if(root.data==x)
         return 0;
        int l=find(root.left,x);
        int r=find(root.right,x);
        return 1+Math.min(l,r);
    }
}
