public class main {
    static class Node{
        Double element;
        Node left;
        Node right;

        Node(Double e) {
            this.element = e;
            left = null;
            right = null;

        }
    }
    public static class BinaryTree{
        Node root;
        Node parent;
        Node current;
        public int depth(Node node)
        {
            if (node == null)
                return -1;
            else
            {
                int lDepth = depth(node.left);
                int rDepth = depth(node.right);
                if (lDepth > rDepth)
                    return lDepth + 1;
                else
                    return rDepth + 1;
            }
        }
        public String max(Node node){
            if(root==null) return null;
            else{
                if (root.left!=null)
                current=root.left;
                while(current.right!=null){
                    current=current.right;
                }
                Object lmax=current.element;
                current=root;
                while (current.right!=null){
                current=current.right;
                }
                Object rmax=current.element;
                return"left max= "+lmax+" root= "+root.element+" right max= "+rmax;
            }
        }
        Double sum(Node root)
        {
            if (root == null)
                return 0.0;
            return (root.element + sum(root.left) + sum(root.right));
        }
        public boolean search(double element){
            Node current=root;
            while(current!=null){
                if (element<current.element){
                    current=current.left;
                }
                else if(element>current.element){
                    current=current.right;
                }
                else return true;
            }
            return false;
        }

        public static Node insert(Node root, double key)
        {
            // if the root is null, create a new node and return it
            if (root == null) {
                return new Node(key);
            }

            // if the given key is less than the root node,
            // recur for the left subtree
            if (key < root.element) {
                root.left = insert(root.left, key);
            }

            // otherwise, recur for the right subtree
            else {
                // key >= root.data
                root.right = insert(root.right, key);
            }

            return root;
        }
        }

    public static void main(String[] Args){
        BinaryTree bt1=new BinaryTree();
        int pre[] = {2, 1, 3};
        for (int x: pre){
            bt1.insert(bt1.root, x);
        }
        System.out.println(bt1.max(bt1.root));
    }
}
