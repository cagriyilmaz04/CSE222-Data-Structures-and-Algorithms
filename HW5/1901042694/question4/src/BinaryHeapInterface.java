import com.sun.source.tree.BinaryTree;

public interface BinaryHeapInterface<E extends Comparable<E>> {


   public BinaryHeap.Node find(BinaryHeap.Node  item);
    void add( BinaryHeap.Node item );
    boolean remove(BinaryHeap.Node item) throws IllegalStateException;
    public boolean mergeTwoHeaps(BinaryHeap<E> second) ;
    boolean incrementKeyValue(int index, E newValue);

    int getLeftChildIndex(int parentIndex);
    int getRightChildIndex(int parentIndex);
    int getParentIndex(int childIndex);
    boolean hasLeftChild(int index);
    boolean hasRightChild(int index);
    boolean hasParent(int index);
    BinaryHeap.Node leftChild(int index);
    BinaryHeap.Node  rightChild(int index);
    BinaryHeap.Node  parent(int index);
    int compare(BinaryHeap.Node left,BinaryHeap.Node right)throws IllegalStateException;
    void Change(int first, int second ) throws IndexOutOfBoundsException;
    void heapifyUp();
    void heapifyDown();
    void heapifyDown( int index );


}