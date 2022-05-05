public class main {
    public static void main(String[] args){
        BST<Integer> data=new BST<>(10);
        data.add(25);
        data.add(2);
        data.add(1);
        data.add(67);
        data.add(63);
        data.add(12);
        data.add(212);
        data.PrintTree();
        System.out.println();
        try {
            data.remove(2);
            data.PrintTree();
            data.delete(1);
            data.PrintTree();
            System.out.println();
            System.out.println(data.find(212));
            System.out.println(data.contains(2122));

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }


    }

}
