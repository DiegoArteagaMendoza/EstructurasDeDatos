public class BinaryTree<T extends Comparable<T>> {
    
    private T element;
    private BinaryTree<T> parent;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree (T element) {
        this.element = element;
    }

    public BinaryTree(T element, BinaryTree<T> parent, BinaryTree<T> left, BinaryTree<T> right) {
        this.element = element;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public BinaryTree(T element, BinaryTree<T> parent) {
        this.element = element;
        this.parent = parent;
    }

    public BinaryTree(BinaryTree<T> left, BinaryTree<T> right) {
        this.left = left;
        this.right = right;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BinaryTree<T> getParent() {
        return parent;
    }

    public void setParent(BinaryTree<T> parent) {
        this.parent = parent;
    }

    public BinaryTree<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<T> left) {
        this.left = left;
    }

    public BinaryTree<T> getRight() {
        return right;
    }

    public void setRight(BinaryTree<T> right) {
        this.right = right;
    }

    
}
