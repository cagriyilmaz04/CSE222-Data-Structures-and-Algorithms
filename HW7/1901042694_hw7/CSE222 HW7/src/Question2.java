public class Question2 <E extends Comparable<E>>{

    public AVLTree<E> avlTree =new AVLTree<>();
    @SuppressWarnings("unchecked")
    public AVLTree<E> convert(BinaryTree<Integer> list){
      convert2(list.root);
        return avlTree;
    }
    @SuppressWarnings("unchecked")
    public void convert2(BinaryTree.Node<Integer> list){
        if(list==null){
            return;
        }else{
            avlTree.add((E) list.data);
            convert2(list.leftTree);
            convert2(list.rightTree);
        }
    }

}
