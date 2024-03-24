public class BinaryTreeDemo {
    public static void main(String[] args) {
        Object array[] = { 'E', 'C', 'G', 'A', 'D', 'F', 'H', null, 'B', null, null, null, null, null, null, null, null,
                null, null };
        BinaryTree t = new BinaryTree(array, array.length);
        Node root = t.buildTree(0);
        System.out.print("\n Recursive Binary Tree Traversals:");
        System.out.print("\n inorder: ");
        t.inorder(root);
        System.out.print("\n preorder: ");
        t.preorder(root);
        System.out.print("\n postorder: ");
        t.postorder(root);
        System.out.print("\n Non-recursive Binary Tree Traversals:");
        System.out.print("\n inorder: ");
        t.inoredrIterative(root);
        System.out.print("\n preorder: ");
        t.preorderIterative(root);
        System.out.print("\n postorder: ");
        t.postorderIterative(root);

    }
}
