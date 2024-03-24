public class BinaryTree {
    Object tree[];
    int maxSize;

    java.util.Stack<Node> stk = new java.util.Stack<Node>();

    public BinaryTree(Object a[], int n) {
        maxSize = n;
        tree = new Object[maxSize];
        for (int i = 0; i < maxSize; i++) {
            tree[i] = a[i];
        }
    }

    public Node buildTree(int index) { // The current index in the tree
        Node p = null;
        if (tree[index] != null) {
            p = new Node(tree[index]);
            p.left = buildTree(2 * index + 1);
            p.right = buildTree(2 * index + 2);
        }
        return p; // <-- returns the root node
    }
    /// * Recursive methods - Binary tree traversals *
    public void inorder(Node p) {
        if (p != null) {
            inorder(p.left);
            System.out.print(p.data + " ");
            inorder(p.right);
        }
    }

    public void preorder(Node p) {
        if (p != null) {
            System.out.print(p.data + " ");
            preorder(p.left);
            preorder(p.right);
        }
    }

    public void postorder(Node p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data + " ");
        }
    }

    // * Non-recursive methods - Binary tree traversals */
    public void preorderIterative(Node p) {
        if (p == null) {
            System.out.print("Tree is empty!");
            return;
        }
        stk.push(p);
        while (!stk.isEmpty()) {
            p = stk.pop();
            if (p != null) {
                System.out.print(p.data + " ");
                stk.push(p.right);
                stk.push(p.left);
            }
        }
    }
    public void inoredrIterative(Node p) {
        if (p == null) {
            System.out.print("Tree is empty!");
            return;
        }
        while (!stk.isEmpty() || p != null) {
            if (p != null) {
                stk.push(p);
                p = p.left;
            } else {
                p = stk.pop();
                System.out.print(p.data + " ");
                p = p.right;
            }
        }
    }
    public void postorderIterative(Node p)
    {
    if(p == null )
    { System.out.println("Tree is empty"); return;
    }
    Node tmp = p; while( p != null )
    {
    while( p.left != null )
    { stk.push(p); p = p.left;}
    while( p != null && (p.right == null || p.right == tmp ))
    { System.out.print(p.data + " "); // print node data 
    tmp = p;
    if( stk.isEmpty() ) return;
    p = stk.pop();
    }
    stk.push(p); p = p.right;}}
}
