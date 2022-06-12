public class main {

        public static void main(String[] args ) {

            // QUESTION 1
            question1 first=new question1();

            BinaryTree.Node<Integer> datas2=new BinaryTree.Node<Integer>(21);
            BinaryTree.Node<Integer> datas4=new BinaryTree.Node<Integer>(19);
            BinaryTree.Node<Integer> datas3=new BinaryTree.Node<Integer>(24);
            datas2.rightTree=datas3;
            datas2.leftTree=datas4;
            BinaryTree.Node<Integer> datas1=new BinaryTree.Node<Integer>(27);
            datas1.rightTree= new BinaryTree.Node<Integer>(28);
            datas1.leftTree= new BinaryTree.Node<Integer>(26);
            BinaryTree firstBinary=new BinaryTree<>(datas2);
            BinaryTree secondBinary=new BinaryTree(datas1);
            BinaryTree<Integer> bt=new BinaryTree(25,firstBinary,secondBinary);
            final int count=first.countTotalNodes(bt.root);
            StringBuilder str1=new StringBuilder();
            bt.preOrderTraverse(bt.root,str1);
            System.out.println(str1.toString());
            Integer[] dataArray=new Integer[count];
            BinarySearchTree<Integer> bst=first.binaryTreeConvertToBST(bt,dataArray);
            first.printInorderTraverse(bst.root);



            //Question 2
            Question2 second=new Question2();
            BinaryTree.Node<Integer> node=new BinaryTree.Node<Integer>(35);
            node.rightTree=new BinaryTree.Node<Integer>(45);
            node.leftTree=new BinaryTree.Node<Integer>(25);
            node.rightTree.rightTree=new BinaryTree.Node<Integer>(55);
            node.leftTree.leftTree=new BinaryTree.Node<Integer>(20);
            node.rightTree.rightTree.rightTree=new BinaryTree.Node<Integer>(65);
            node.rightTree.rightTree.rightTree.rightTree=new BinaryTree.Node<Integer>(75);
            node.rightTree.rightTree.rightTree.rightTree.rightTree=new BinaryTree.Node<Integer>(85);
            BinaryTree<Integer> binaryTreeLeft=new BinaryTree<>(node.leftTree);
            BinaryTree<Integer> binaryTreeRight=new BinaryTree<>(node.rightTree);
            BinaryTree<Integer> binaryTree=new BinaryTree<Integer>(node.data,binaryTreeLeft,binaryTreeRight);
            System.out.println();
            AVLTree<Integer> avl=new AVLTree<Integer>();
            avl=second.convert(binaryTree);
            System.out.println("Question 2 ");
            StringBuilder str2=new StringBuilder();
            avl.preOrderTraverse(binaryTree.root,str2);
            System.out.println(str2.toString());

        }




}
