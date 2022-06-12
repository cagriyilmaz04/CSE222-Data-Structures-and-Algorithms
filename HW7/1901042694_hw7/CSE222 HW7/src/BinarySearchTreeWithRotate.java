public class BinarySearchTreeWithRotate < E
        extends Comparable < E >>
        extends BinarySearchTree < E > {


    protected Node < E > rotateRight(Node < E > root) {
        Node < E > temp = root.leftTree;
        root.leftTree = temp.rightTree;
        temp.rightTree = root;
        return temp;
    }


    protected Node < E > rotateLeft(Node < E > localRoot) {
        Node < E > temp = localRoot.rightTree;
        localRoot.rightTree = temp.leftTree;
        temp.leftTree = localRoot;
        return temp;
    }


}