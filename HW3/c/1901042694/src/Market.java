public class Market extends Buildings  {
    private int openningTime;
    private int closingTime;
    private Street street;

    Market(int Open,int Close,int Height,int Length,String owner,int Position,int Side,Street tempStreet) {
        this.openningTime=Open;
        this.closingTime=Close;
        this.setHeight(Height);
        this.setLength(Length);
        this.setOwner(owner);
        this.setPosition(Position);
        this.setSide(Side);
        this.setOurStreet(tempStreet);
    }
    Market(){

    }

    public int getOpenningTime() {
        return openningTime;
    }

    public void setOpenningTime(int openningTime) {
        this.openningTime = openningTime;
    }

    public int getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(int closingTime) {
        this.closingTime = closingTime;
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
        super.setLength(length);
    }
    @Override
    public String getOwner() {
        return super.getOwner();
    }

    @Override
    public void setOwner(String owner) {
        super.setOwner(owner);
    }


    @Override
    public int getPosition() {
        return super.getPosition();
    }

    @Override
    public void setPosition(int Position) {
        super.setPosition(Position);
    }

    @Override
    public String toString() {
        return String.format("Market "+"Openning Time "+openningTime+ " Closing Time "+closingTime+" Length "+ this.getLength()+" Height "+getHeight()+" Position "+position+" Owner "+getOwner()+" Side "+getSide()+"\n");
    }

    @Override
    public String focus() {
        return String.valueOf(closingTime);
    }

    @Override
    public boolean equals(Object obj) {
        Market temp= (((Market)obj));
        if(this.closingTime==temp.closingTime&&this.openningTime==temp.openningTime){
            return super.equals(obj);
        }else{
            return false;
        }
    }
}

