import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class BinaryHeap<E extends Comparable<E> > implements BinaryHeapInterface<E> {

    protected ArrayList<Node> dataList;

    Comparator<Node > comparator = null;

    public BinaryHeap() {
        dataList = new ArrayList<Node>();
    }

    public BinaryHeap(Comparator<Node> comp ) {
        this();
        comparator = comp;
    }
    //Override

    @Override
    public String toString() {
        StringBuilder data=new StringBuilder();
        int i;
        for(i=0;i<dataList.size();++i){
            data.append(dataList.get(i).toString()+" ");
        }
        return data.toString();
    }
    @Override
    @SuppressWarnings("unchecked")
    public Node find(Node item) {
        for (BinaryHeap.Node theDatum : dataList) {
            if ( theDatum.data.compareTo(item.data ) == 0 ) {
                return theDatum;
            }
        }
        return null;
    }
    @Override
    @SuppressWarnings("unchecked")
    public int compare(Node left, Node right) throws IllegalStateException{
        if( comparator != null ) {
            return comparator.compare( left ,right );
        } else {
            if(left.getClass()==right.getClass()){
                return left.data.compareTo(right.data);
            }else{
                throw new IllegalStateException();
            }

        }
    }
    @Override
    public void add(Node item) {
        dataList.add(item);
        heapifyUp();
    }



    int flag=0;
    @Override
    public void heapifyUp() {
        int index = dataList.size() - 1;

        while (this.hasParent(index)&&(compare(parent(index),dataList.get(index)) < 0)){

            Change(getParentIndex(index),index);
            index = getParentIndex(index);
        }
    }
    @Override
    public void Change(int first, int second) throws IndexOutOfBoundsException {

        if (first < 0 || second < 0 || (first > dataList.size() - 1) || (second > dataList.size() - 1) ) {
            throw new IndexOutOfBoundsException();
        }

        Node  tempData = dataList.get(first);
        dataList.set(first, dataList.get(second) );
        dataList.set(second,tempData );
    }


    @Override
    public int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    @Override
    public int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }
    @Override
    public int getParentIndex(int childIndex) {
        return ( childIndex - 1 ) / 2;
    }

    @Override
    public boolean hasLeftChild(int index) {
        return getLeftChildIndex( index ) < dataList.size();
    }


    @Override
    public boolean hasRightChild(int index) {
        return getRightChildIndex( index ) < dataList.size();
    }
    @Override
    public boolean hasParent(int index) {
        return getParentIndex( index ) >= 0;
    }

    @Override
    public Node leftChild(int index) {
        return dataList.get( getLeftChildIndex(index));
    }

    @Override
    public Node rightChild(int index) {
        return dataList.get( getRightChildIndex(index));
    }

    @Override
    public Node parent(int index) {
        return dataList.get( getParentIndex(index));
    }

    @Override
    public void heapifyDown() {
        heapifyDown( 0 );
    }
    @Override
    @SuppressWarnings("unchecked")
    public boolean mergeTwoHeaps(BinaryHeap<E> second) {
        for(int i = 0; i<second.dataList.size(); i++){
            E datas= (E) second.dataList.get(i).data;
            this.add(new Node<E>( datas));

        }
        return true;
    }
    @Override
    @SuppressWarnings("unchecked")
    public void heapifyDown(int index) {
        while (hasLeftChild(index)==true) {
            int small = getLeftChildIndex( index );

            if(hasRightChild(index) && (compare(rightChild(index), leftChild(index)) > 0 )  ) {
                small = getRightChildIndex( index );
            }
            if(this.compare(dataList.get(index),dataList.get(small)) > 0 ) {
                break;
            } else {
                Change(index,small);
            }
            index = small;
        }
    }
    @Override
    public boolean remove(Node item) throws IllegalStateException {
        if( dataList.size() == 0 ) {
            throw new IllegalStateException();
        }
        int index = dataList.indexOf(find(item));
        if( index == -1 ) {
            return false;
        }
        Change(index ,dataList.size() - 1);
        dataList.remove( dataList.size() - 1 );

        //When we delete a element we need to reorder so heapifyDown does that.


         heapifyDown(index);

        return true;
    }
    @Override
    @SuppressWarnings("unchecked")
    public boolean incrementKeyValue(int index, E newValue) {
        flag=1;
        if(index > dataList.size()){
            System.out.println("Index can not be greater than size");
            return false;
        }
        remove(this.find(dataList.get(index)));
        ArrayList<Node> temp=new ArrayList<Node>();
        temp.addAll(dataList);
        dataList.clear();
        add(new Node<E>(newValue));
        for(int i=0;i<temp.size();++i){
            if(newValue.getClass()==dataList.get(i).data.getClass()){
                E datas= (E) dataList.get(i).data;

                dataList.add(new Node<>(datas));
            }


        }
        return true;
    }



    protected static class Node < E extends Comparable<E> > implements Serializable {

        protected E data;

        protected Node < E > left;

        protected Node < E > middle;

        protected Node < E > right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
            middle = null;
        }

        public String toString() {
            return data.toString();
        }

    }



}
