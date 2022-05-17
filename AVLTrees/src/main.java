// Name:		  Shane Wild
// Class:	  CS 3305/W03
// Term:		  Spring 22
// Instructor:  Betty Kretlow
// Assignment:  9-Part-2-AVL
public class main {
    class TreeNode<E> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e) {
            element = e;
        }
    }

    public interface Tree<E> extends Iterable<E> {

        public boolean search(E e);

        public boolean insert(E e);

        public boolean delete(E e);

        public void inorder();

        public void postorder();

        public void preorder();

        public int getSize();

        public boolean isEmpty();
    }

    public static abstract class AbstractTree<E> implements Tree<E> {
        @Override
        public void inorder() {
        }

        @Override
        public void postorder() {
        }

        @Override
        public boolean isEmpty() {
            return getSize() == 0;
        }
    }

    public static class BST<E extends Comparable<E>> extends AbstractTree<E> {
        protected TreeNode<E> root;
        protected int size = 0;

        public BST() {
        }

        public BST(E[] objects) {
            for (int i = 0; i < objects.length; i++) {
                insert(objects[i]);
            }
        }

        @Override
        public boolean search(E e) {
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    current = current.right;
                } else return true;
            }
            return false;
        }


        @Override
        public boolean insert(E e) {
            if (root == null)
                root = createNewNode(e); // Create a new root
            else {// Locate the parent node
                TreeNode<E> parent = null;
                TreeNode<E> current = root;
                while (current != null)
                    if (e.compareTo(current.element) < 0) {
                        parent = current;
                        current = current.left;
                    } else if (e.compareTo(current.element) > 0) {
                        parent = current;
                        current = current.right;
                    } else
                        return false; // Duplicate node not inserted
                if (e.compareTo(parent.element) < 0)
                    parent.left = createNewNode(e);
                else
                    parent.right = createNewNode(e);
            }
            size++;
            return true;
        }

        protected TreeNode<E> createNewNode(E e) {
            return new TreeNode<>(e);
        }

        public void inorder() {
            inorder(root);
        }

        protected void inorder(TreeNode<E> root) {
            if (root == null) return;
            inorder(root.left);
            System.out.print(root.element + " ");
            inorder(root.right);
        }

        @Override
        public void postorder() {
            postorder(root);
        }

        protected void preorder(TreeNode<E> root) {
            if (root == null) return;
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.element + " ");
        }

        @Override
        /** Preorder traversal from the root */
        public void preorder() {
            preorder(root);
        }

        protected void postorder(TreeNode<E> root) {
            if (root == null) return;
            System.out.print(root.element + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public class TreeNode<E extends Comparable<E>> {
            protected E element;
            protected TreeNode<E> left;
            protected TreeNode<E> right;

            public TreeNode(E e) {
                element = e;
            }
        }

        public int getSize() {
            return size;
        }

        public TreeNode<E> getRoot() {
            return root;
        }

        public java.util.ArrayList<TreeNode<E>> path(E e) {
            java.util.ArrayList<TreeNode<E>> list =
                    new java.util.ArrayList<>();
            TreeNode<E> current = root; // Start from the root

            while (current != null) {
                list.add(current); // Add the node to the list
                if (e.compareTo(current.element) < 0) {
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    current = current.right;
                } else
                    break;
            }

            return list; // Return an array list of nodes
        }

        public boolean delete(E e) {
            // Locate the node to be deleted and also locate its parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    break; // Element is in the tree pointed at by current
            }

            if (current == null)
                return false; // Element is not in the tree
            // Case 1: current has no left child
            if (current.left == null) {
                // Connect the parent with the right child of the current node
                if (parent == null) {
                    root = current.right;
                } else {
                    if (e.compareTo(parent.element) < 0)
                        parent.left = current.right;
                    else
                        parent.right = current.right;
                }
            } else {
                // Case 2: The current node has a left child.
                // Locate the rightmost node in the left subtree of
                // the current node and also its parent.
                TreeNode<E> parentOfRightMost = current;
                TreeNode<E> rightMost = current.left;

                while (rightMost.right != null) {
                    parentOfRightMost = rightMost;
                    rightMost = rightMost.right; // Keep going to the right
                }

                // Replace the element in current by the element in rightMost
                current.element = rightMost.element;

                // Eliminate rightmost node
                if (parentOfRightMost.right == rightMost)
                    parentOfRightMost.right = rightMost.left;
                else
                    // Special case: parentOfRightMost == current
                    parentOfRightMost.left = rightMost.left;
            }

            size--;
            return true; // Element deleted successfully
        }

        @Override
        /** Obtain an iterator. Use inorder. */
        public java.util.Iterator<E> iterator() {
            return new InorderIterator();
        }

        // Inner class InorderIterator
        private class InorderIterator implements java.util.Iterator<E> {
            // Store the elements in a list
            private java.util.ArrayList<E> list =
                    new java.util.ArrayList<>();
            private int current = 0; // Point to the current element in list

            public InorderIterator() {
                inorder(); // Traverse binary tree and store elements in list
            }

            /**
             * Inorder traversal from the root
             */
            private void inorder() {
                inorder(root);
            }

            /**
             * Inorder traversal from a subtree
             */
            private void inorder(TreeNode<E> root) {
                if (root == null) return;
                inorder(root.left);
                list.add(root.element);
                inorder(root.right);
            }

            @Override
            /** More elements for traversing? */
            public boolean hasNext() {
                if (current < list.size())
                    return true;

                return false;
            }

            @Override
            /** Get the current element and move to the next */
            public E next() {
                return list.get(current++);
            }

            @Override
            /** Remove the current element */
            public void remove() {
                delete(list.get(current)); // Delete the current element
                list.clear(); // Clear the list
                inorder(); // Rebuild the list
            }
        }

        /**
         * Remove all elements from the tree
         */
        public void clear() {
            root = null;
            size = 0;
        }
    }

    public static class AVLTree<E extends Comparable<E>> extends BST<E> {
        /**
         * Create an empty AVL tree
         */
        public AVLTree() {
        }

        /**
         * Create an AVL tree from an array of objects
         */
        public AVLTree(E[] objects) {
            super(objects);
        }

        @Override
        /** Override createNewNode to create an AVLTreeNode */
        protected AVLTreeNode<E> createNewNode(E e) {
            return new AVLTreeNode<E>(e);
        }

        @Override
        /** Insert an element and rebalance if necessary */
        public boolean insert(E e) {
            boolean successful = super.insert(e);
            if (!successful)
                return false; // e is already in the tree
            else {
                balancePath(e); // Balance from e to the root if necessary
            }

            return true; // e is inserted
        }

        /**
         * Update the height of a specified node
         */
        private void updateHeight(AVLTreeNode<E> node) {
            if (node.left == null && node.right == null) // node is a leaf
                node.height = 0;
            else if (node.left == null) // node has no left subtree
                node.height = 1 + ((AVLTreeNode<E>) (node.right)).height;
            else if (node.right == null) // node has no right subtree
                node.height = 1 + ((AVLTreeNode<E>) (node.left)).height;
            else
                node.height = 1 +
                        Math.max(((AVLTreeNode<E>) (node.right)).height,
                                ((AVLTreeNode<E>) (node.left)).height);
        }

        /**
         * Balance the nodes in the path from the specified
         * node to the root if necessary
         */
        private void balancePath(E e) {
            java.util.ArrayList<TreeNode<E>> path = path(e);
            for (int i = path.size() - 1; i >= 0; i--) {
                AVLTreeNode<E> A = (AVLTreeNode<E>) (path.get(i));
                updateHeight(A);
                AVLTreeNode<E> parentOfA = (A == root) ? null :
                        (AVLTreeNode<E>) (path.get(i - 1));

                switch (balanceFactor(A)) {
                    case -2:
                        if (balanceFactor((AVLTreeNode<E>) A.left) <= 0) {
                            balanceLL(A, parentOfA); // Perform LL rotation
                        } else {
                            balanceLR(A, parentOfA); // Perform LR rotation
                        }
                        break;
                    case +2:
                        if (balanceFactor((AVLTreeNode<E>) A.right) >= 0) {
                            balanceRR(A, parentOfA); // Perform RR rotation
                        } else {
                            balanceRL(A, parentOfA); // Perform RL rotation
                        }
                }
            }
        }

        /**
         * Return the balance factor of the node
         */
        private int balanceFactor(AVLTreeNode<E> node) {
            if (node.right == null) // node has no right subtree
                return -node.height;
            else if (node.left == null) // node has no left subtree
                return +node.height;
            else
                return ((AVLTreeNode<E>) node.right).height -
                        ((AVLTreeNode<E>) node.left).height;
        }

        /**
         * Balance LL (see Figure 26.2)
         */
        private void balanceLL(TreeNode<E> A, TreeNode<E> parentOfA) {
            TreeNode<E> B = A.left; // A is left-heavy and B is left-heavy

            if (A == root) {
                root = B;
            } else {
                if (parentOfA.left == A) {
                    parentOfA.left = B;
                } else {
                    parentOfA.right = B;
                }
            }

            A.left = B.right; // Make T2 the left subtree of A
            B.right = A; // Make A the left child of B
            updateHeight((AVLTreeNode<E>) A);
            updateHeight((AVLTreeNode<E>) B);
        }

        /**
         * Balance LR (see Figure 26.4)
         */
        private void balanceLR(TreeNode<E> A, TreeNode<E> parentOfA) {
            TreeNode<E> B = A.left; // A is left-heavy
            TreeNode<E> C = B.right; // B is right-heavy

            if (A == root) {
                root = C;
            } else {
                if (parentOfA.left == A) {
                    parentOfA.left = C;
                } else {
                    parentOfA.right = C;
                }
            }

            A.left = C.right; // Make T3 the left subtree of A
            B.right = C.left; // Make T2 the right subtree of B
            C.left = B;
            C.right = A;

            // Adjust heights
            updateHeight((AVLTreeNode<E>) A);
            updateHeight((AVLTreeNode<E>) B);
            updateHeight((AVLTreeNode<E>) C);
        }

        /**
         * Balance RR (see Figure 26.3)
         */
        private void balanceRR(TreeNode<E> A, TreeNode<E> parentOfA) {
            TreeNode<E> B = A.right; // A is right-heavy and B is right-heavy

            if (A == root) {
                root = B;
            } else {
                if (parentOfA.left == A) {
                    parentOfA.left = B;
                } else {
                    parentOfA.right = B;
                }
            }

            A.right = B.left; // Make T2 the right subtree of A
            B.left = A;
            updateHeight((AVLTreeNode<E>) A);
            updateHeight((AVLTreeNode<E>) B);
        }

        /**
         * Balance RL (see Figure 26.5)
         */
        private void balanceRL(TreeNode<E> A, TreeNode<E> parentOfA) {
            TreeNode<E> B = A.right; // A is right-heavy
            TreeNode<E> C = B.left; // B is left-heavy

            if (A == root) {
                root = C;
            } else {
                if (parentOfA.left == A) {
                    parentOfA.left = C;
                } else {
                    parentOfA.right = C;
                }
            }

            A.right = C.left; // Make T2 the right subtree of A
            B.left = C.right; // Make T3 the left subtree of B
            C.left = A;
            C.right = B;

            // Adjust heights
            updateHeight((AVLTreeNode<E>) A);
            updateHeight((AVLTreeNode<E>) B);
            updateHeight((AVLTreeNode<E>) C);
        }

        @Override
        /** Delete an element from the AVL tree.
         * Return true if the element is deleted successfully
         * Return false if the element is not in the tree */
        public boolean delete(E element) {
            if (root == null)
                return false; // Element is not in the tree

            // Locate the node to be deleted and also locate its parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (element.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (element.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    break; // Element is in the tree pointed by current
            }

            if (current == null)
                return false; // Element is not in the tree

            // Case 1: current has no left children (See Figure 25.10)
            if (current.left == null) {
                // Connect the parent with the right child of the current node
                if (parent == null) {
                    root = current.right;
                } else {
                    if (element.compareTo(parent.element) < 0)
                        parent.left = current.right;
                    else
                        parent.right = current.right;

                    // Balance the tree if necessary
                    balancePath(parent.element);
                }
            } else {
                // Case 2: The current node has a left child
                // Locate the rightmost node in the left subtree of
                // the current node and also its parent
                TreeNode<E> parentOfRightMost = current;
                TreeNode<E> rightMost = current.left;

                while (rightMost.right != null) {
                    parentOfRightMost = rightMost;
                    rightMost = rightMost.right; // Keep going to the right
                }

                // Replace the element in current by the element in rightMost
                current.element = rightMost.element;

                // Eliminate rightmost node
                if (parentOfRightMost.right == rightMost)
                    parentOfRightMost.right = rightMost.left;
                else
                    // Special case: parentOfRightMost is current
                    parentOfRightMost.left = rightMost.left;

                // Balance the tree if necessary
                balancePath(parentOfRightMost.element);
            }

            size--;
            return true; // Element inserted
        }
        //takes balanceFactor if the balance factor is less than or equal to 1 it will return true, meaning balanced, if not it will return false meaning it is not an AVL tree


        /**
         * AVLTreeNode is TreeNode plus height
         */
        protected class AVLTreeNode<E extends Comparable<E>> extends BST.TreeNode {
            protected int height = 0; // New data field

            public AVLTreeNode(E e) {
                super(e);
            }
        }

        public boolean isBalanced(AVLTreeNode<E> node) {
            if (balanceFactor(node) <= 1) {
                return true;
            }
            return false;
        }

    }

    public static void main(String[] Args) {
        AVLTree<Integer> tree = new AVLTree<>(new Integer[]{53, 27, 14});
        //if the tree is balanced it is a AVL tree
        System.out.println("Tree is AVL: " + tree.isBalanced((AVLTree<Integer>.AVLTreeNode<Integer>) tree.getRoot()));
        tree.insert(70);
        tree.insert(9);
        System.out.print("Tree is AVL: " + tree.isBalanced((AVLTree<Integer>.AVLTreeNode<Integer>) tree.getRoot()));
        System.out.println();
    }

}