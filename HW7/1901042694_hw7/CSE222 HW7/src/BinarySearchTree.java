import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearchTree < E
        extends Comparable < E >>
        extends BinaryTree < E >
        implements SearchTree < E > {

    protected boolean addReturn;


    protected E deleteReturn;

    public E find(E target) {
        return find(root, target);
    }

    private E find(Node < E > localRoot, E target) {
        if (localRoot == null)
            return null;

        // Compare the target with the data field at the root.
        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0)
            return localRoot.data;
        else if (compResult < 0)
            return find(localRoot.leftTree, target);
        else
            return find(localRoot.rightTree, target);
    }


    public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }

    private Node < E > add(Node < E > localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree � insert it.
            addReturn = true;
            return new Node < E > (item);
        }
        else if (item.compareTo(localRoot.data) == 0) {
            // item is equal to localRoot.data
            addReturn = false;
            return localRoot;
        }
        else if (item.compareTo(localRoot.data) < 0) {
            // item is less than localRoot.data
            localRoot.leftTree = add(localRoot.leftTree, item);
            return localRoot;
        }
        else {
            // item is greater than localRoot.data
            localRoot.rightTree = add(localRoot.rightTree, item);
            return localRoot;
        }
    }


    public E delete(E target) {
        root = delete(root, target);
        return deleteReturn;
    }


    private Node < E > delete(Node < E > localRoot, E item) {
        if (localRoot == null) {
            // item is not in the tree.
            deleteReturn = null;
            return localRoot;
        }

        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
            // item is smaller than localRoot.data.
            localRoot.leftTree = delete(localRoot.leftTree, item);
            return localRoot;
        }
        else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.rightTree = delete(localRoot.rightTree, item);
            return localRoot;
        }
        else {
            // item is at local root.
            deleteReturn = localRoot.data;
            if (localRoot.leftTree == null) {
                // If there is no left child, return right child
                // which can also be null.
                return localRoot.rightTree;
            }
            else if (localRoot.rightTree == null) {
                // If there is no right child, return left child.
                return localRoot.leftTree;
            }
            else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.leftTree.rightTree == null) {
                    // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.leftTree.data;
                    // Replace the left child with its left child.
                    localRoot.leftTree = localRoot.leftTree.leftTree;
                    return localRoot;
                }
                else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node�s data with ip.
                    localRoot.data = findLargestChild(localRoot.leftTree);
                    return localRoot;
                }
            }
        }
    }

    public boolean remove(E target) {
        return delete(target) != null;
    }

    public boolean contains(E target) {
        return find(target) != null;
    }

    private E findLargestChild(Node < E > parent) {
        // If the right child has no right child, it is
        // the inorder predecessor.
        if (parent.rightTree.rightTree == null) {
            E returnValue = parent.rightTree.data;
            parent.rightTree = parent.rightTree.leftTree;
            return returnValue;
        }
        else {
            return findLargestChild(parent.rightTree);
        }
    }
    static int index;
    void storeInorder(BinaryTree.Node<E> node, E inorder[]) {

        if (node == null)
            return;
        storeInorder(node.leftTree, inorder);
        inorder[index] = node.data;
        index++;

        storeInorder(node.rightTree, inorder);
    }
    @SuppressWarnings("unchecked")
     void binaryTreeToBST(BinaryTree<E> root)
    {

        if (root == null){

            return;
        }


        int n =root.getSize(root.root);


        E[] arr = (E[]) new Comparable[n];

        storeInorder(root.root, arr);
        Arrays.sort(arr);
        index = 0;

        arrayToBST(arr, root.root);


    }

    void arrayToBST(E[] arr, BinaryTree.Node<E> root) {

        if (root == null)
            return;

        arrayToBST(arr, root.leftTree);


        root.data = arr[index];
        index++;

        arrayToBST(arr, root.rightTree);
    }

    public void print(Node<E> root1){
        
        if(root1==null){
            return;
        }else{
            System.out.println(root1.data);
            print(root1.rightTree);
            print(root1.leftTree);

        }


    }



}
