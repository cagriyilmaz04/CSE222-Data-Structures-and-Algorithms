import java.util.Arrays;

public class question1 <E extends Comparable<E>>{


    static int index;
    BinarySearchTree<E> datas=new BinarySearchTree<>();

    @SuppressWarnings("unchecked")
    void storeIndorderTo(BinaryTree.Node<E> node, E[] inorder) {

        if (node == null)
            return;

        storeIndorderTo(node.leftTree, inorder);

        inorder[index] = (E) node.data;
        index++;

        storeIndorderTo(node.rightTree, inorder);
    }



    @SuppressWarnings("unchecked")
    void arrayConvertToBST(E[] arr, BinaryTree.Node<E> root) {
        if (root == null)
            return;

        arrayConvertToBST(arr, root.leftTree);
        root.data = arr[index];
        index++;

        arrayConvertToBST(arr, root.rightTree);
    }






    @SuppressWarnings("unchecked")
    BinarySearchTree<E> binaryTreeConvertToBST(BinaryTree<E> root, E [] arr) {
        if (root == null){
        }
        storeIndorderTo(root.root, arr);
        Arrays.sort(arr);
        index = 0;
        arrayConvertToBST(arr, root.root);
        datas.root=root.root;

        return datas;
    }


    @SuppressWarnings("unchecked")
     void printInorderTraverse(BinaryTree.Node<E> node) {
        if (node == null)
            return;

        printInorderTraverse(node.leftTree);
        System.out.print(node.data + " ");
        printInorderTraverse(node.rightTree);
    }



    @SuppressWarnings("unchecked")
    int countTotalNodes(BinaryTree.Node<E> root) {
        if (root == null)
            return 0;
        return countTotalNodes(root.leftTree) + countTotalNodes(root.rightTree) + 1;
    }

}
