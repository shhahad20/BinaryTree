public class BinaryTree {
    Object tree[];
    int maxSize;
    java.util.Stack<Node> stk = new java.util.Stack<Node>();

    // The Stack class is part of the java.util package.
    // The <Node> part specifies the type of elements that will be stored in the
    // stack, in this case, Node objects.
    // The parentheses () indicate that it's calling the constructor of the
    // Stack<Node> class to create the object.
    public BinaryTree(Object a[], int n) {
        maxSize = n;
        tree = new Object[maxSize];
        for (int i = 0; i < maxSize; i++) {
            tree[i] = a[i];
            // assigns each element to the corresponding index in the tree array.
            // This step essentially copies the elements from the input array a[] to the
            // tree array.
        }
    }

    public Node buildTree(int index) { // The current index in the tree
        Node p = null;
        // This line initializes a local variable p of type Node to null.
        // p will be used to hold the current node being created.
        if (tree[index] != null) {
            // This condition checks if the element at the given index in the tree array is
            // not null.
            // If it's not null, it means that there is a node present at that index, and we
            // need to
            // create a Node object for it.
            p = new Node(tree[index]);
            p.left = buildTree(2 * index + 1);
            p.right = buildTree(2 * index + 2);
        }
        return p; // <-- returns the root node
        // The complete binary tree rooted at 'E' will be returned,
        // allowing you to access and work with the entire tree structure.
    }

    /// * Recursive methods - Binary tree traversals *
    public void inorder(Node p) {
        if (p != null) {
            inorder(p.left);
            System.out.print(p.data + " ");
            inorder(p.right);
        }
    }
    // If its second time visit we are going to print it.

    public void preorder(Node p) {
        if (p != null) {
            System.out.print(p.data + " ");
            // We want to visit the current node before its subtrees.
            preorder(p.left);
            preorder(p.right);
        }
    }
    // If its firts time visit we are going to print it, move to deep left

    public void postorder(Node p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data + " ");
        }
    }
    // If its thired time visit we are going to print it, move to deep left

    // * Non-recursive methods - Binary tree traversals */
    public void preorderIterative(Node p) {
        if (p == null) {
            System.out.print("Tree is empty!");
            return;
        }
        stk.push(p);
        while (!stk.isEmpty()) {
            p = stk.pop();
            // the current node
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

    public void postorderIterative(Node p) {
        if (p == null) {
            System.out.println("Tree is empty");
            return;
        }
        Node tmp = p;
        while (p != null) {
            while (p.left != null) {
                stk.push(p);
                p = p.left;
            }
            while (p != null && (p.right == null || p.right == tmp)) {
                System.out.print(p.data + " "); // print node data
                tmp = p;
                if (stk.isEmpty())
                    return;
                p = stk.pop();
            }
            stk.push(p);
            p = p.right;
        }
    }
}
