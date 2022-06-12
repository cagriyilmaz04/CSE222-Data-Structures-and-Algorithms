import java.io.Serializable;
import java.util.Scanner;

public class BinaryTree<E> {

    protected static class Node<E> implements Serializable {

        protected E data;

        protected Node<E> rightTree;


        protected Node<E> leftTree;


        public Node( Node<E> left , E data , Node<E> right ) {
            this.leftTree = left;
            this.data = data;
            this.rightTree = right;
        }

        public Node( E data ) {
            this( null , data , null );
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    protected Node<E> root;

    protected BinaryTree() {

        root = null;
    }


    protected BinaryTree( Node<E> root ) {
        this.root = root;
    }

    protected BinaryTree( E data , BinaryTree<E> left , BinaryTree<E> right ) {

        root = new Node<>( data );

        if( left != null ) {
            root.leftTree = left.root;
        }
        else {
            root.leftTree = null;
        }

        if( right != null ) {
            root.rightTree = right.root;
        }
        else {
            root.rightTree = null;
        }

    }
    public BinaryTree<E> getLeftSubtree() {

        if( root != null && root.leftTree != null ) {
            return new BinaryTree<>( root.leftTree );
        }
        else {
            return null;
        }

    }
    public BinaryTree<E> getRightSubtree() {

        if( root != null && root.rightTree != null ) {
            return new BinaryTree<>( root.rightTree );
        }
        else {
            return null;
        }

    }

    public E getData() {
        if( root != null ) {
            return root.data;
        }
        return null;
    }

    public boolean isLeaf() {

        if( root != null ) {
            return ( root.leftTree == null && root.rightTree == null );
        }

        return false;
    }

    public static BinaryTree<String> readBinaryTree( Scanner scan ) {
        String data = scan.next();

        if( data.equals("null")) {
            return null;
        } else {
            BinaryTree<String> leftTree = readBinaryTree(scan);
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<String>( data , leftTree ,rightTree );
        }
    }

    protected void preOrderTraverse( Node<E> node , StringBuilder sb ) {

        if( node != null ) {

            sb.append( node.toString() ).append(" ");
            preOrderTraverse( node.leftTree , sb );
            preOrderTraverse( node.rightTree , sb );

        }
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        preOrderTraverse( root , sb );
        return sb.toString();

    }

    public int getSize(Node<E> data){
        int size=0;
        if(data==null){
            return 0;
        }else{
            size=getSize(data.leftTree)+getSize(data.rightTree)+1;
            return size;
        }


    }
}