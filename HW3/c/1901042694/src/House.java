public class House extends Buildings {
    private int numberOfRooms;
    private String color;
    private Street street;

    public House(int numberOfRooms, int length, int height, String Owner, String Color, int Position,int Side ,Street tempStreet) {
        this.numberOfRooms=numberOfRooms;
        this.setLength(length);
        this.setHeight(height);
        this.setOwner(Owner);
        this.setColor(Color);
        this.setPosition(Position);
        this.setSide(Side);
        street=new Street();
        street=tempStreet;
    }
    public House(){

    }
    private int checkWidth =0;
    @Override
    public int getCheckPosition() {
        return    super.getCheckPosition();
    }
    @Override
    public void setCheckPosition(int Position) {
        super.setCheckPosition(Position);
    }

    public int getCheckWidth() {
        return checkWidth;
    }

    public void setCheckWidth(int checkWidth) {
        this.checkWidth = checkWidth;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
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
        return String.format("House "+"Number of rooms "+numberOfRooms+" Color "+color+" Height "+getHeight()+" Length "+ this.getLength()+" Owner "+getOwner()+ " Position "+position+" Side "+getSide()+"\n");
    }

    @Override
    public String focus() {
        return getOwner();
    }

    @Override
    public boolean equals(Object obj) {
        House temp= (((House)obj));

        if(this.color==temp.color&&this.numberOfRooms==temp.numberOfRooms&&this.street==temp.street){
            return super.equals((House)obj);
        }else{
            return false;
        }
    }

}

