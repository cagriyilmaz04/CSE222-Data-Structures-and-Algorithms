public class main {
    public static void main(String[] args){
        BinaryHeap<Integer> data=new BinaryHeap<Integer>();
    BinaryHeap.Node<Integer> a= new BinaryHeap.Node<Integer>(5);
        BinaryHeap.Node<Integer> b= new BinaryHeap.Node<Integer>(12);
        BinaryHeap.Node<Integer> c= new BinaryHeap.Node<Integer>(7);
        BinaryHeap.Node<Integer> d=new  BinaryHeap.Node<Integer>(2);
        data.add(new  BinaryHeap.Node<Integer>(14));
        data.add(new  BinaryHeap.Node<Integer>(160));
        data.add(a);
        data.add(b);
        data.add(c);
        data.add(d);
        System.out.println(data.toString());
        try {
            System.out.println(data.find(a));
            System.out.println(data.parent(0));
            data.remove(c);
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        data.incrementKeyValue(4,789);
       System.out.println(data.toString());
        BinaryHeap<Integer> data1=new BinaryHeap<>();
        data1.add(new  BinaryHeap.Node<>(1));
        data1.add(new  BinaryHeap.Node<>(16));
        data1.add(new  BinaryHeap.Node<>(45));
        data1.add(new  BinaryHeap.Node<>(34));
        data1.add(new  BinaryHeap.Node<>(617));
        data1.add(new  BinaryHeap.Node<>(57));
        data.mergeTwoHeaps(data1);
        System.out.println(data.toString());







    }
}
