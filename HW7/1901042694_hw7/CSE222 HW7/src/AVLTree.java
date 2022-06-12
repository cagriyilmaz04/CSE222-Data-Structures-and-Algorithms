
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;



public class AVLTree < E
        extends Comparable < E >>
        extends BinarySearchTreeWithRotate < E > {

    private boolean increase;

    private boolean decrease;


    private static class AVLNode < E > extends Node < E > {
        public static final int LEFT_HEAVY = -1;


        public static final int BALANCED = 0;


        public static final int RIGHT_HEAVY = 1;


        private int balance;

        public AVLNode(E item) {
            super(item);
            balance = BALANCED;
        }

        public String toString() {
            return balance + ": " + super.toString();
        }
    }

    private ArrayList<E> arr = new ArrayList<>();

    public Iterator<E> iterator() {
        arr.clear();
        iteratorHelper(root);
        Collections.sort(arr);
        return arr.iterator();
    }

    private void iteratorHelper(Node<E> node) {
        if (node == null)
            return;

        else
        {
            arr.add(node.data);
            iteratorHelper(node.leftTree);
            iteratorHelper(node.rightTree);
        }
    }

    public boolean add(E item) {
        increase = false;
        root = add( (AVLNode < E > ) root, item);
        return addReturn;
    }


    private AVLNode < E > add(AVLNode < E > localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            increase = true;
            return new AVLNode < E > (item);
        }

        if (item.compareTo(localRoot.data) == 0) {
            increase = false;
            addReturn = false;
            return localRoot;
        }

        else if (item.compareTo(localRoot.data) < 0) {
            localRoot.leftTree = add( (AVLNode < E > ) localRoot.leftTree, item);

            if (increase) {
                decrementBalance(localRoot);
                if (localRoot.balance < AVLNode.LEFT_HEAVY) {
                    increase = false;
                    return rebalanceLeft(localRoot);
                }
            }
            return localRoot; // Rebalance not needed.
        }
        else {

            localRoot.rightTree = add( (AVLNode < E > ) localRoot.rightTree, item);
            if (increase) {
                incrementBalance(localRoot);
                if (localRoot.balance > AVLNode.RIGHT_HEAVY) {
                    return rebalanceRight(localRoot);
                }
                else {
                    return localRoot;
                }
            }
            else {
                return localRoot;
            }
        }

    }


    public E delete(E item) {
        decrease = false;
        root = delete( (AVLNode < E > ) root, item);
        return deleteReturn;
    }


    private AVLNode < E > delete(AVLNode < E > localRoot, E item) {
        if (localRoot == null) { // item is not in tree
            deleteReturn = null;
            return localRoot;
        }
        if (item.compareTo(localRoot.data) == 0) {
            deleteReturn = localRoot.data;
            return findReplacementNode(localRoot);
        }
        else if (item.compareTo(localRoot.data) < 0) {
            localRoot.leftTree = delete( (AVLNode < E > ) localRoot.leftTree, item);
            if (decrease) {
                incrementBalance(localRoot);
                if (localRoot.balance > AVLNode.RIGHT_HEAVY) {
                    return rebalanceRightL( (AVLNode < E > ) localRoot);
                }
                else {
                    return localRoot;
                }
            }
            else {
                return localRoot;
            }
        }
        else {
            localRoot.rightTree = delete( (AVLNode < E > ) localRoot.rightTree, item);
            if (decrease) {
                decrementBalance(localRoot);
                if (localRoot.balance < AVLNode.LEFT_HEAVY) {
                    return rebalanceLeftR(localRoot);
                }
                else {
                    return localRoot;
                }
            }
            else {
                return localRoot;
            }
        }
    }

    private AVLNode < E > findReplacementNode(AVLNode < E > node) {
        if (node.leftTree == null) {
            decrease = true;
            return (AVLNode < E > ) node.rightTree;
        }
        else if (node.rightTree == null) {
            decrease = true;
            return (AVLNode < E > ) node.leftTree;
        }
        else {
            if (node.leftTree.rightTree == null) {
                node.data = node.leftTree.data;
                node.leftTree = node.leftTree.leftTree;
                incrementBalance(node);
                return node;
            }
            else {
                node.data = findLargestChild( (AVLNode < E > ) node.leftTree);
                if ( ( (AVLNode < E > ) node.leftTree).balance < AVLNode.LEFT_HEAVY) {
                    node.leftTree = rebalanceLeft( (AVLNode < E > ) node.leftTree);
                }
                if (decrease) {
                    incrementBalance(node);
                }
                return node;
            }
        }
    }


    private E findLargestChild(AVLNode < E > parent) {
        if (parent.rightTree.rightTree == null) {
            E returnValue = parent.rightTree.data;
            parent.rightTree = parent.rightTree.leftTree;
            decrementBalance(parent);
            return returnValue;
        }
        else {
            E returnValue = findLargestChild( (AVLNode < E > ) parent.rightTree);
            if ( ( (AVLNode < E > ) parent.rightTree).balance < AVLNode.LEFT_HEAVY) {
                parent.rightTree = rebalanceLeft( (AVLNode < E > ) parent.rightTree);
            }
            if (decrease) {
                decrementBalance(parent);
            }
            return returnValue;
        }
    }

    private void incrementBalance(AVLNode < E > node) {
        node.balance++;
        if (node.balance > AVLNode.BALANCED) {
            increase = true;
            decrease = false;
        }
        else {
            increase = false;
            decrease = true;
        }
    }


    private AVLNode < E > rebalanceRight(AVLNode < E > localRoot) {
        AVLNode < E > rightChild = (AVLNode < E > ) localRoot.rightTree;
        if (rightChild.balance < AVLNode.BALANCED) {
            AVLNode < E > rightLeftChild = (AVLNode < E > ) rightChild.leftTree;
            if (rightLeftChild.balance > AVLNode.BALANCED) {
                rightChild.balance = AVLNode.BALANCED;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.LEFT_HEAVY;
            }
            else if (rightLeftChild.balance < AVLNode.BALANCED) {
                rightChild.balance = AVLNode.RIGHT_HEAVY;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            else {
                rightChild.balance = AVLNode.BALANCED;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            increase = false;
            decrease = true;
            localRoot.rightTree = rotateRight(rightChild);
            return (AVLNode < E > ) rotateLeft(localRoot);
        }
        else {

            rightChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
            increase = false;
            decrease = true;
            return (AVLNode < E > ) rotateLeft(localRoot);
        }
    }

    private AVLNode < E > rebalanceLeftR(AVLNode < E > localRoot) {

        AVLNode < E > leftChild = (AVLNode < E > ) localRoot.leftTree;

        if (leftChild.balance > AVLNode.BALANCED) {

            AVLNode < E > leftRightChild = (AVLNode < E > ) leftChild.rightTree;

            if (leftRightChild.balance < AVLNode.BALANCED) {
                leftChild.balance = AVLNode.LEFT_HEAVY;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            else if (leftRightChild.balance > AVLNode.BALANCED) {
                leftChild.balance = AVLNode.BALANCED;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.RIGHT_HEAVY;
            }
            else {
                leftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }

            increase = false;
            decrease = true;

            localRoot.leftTree = rotateLeft(leftChild);
            return (AVLNode < E > ) rotateRight(localRoot);
        }
        if (leftChild.balance < AVLNode.BALANCED) {

            leftChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
            increase = false;
            decrease = true;
        }
        else {

            leftChild.balance = AVLNode.RIGHT_HEAVY;
            localRoot.balance = AVLNode.LEFT_HEAVY;
        }

        return (AVLNode < E > ) rotateRight(localRoot);
    }

    private AVLNode < E > rebalanceRightL(AVLNode < E > localRoot) {

        AVLNode < E > rightChild = (AVLNode < E > ) localRoot.rightTree;

        if (rightChild.balance < AVLNode.BALANCED) {

            AVLNode < E > rightLeftChild = (AVLNode < E > ) rightChild.leftTree;

            if (rightLeftChild.balance > AVLNode.BALANCED) {
                rightChild.balance = AVLNode.RIGHT_HEAVY;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            else if (rightLeftChild.balance < AVLNode.BALANCED) {
                rightChild.balance = AVLNode.BALANCED;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.LEFT_HEAVY;
            }
            else {
                rightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }

            increase = false;
            decrease = true;

            localRoot.rightTree = rotateRight(rightChild);
            return (AVLNode < E > ) rotateLeft(localRoot);
        }
        if (rightChild.balance > AVLNode.BALANCED) {

            rightChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
            increase = false;
            decrease = true;
        }
        else {

            rightChild.balance = AVLNode.LEFT_HEAVY;
            localRoot.balance = AVLNode.RIGHT_HEAVY;
        }

        return (AVLNode < E > ) rotateLeft(localRoot);
    }


    private AVLNode < E > rebalanceLeft(AVLNode < E > localRoot) {
        AVLNode < E > leftChild = (AVLNode < E > ) localRoot.leftTree;

        if (leftChild.balance > AVLNode.BALANCED) {

            AVLNode < E > leftRightChild = (AVLNode < E > ) leftChild.rightTree;

            if (leftRightChild.balance < AVLNode.BALANCED) {
                leftChild.balance = AVLNode.BALANCED;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.RIGHT_HEAVY;
            }
            else {
                leftChild.balance = AVLNode.LEFT_HEAVY;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }

            localRoot.leftTree = rotateLeft(leftChild);
        }
        else {

            leftChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
        }

        return (AVLNode < E > ) rotateRight(localRoot);
    }

    private void decrementBalance(AVLNode < E > node) {

        node.balance--;
        if (node.balance == AVLNode.BALANCED) {
            increase = false;
        }
    }

}