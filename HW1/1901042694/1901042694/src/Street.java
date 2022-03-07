import java.io.IOException;
import java.io.IOException;
public class Street implements EditingMode,ViewingMode{
    private int Length;
    private Playground []data ;
    int used=0;

    public Street(){
        Playground[] newList = new Playground[100];
        data=newList;
    }


    public int getLength() {
        return Length;
    }

    public void setLength(int length) {
        this.Length = length;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    @Override
    public void add(Playground item) throws Exception {
        int i;
        int count=0;
        boolean flag=false;
        if(item.position>= Length){
            throw new IOException("You need to be enter less than "+ Length);
        }else if(item.position<0){
            throw new IOException("You need to be enter more than 0");
        }
        else{
            if(used==0){
                data[getUsed()]=item;
                ++used;
            }
            else{
                 Playground []data1=new Playground[used] ;
                Playground []data2=new Playground[used] ;
                int count1=0;
                int count2=0;
                if(used==1){
                    if(data[0].getSide()==item.getSide()){
                        if (item.position<Length&&item.position+item.getLength()<=Length&&item.position >= data[0].position
                                && item.position+item.getLength() <= this.getLength()) {
                            flag=true;

                        }
                    }else{
                        flag=true;
                    }
                }else{
                    boolean tempFlag=false;
                        for(i=0;i<used;++i){
                            if(data[i].getSide()==item.getSide()){
                                tempFlag=true;
                                break;
                            }
                        }
                        if(!tempFlag){
                            flag=true;
                        }else{
                            Playground dataTemp[]=new Playground[used];
                            int tempCount=0;
                            for(i=0;i<used;++i) {
                                if(item.getSide()==data[i].getSide()){
                                    dataTemp[tempCount]=data[i];
                                    ++tempCount;
                                }
                            }

                            for(i=0;i<tempCount;i++){
                                try {
                                    if(i==tempCount-1){
                                        if (item.position<Length&&item.position+item.getLength()<=Length&&item.position >= dataTemp[i].position
                                                && item.position+item.getLength() <=  this.getLength()) {
                                            flag=true;

                                            break;
                                        }

                                    } else{

                                        if (item.position<Length&&item.position+item.getLength()<=Length&&item.position >= dataTemp[i].position
                                               && item.position+item.getLength() <=data[i+1].position) {
                                            flag=true;
                                            break;
                                        }
                                    }



                                }catch (Exception e){
                                    System.out.println(e.getLocalizedMessage());
                                }
                            }




                        }

                }
 /*
                               */
                if(flag){

                    data[getUsed()]=item;
                    item.setCheckWidth(1);
                    item.setCheckPosition(1);
                    ++used;
                }

            }

        }

    }
    /*
    @Override
    public void delete(Playground item) throws Exception {
        if(used==0){
            throw new NullPointerException("You cannot delete something");
        }
        if(item.position>= Length){
            throw new IOException("You need to be enter less than "+ Length);
        }else if(item.position<0){
            throw new IOException("You need to be enter more than 0");
        }else{
            int i,j;
            for(i=0;i<used;++i){
                try {
                    if(data[i].equals(item)){
                        for(j=i;j<used;++j){
                            data[j]=data[j+1];
                        }
                        used--;
                    }
                }catch (Exception e){
                }
            }
        }
    }
    */
    @Override
    public void delete(int item) throws Exception {
        if(used==0){
            throw new NullPointerException("You cannot delete something");
        }
        else if(data[item].position>= Length){
            throw new IOException("You need to be enter less than "+ Length);
        }else if(data[item].position+data[item].getLength()>= Length){
            throw new IOException("You need to be enter more than 0");
        }
        else if(item<0){
            throw new IOException("You need to be enter more than 0");
        }
        else{
            int i,j;
            for(i=0;i<used;++i){
                try {
                    if(data[i].equals(data[item])){
                        for(j=i;j<used;++j){
                            data[j]=data[j+1];
                        }
                        used--;
                    }
                }catch (Exception e){
                }
            }
        }
    }

    void Sorted(){
        int i,j;
        for(i=0;i<used-1;++i){
            for(j=i+1;j<used;++j){
                if(data[i].position>data[j].position){
                    Playground temp=data[i];
                    data[i]=data[j];
                    data[j]=temp;
                }
            }
        }
    }
    @Override
    public void View() {
        int leftSide=Length;
        int rightSide=Length;
        int i;
        int totalLength=0;
        for(i=0;i<used;++i){
            if(data[i].getSide()==1){
                rightSide=rightSide-data[i].getLength();

            }
            if(data[i].getSide()==2){
                leftSide=leftSide-data[i].getLength();
            }

        }
        int countForAll=0;
        for(Object items:data){
            if(items instanceof House){
                totalLength+=((House) items).getLength();


            }
            else if(items instanceof Street){
                totalLength+=((Street) items).getLength();

            }
          else   if(items instanceof Office){
                totalLength+=((Office) items).getLength();


            }
            else   if(items instanceof Market){
                totalLength+=((Market) items).getLength();


            }
           else if(items instanceof Playground){
                totalLength+=((Playground) items).getLength();

                countForAll+=((Playground) items).getLength();

            }

        }

        final String ANSI_BG_WHITE  = "\u001B[47m";
        final String ANSI_RESET  = "\u001B[0m";
        int j,k;
        this.Sorted();
        int maxLength=0;
        int maxHeight=0;
        for(i=0;i<used;++i){
            if(maxLength<data[i].getLength()){
                maxLength=data[i].getLength();
            }
            if(maxHeight<data[i].getHeight()){
                maxHeight=data[i].getHeight();
            }

        }

        int [][] arrayTemp= new int[maxHeight][Length];
        for(i=0;i<used;++i){
            for(j=maxHeight-data[i].getHeight();j<maxHeight;++j){
                for(k=data[i].position;k<data[i].position+data[i].getLength();++k){
                    arrayTemp[j][k]=1;
                }
            }
        }
        if(used!=0){
            for(i=0;i<maxHeight;++i){
                for(j=0;j<this.getLength();++j){
                    if(arrayTemp[i][j]==1){
                        System.out.printf(ANSI_BG_WHITE+"  "+ANSI_RESET);
                        // System.out.printf(ANSI_BG_WHITE+"  "+ANSI_RESET);
                    }else{
                        System.out.printf("  ");
                    }

                }
                System.out.println();
            }
        }
        double number=countForAll;
        double number1=2*Length;
        double result=(number/number1)*100.0;
        System.out.println("Ratio playground %"+result);
       System.out.println("Remaining of lands for "+"Right Side "+rightSide+" for Left Side "+leftSide);
       System.out.println(this.toString());
        System.out.println("the total length of street occupied by markets houses or offices : "+totalLength);

    }
    public Playground[] getData() {
        return data;
    }
    public void setData(Buildings[] data) {
        this.data = data;
    }
    public void refreshLength(int length) throws Exception{

    }
    @Override
    public String toString() {
        String returnedValue="";
        int i;
        for(i=0;i<used;++i){
           returnedValue+=data[i].toString();
        }
        return returnedValue;
    }

    @Override
    public boolean equals(Object obj) {
        Street temp= (((Street)obj));
        int i;
        int count=0;
        if(this.used==temp.used&&this.Length==temp.Length){
            for(i=0;i<used;++i){
                if(data[i].equals(temp.getData()[i])){
                    ++count;
                }

            }
            if(count==used){
                return true;
            }else{
                return false;
            }

        }else{
            return false;
        }


    }
}
