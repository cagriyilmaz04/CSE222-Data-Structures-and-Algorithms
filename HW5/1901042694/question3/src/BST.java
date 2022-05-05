import java.util.Comparator;

public class BST<E extends Comparable<E>> implements SearchTree<E>{

    private Object[] Parents;

    static int size = 0;
    int Size;
    public BST(int size) {
        Parents = new Object[size];
        Size=size;
    }


    public void Root(E key) { Parents[0] = key; }


    //These functions inherit from Search Tree Interface

 //
 @SuppressWarnings("unchecked")
    @Override
    public boolean add(E item){

        int compare,index = 0;
        boolean flag = true;
        while(flag) {
            if (Parents[index] == null) {
                Parents[index] = item;
                flag  = false;
            }
            if(item.getClass()==Parents[index].getClass()){
                compare = item.compareTo((E) Parents[index]);
                if(compare==0){
                    flag=false;
                }
                else if(compare<0){
                    index = index * 2 + 1;
                }else{
                    index = index * 2 + 2;
                }
            }
        }
        size++;
        return true;
    }
    @Override
    public boolean contains(E target) {
        boolean flag=false;
        for(int i = 0; i< Parents.length; i++){
            if(Parents[i] == target){
                flag=true;
                break;
            }
        }
        return flag;
    }
    @SuppressWarnings("unchecked")
    @Override
    public E find(E target) {
        if(contains(target)){
            for(int i = 0; i< Parents.length; i++){
                if(Parents[i].getClass()==target.getClass()){
                    if(Parents[i] == target){
                        return (E) Parents[i];
                    }
                }
            }
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    @Override
    public E delete(E target) {

        if(!contains(target)){
            return null;
        }

        for(int i=0;i<Size;i++){
            if(Parents[i]==target){
                Parents[i] = null;
                for(int j = i; j< Parents.length-1; j++){
                    Parents[j]= Parents[j+1];
                }
                --Size;
            }
        }

        BST<E> myBSTnew = new BST<E>(Size);
        for(int i = 0; i< Parents.length; i++){
            if(Parents[i] != null){
                myBSTnew.add((E) Parents[i]);
            }
        }
        for(int i = 0; i< Size; i++){
            Parents[i]= myBSTnew.Parents[i];
        }
        return target;
    }

    @Override
    public boolean remove(E target) {
        boolean flag=false;
        if(this.delete(target) != null){
            --Size;
            flag= true;
        }
        else{
            throw new  IllegalStateException();
        }
        return flag;
    }

    public void PrintTree() {
        for (int i = 0; i < Parents.length; i++) {
            if (Parents[i] != null)
                System.out.print(Parents[i].toString()+" ");
            else
                System.out.print("-");
        }
    }


}



