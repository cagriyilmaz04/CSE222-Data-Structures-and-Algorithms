import java.io.IOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Street implements EditingMode,ViewingMode{
    private int Length;

    private LinkedList<Playground> data ;
    int used=0;

    public Street(){
        LinkedList<Playground> newList = new LinkedList<Playground>();
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
        boolean flag=false;
        if(item.position>= Length){
            throw new IOException("You need to be enter less than "+ Length);
        }else if(item.position<0){
            throw new IOException("You need to be enter more than 0");
        }
        else{
            if(used==0){
                data.add(item);

                ++used;
            }
            else{
                ArrayList<Playground> data1=new ArrayList<Playground>() ;
                ArrayList<Playground>data2=new ArrayList<Playground>() ;
                if(used==1){
                    if(data.get(0).getSide()==item.getSide()){
                        if (item.position<Length&&item.position+item.getLength()<=Length&&item.position >= data.get(0).position
                                && item.position+item.getLength() <= this.getLength()) {
                            flag=true;

                        }
                    }else{
                        flag=true;
                    }
                }else{
                    boolean tempFlag=false;
                        for(i=0;i<used;++i){
                            if(data.get(i).getSide()==item.getSide()){
                                tempFlag=true;
                                break;
                            }
                        }
                        if(!tempFlag){
                            flag=true;
                        }else{
                            ArrayList<Playground> dataTemp=new ArrayList<Playground>();
                            int tempCount=0;
                            for(i=0;i<used;++i) {
                                if(item.getSide()==data.get(i).getSide()){
                                    dataTemp.add(tempCount,data.get(i));
                                    ++tempCount;
                                }
                            }

                            for(i=0;i<tempCount;i++){
                                try {
                                    if(i==tempCount-1){
                                        if (item.position<Length&&item.position+item.getLength()<=Length&&item.position >= dataTemp.get(i).position
                                                && item.position+item.getLength() <=  this.getLength()) {
                                            flag=true;

                                            break;
                                        }

                                    } else{

                                        if (item.position<Length&&item.position+item.getLength()<=Length&&item.position >= dataTemp.get(i).position
                                               && item.position+item.getLength() <=data.get(i+1).position) {
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
                if(flag){
                    data.add(getUsed(),item);
                    item.setCheckWidth(1);
                    item.setCheckPosition(1);
                    ++used;
                }
            }
        }
    }
    @Override
    public void delete(int item) throws Exception {
        if(used==0){
            throw new NullPointerException("You cannot delete something");
        }
        else if(data.get(item).position>= Length){
            throw new IOException("You need to be enter less than "+ Length);
        }else if(data.get(item).position+data.get(item).getLength()>= Length){
            throw new IOException("You need to be enter more than 0");
        }
        else if(item<0){
            throw new IOException("You need to be enter more than 0");
        }
        else{
            data.remove(item);
            --used;
        }
    }

    void Sorted(){
        int i,j;
        for(i=0;i<used-1;++i){
            for(j=i+1;j<used;++j){
                if(data.get(i).position>data.get(j).position){
                    Playground temp=data.get(i);
                    data.add(i,data.get(j));
                    data.add(j,temp);
                }
            }
        }
    }
    @Override
    public void View() {
        int leftSide = Length;
        int rightSide = Length;
        int i;
        int totalLength = 0;

        try {

            for (i = 0; i < used; ++i) {
                Object items= data.get(i);
                if (items instanceof House) {
                    if (((House) items).getSide() == 1) {
                        rightSide = rightSide - data.get(i).getLength();
                    }
                    if (((House) items).getSide() == 2) {
                        leftSide = leftSide - data.get(i).getLength();
                    }
                } else if (items instanceof Office) {
                    if (((Office) items).getSide() == 1) {
                        rightSide = rightSide - data.get(i).getLength();
                    }
                    if (((Office) items).getSide() == 2) {
                        leftSide = leftSide - data.get(i).getLength();
                    }
                } else if (items instanceof Market) {
                    if (((Market) items).getSide() == 1) {
                        rightSide = rightSide - data.get(i).getLength();
                    }
                    if (((Market) items).getSide() == 2) {
                        leftSide = leftSide - data.get(i).getLength();
                    }
                }


            }
            int countForAll = 0;

                for (i = 0; i < used; ++i) {
                Object items= data.get(i);

                if (items instanceof House) {
                    totalLength += ((House) items).getLength();
                    countForAll += ((House) items).getLength();
                } else if (items instanceof Street) {
                    totalLength += ((Street) items).getLength();
                    countForAll += ((Street) items).getLength();
                } else if (items instanceof Office) {
                    totalLength += ((Office) items).getLength();
                    countForAll += ((Office) items).getLength();
                } else if (items instanceof Market) {
                    totalLength += ((Market) items).getLength();
                    countForAll += ((Market) items).getLength();
                } else if (items instanceof Playground) {

                }

            }

            final String ANSI_BG_WHITE = "\u001B[47m";
            final String ANSI_RESET = "\u001B[0m";
            int j, k;
            this.Sorted();
            int maxLength = 0;
            int maxHeight = 0;
            for (i = 0; i < used; ++i) {
                if (maxLength < data.get(i).getLength()) {
                    maxLength = data.get(i).getLength();
                }
                if (maxHeight < data.get(i).getHeight()) {
                    maxHeight = data.get(i).getHeight();
                }

            }

            int[][] arrayTemp = new int[maxHeight][Length];
            for (i = 0; i < used; ++i) {
                for (j = maxHeight - data.get(i).getHeight(); j < maxHeight; ++j) {
                    for (k = data.get(i).position; k < data.get(i).position + data.get(i).getLength(); ++k) {
                        arrayTemp[j][k] = 1;
                    }
                }
            }
            if (used != 0) {
                for (i = 0; i < maxHeight; ++i) {
                    for (j = 0; j < this.getLength(); ++j) {
                        if (arrayTemp[i][j] == 1) {
                            System.out.printf(ANSI_BG_WHITE + "  " + ANSI_RESET);
                            // System.out.printf(ANSI_BG_WHITE+"  "+ANSI_RESET);
                        } else {
                            System.out.printf("  ");
                        }

                    }
                    System.out.println();
                }
            }
            double number = countForAll;
            double number1 = 2 * Length;
            double result = (number / number1) * 100.0;
            System.out.println("Ratio playground %" + result);
            System.out.println("Remaining of lands for " + "Right Side " + rightSide + " for Left Side " + leftSide);
            System.out.println(this.toString());
            System.out.println("the total length of street occupied by markets houses or offices : " + totalLength);
        } catch (Exception e) {
            System.out.println("Anan "+e.getLocalizedMessage()+" B");

        }
    }
    public LinkedList<Playground> getData() {
        return data;
    }
    public void setData(LinkedList<Playground> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String returnedValue="";
        int i;
        for(i=0;i<used;++i){
           returnedValue+=data.get(i).toString();
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
                if(data.get(i).equals(temp.getData().get(i))){
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
