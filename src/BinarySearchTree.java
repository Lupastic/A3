public class BinarySearchTree<K extends Comparable<K>, V> {
    private Node root;

    public Node getRoot() {
        return root;
    }

    private class Node {
        K key;
        V val;
        Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
            left=null;
            right=null;
        }
        @Override
        public String toString() {
            return key + ": " + val;
        }
    }

    public boolean put(K key, V val) {
        Node newNode = new Node(key, val);
        if (root == null) {
            root = newNode;
            return true;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                int cmp = key.compareTo(focusNode.key);
                if (cmp < 0) {
                    focusNode = focusNode.left;
                    if (focusNode == null) {
                        parent.left = newNode;
                        return true;
                    }
                } else {
                    focusNode = focusNode.right;
                    if (focusNode == null) {
                        parent.right = newNode;
                        return true;
                    }
                }
            }
        }
    }


    public V get(K key) {
        Node focusNode = root;
        while (focusNode != null) {
            int cmp = key.compareTo(focusNode.key);
            if (cmp < 0) {
                focusNode = focusNode.left;
            } else if (cmp > 0) {
                focusNode = focusNode.right;
            } else {
                return focusNode.val;
            }
        }
        return null;
    }
    public void inOrderTraversal(Node focusNode) {
        if (focusNode != null) {
            inOrderTraversal(focusNode.left);
            System.out.println(focusNode);
            inOrderTraversal(focusNode.right);
        }
    }
}
