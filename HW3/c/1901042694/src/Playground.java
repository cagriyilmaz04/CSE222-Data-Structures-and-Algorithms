public class Playground extends BaseClass {
    Playground(){

    }
    Playground( int width,
                int height,
                int position,
                int side,
                Street ourStreet){
        this.setHeight(height);
        this.setLength(width);
        this.setPosition(position);
        this.setSide(side);
        this.setOurStreet(ourStreet);
    }
    @Override
    public void setCheckPosition(int checkPos) {
        super.setCheckPosition(checkPos);
    }

    @Override
    public int getPosition() {
        return super.getPosition();
    }

    @Override
    public void setPosition(int Position) {
        boolean flag=false;
        if(getCheckPosition()==0){
            flag=true;
        }else if(getCheckPosition()==1){
            int i=0;
            for(i=0;i<getOurStreet().getUsed();++i){
                if(this.getSide()==getOurStreet().getData().get(i).getSide()){
                    if(this.equals(getOurStreet().getData().get(i))){
                        if(i+1!=getOurStreet().getUsed()){
                            if(Position<=getOurStreet().getData().get(i+1).position&&Position+this.getLength()<=getOurStreet().getData().get(i).position){
                                flag=true;
                                break;
                            }
                        }else{
                            if(Position<=getOurStreet().getLength()&&Position+this.getLength()<=getOurStreet().getLength()){
                                flag=true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        if(flag==true){
            super.setPosition(Position);
        }else{
            super.setPosition(this.position);
        }
    }

    @Override
    public int getCheckPosition() {
        return super.getCheckPosition();
    }

    @Override
    public int getCheckWidth() {
        return super.getCheckWidth();
    }

    @Override
    public void setCheckWidth(int checkWidth) {
        super.setCheckWidth(checkWidth);
    }

    @Override
    public String focus() {
        return super.focus();
    }

    @Override
    public int getSide() {
        return super.getSide();
    }

    @Override
    public void setSide(int side) {
        super.setSide(side);
    }

    @Override
    public int getHeight() {
        return super.getHeight();
    }

    @Override
    public int getLength() {
        return super.getLength();
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }

    @Override
    public void setLength(int length) {
        int i;
        boolean flag=false;
        if(getCheckWidth()==0){
            flag=true;
            super.setLength(length);
        }else{
            if(getOurStreet()!=null){
                if(getOurStreet().getUsed()==0){super.setLength(length);}
                else{
                    getOurStreet().Sorted();
                    System.out.println(getOurStreet().toString());
                    for(i=0;i<getOurStreet().getUsed();++i){
                        if(this.getSide()==getOurStreet().getData().get(i).getSide()){
                            //Width 15 Position 20
                            int first=getOurStreet().getData().get(i).position+getOurStreet().getData().get(i).getLength();
                            try {
                                if(getOurStreet().getData().get(i+1).equals(this)){
                                    if(i+2==getOurStreet().used){
                                        if(this.position+length<=getOurStreet().getLength()){
                                            flag=true;
                                            break;
                                        }
                                    }
                                    else{
                                        if(this.getSide()==getOurStreet().getData().get(i+2).getSide()&&this.position+length<=getOurStreet().getData().get(i+2).position){
                                            flag=true;
                                            break;
                                        }
                                    }
                                }
                            }catch (Exception e){

                            }
                        }
                    }
                }
            }
            if(flag){
                super.setLength(length);
            }else{
                super.setLength(this.getLength());
            }
        }
    }

    @Override
    public Street getOurStreet() {
        return super.getOurStreet();
    }

    @Override
    public void setOurStreet(Street ourStreet) {
        super.setOurStreet(ourStreet);
    }

    @Override
    public boolean equals(Object obj) {
        Playground temp= (((Playground)obj));
        if(this.getSide()==temp.getSide()&&this.position==temp.position&&
                this.getLength()==temp.getLength()&&this.getHeight()==temp.getHeight()){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        String returnedValue="";
        returnedValue+="Position "+this.position+" Side "+this.getSide()+" Length "+this.getLength()+" Height "+this.getHeight()+"\n";
        return returnedValue;
    }
}