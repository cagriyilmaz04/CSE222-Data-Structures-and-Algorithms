public class Office extends Buildings{
    private String jobType;
    private Street street;
    Office(String Job,int Height,int Length,String owner,int Position,int Side,Street tempStreet) {
        jobType=Job;
        this.setHeight(Height);
        this.setLength(Length);
        this.setOwner(owner);
        this.setPosition(Position);
        this.setSide(Side);
        street=new Street();
        this.setOurStreet(tempStreet);
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
    public int getHeight() {
        return super.getHeight();
    }
    @Override
    public void setHeight(int height) {
        super.setHeight(height);
    }

    @Override
    public int getLength() {
        return super.getLength();
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

    public String getJobType() {return jobType;}

    public void setJobType(String jobType) {this.jobType = jobType;}

    @Override
    public String toString() {
        return String.format("Office "+"Job Type: "+jobType+ " Length "+ this.getLength()+" Height "+getHeight()+" Owner "+getOwner()+" position "+getPosition()+"\n");
    }

    public Office() {
        super();
    }

    @Override
    public String focus() {
        return getJobType();
    }

    @Override
    public boolean equals(Object obj) {
        Office temp= (((Office)obj));
        if(this.jobType==temp.jobType){
            return super.equals(obj);
        }else{
            return false;
        }

    }
}
