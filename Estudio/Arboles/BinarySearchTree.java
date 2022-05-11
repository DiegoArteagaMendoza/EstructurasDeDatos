public class BinarySearchTree<T> {

    private BinaryTree<T> root;
    
    public boolean isEmpty() {
        return root == null;
    }

    public BinaryTree<T> getRoot() {
        return root;
    }

    public boolean isRoot(BinaryTree<T> nodo) {
        return root == nodo;
    }

    public boolean isLeaf(BinaryTree<T> nodo) {
        return nodo.getLeft() == null && nodo.getRight() == null;
    }

    public boolean isInternal(BinaryTree<T> nodo) {
        return !isLeaf(nodo);
    }

    //recursive
    public void add(BinaryTree<T> origen, T elemento) {
        BinaryTree<T> nodo;
        if(root == null) {
            root = new BinaryTree<>(elemento);
        } else if(origen == null) {
            System.out.println("El origen es nulo");
        } else {

            if (origen.getElement().comparteTo(elemento) > 0) {

                if (origen.getLeft() != null) {
                    add(origen.getLeft(), elemento);
                } else {
                    nodo = new BinaryTree<>(elemento);
                    nodo.setParent(origen);
                    origen.setLeft(nodo);
                }

            } else {

                if (origen.getRight() != null) {
                    add(origen.getRight(), elemento);
                } else {
                    nodo = new BinaryTree<>(elemento);
                    nodo.setParent(origen);
                    origen.setRight(nodo);
                }

            }
            return nodo;
        }
    }
}
