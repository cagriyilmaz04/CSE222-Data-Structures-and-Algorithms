import java.util.*;

public class LDLinkedList<E> extends AbstractList<E> implements List<E>, Collection<E> {
    private int used=0;
    private LDLinkedList.Node<E> head=null;
    private LDLinkedList.Node<E> tail=null;
    private LinkedList<LDLinkedList.Node<E>> lazy=new LinkedList<LDLinkedList.Node<E>>();
    private static class Node<E>{
        private E data;
        private LDLinkedList.Node<E> next=null;
        private Node<E> prev=null;

        private Node(E dataItem) {
            data = dataItem;
        }

        public E getData() {
            return data;
        }

        @Override
        public boolean equals(Object obj) {
            Node temp= (LDLinkedList.Node) obj;
            if(data.getClass()==temp.data.getClass()){
                return this.data.equals(temp.data);
            }else{
                return false;
            }


        }
    }
    public int cont(E item){
        int i=0;
        boolean flag=false;
        while(lazy.get(i)!=null){
            if(lazy.get(i).data.equals(item)){
                flag=true;
                return i;
            }
            ++i;
        }
        return -1;
    }

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getTail() {
        return tail;
    }

    private void setUsed(int used) {
        this.used = used;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
    private int getUsed() {
        return used;
    }
    private void addLast(E item){

        LDLinkedList.Node<E> temp=new LDLinkedList.Node<E>(item);

        int Index=lazy.indexOf(temp);

        if(Index==-1){
            //Node<E> temp=new Node<E>(item);
            subAdd(temp);
        }else{
            subAdd(lazy.get(Index));
        }



    }

    private void SubAddFirst(Node<E> data){
        if(head==null){
            head=data;
            head.next=tail;
            tail=data;
        }else{
            head.prev=data;
            data.next=head;
            head=data;
        }
        ++used;

    }
    private void subAdd(LDLinkedList.Node<E> item){


        LDLinkedList.Node<E> last = head; /* used in step 5*/

        /* 3. This new node is going to be the last node, so
         * make next of it as NULL*/
        item.next = null;

        /* 4. If the Linked List is empty, then make the new
         * node as head */
        if (head == null) {
            item.prev = null;
            head = item;
            return;
        }

        /* 5. Else traverse till the last node */
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = item;

        /* 7. Make last node as previous of new node */
        item.prev = last;

        used++;


    }

    @Override
    public String toString() {
        String returnedValue="";
        int i;

        Node<E> temp=head;

        while (temp!=null){

            returnedValue +=temp.data.toString();
            temp=temp.next;
        }

        return returnedValue;
    }
    @Override
    public int size() {
        return getUsed();
    }
    @Override
    public boolean isEmpty() {
        boolean flag=false;
        if(size()!=0){
            flag=true;
        }
        return flag;
    }
    public E getFirst(){
        if(head==null){
            throw new NullPointerException();
        }else{
            return head.data;
        }
    }
    public E getLast(){
        if(tail==null){
            throw new NullPointerException();
        }else{
            return tail.data;
        }
    }

    @Override
    public boolean contains(Object o) {
        LDLinkedList data= (LDLinkedList) o;
        boolean flag=false;
        for(int i=0;i<size();++i){
            this.head=this.head.next;
        }
        if(this.head.data.equals(data.head.data)){
            flag=true;
        }
        return flag;
    }
    private void addFirst(E item){
        int Index=lazy.indexOf(item);

        if(Index!=-1){

            SubAddFirst(lazy.get(Index));
        }else{
            Node<E> newNode= new Node<E>(item);
            SubAddFirst(newNode);
        }
    }
    @Override
    public boolean add(E e) {
        boolean flag=false;
        if(size()==0){
            addFirst(e);
            flag=true;
        }else{

            addLast(e);
            flag=true;
        }
        return flag;
    }


    @Override
    public void clear() {
        head=null;
        tail=null;
        used=0;


    }


    private Node<E> getNode(int index){
        Node<E> node=this.head;
        for(int i=0;i<index&&node!=null;++i){
            node=node.next;
        }
        return node;
    }
    @Override
    public E get(int index) {
        return listIterator(index).next();

    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }
    private void delete(Node<E> deleted){
        if(tail==null){
            throw new IllegalStateException();
        }else{

            if(deleted.next!=null){
                deleted.next.prev= deleted.prev;
            }
            if(deleted.prev!=null){
                deleted.prev.next=deleted.next;
            }
            lazy.add(deleted);

            --used;
        }
        //deleted=null;

    }

    @Override
    public E remove(int index)  {
        if(index<0||index>size()){
            throw new IndexOutOfBoundsException("Out of bounds");
        }else{
            if(head==null){

                throw new NullPointerException();
            }else{
                Node<E> cagri=head;
                for(int i=0;i<index&&cagri.next!=null;++i){
                    cagri=cagri.next;
                }

                delete(cagri);
                return cagri.prev.data;
            }
        }

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }


        public class LDListIter implements ListIterator<E> {
            private LDLinkedList.Node<E> next = null;
            private LDLinkedList.Node<E> returned = null;
            private int index = 0;

            public LDListIter(int index) {


                if (index < 0 || index > size()) {
                    throw new IndexOutOfBoundsException();
                }
                if (index == size()) {
                    index = size();

                    next = null;
                } else {
                    next = (LDLinkedList.Node<E>) head;

                    for (this.index = 0; this.index < index; this.index++) {

                        next = next.next;

                    }


                }
            }

            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public E next() {

                if (!hasNext()) {
                    throw new NoSuchElementException("There is no such an element");
                } else {
                    returned = next;
                    next = next.next;
                    index++;
                    return returned.data;
                }
            }

            @Override
            public boolean hasPrevious() {
                return (next == null && size() != 0) || next.prev != null;
            }

            @Override
            public E previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                if (next == null) {
                    next = tail;
                } else {
                    next = next.prev;
                }
                returned = next;
                index--;
                return returned.data;
            }

            @Override
            public int nextIndex() {
                return index;
            }

            @Override
            public int previousIndex() {
                return index - 1;
            }

            @Override
            public void remove() {
                if (next == null) {
                    throw new NullPointerException();
                }
                if (head == next) {
                    head = next.next;
                }
                if (next.next != null) {
                    next.next.prev = next.prev;
                }
                if (next.prev != null) {
                    next.prev.next = next.next;
                }

            }

            @Override
            public void add(E e) {
                Node<E> val = new Node<E>(e);
                if (head == null) {
                    head = val;
                    head.prev = null;
                    tail.next = null;

                } else {
                    next.next = val;
                    val.prev = tail;
                    tail = val;
                    tail.next = null;

                }

            }

            @Override
            public void set(E e) {
                if (returned == null) {
                    throw new IllegalStateException();
                } else {
                    returned.data = e;
                }

            }
        }



    @Override
    public ListIterator<E> listIterator(int index) {
        return new LDListIter(index);
    }


}
