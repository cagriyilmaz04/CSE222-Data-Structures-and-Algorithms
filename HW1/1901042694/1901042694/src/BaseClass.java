public class BaseClass {
    private int width;
    private int height;
    int position;
    private int side;
    private int check=0;
    private int checkPos=0;
    private Street ourStreet= new Street();
    public void setCheckPosition(int checkPos) {
        this.checkPos = checkPos;
    }
    public int getPosition() {return position;}

    public void setPosition(int position) {this.position = position;}
    public int getCheckPosition() {
        return checkPos;
    }

    public int getCheckWidth() {
        return check;
    }

    public void setCheckWidth(int checkWidth) {
        this.check = checkWidth;
    }

    public BaseClass() {
        super();
    }
    public String focus(){
        return String.valueOf(position);
    }
    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLength(int width) {
        this.width = width;
    }

    public Street getOurStreet() {
        return ourStreet;
    }
    public void setOurStreet(Street ourStreet) {
        this.ourStreet = ourStreet;
    }
    @Override
    public boolean equals(Object obj) {
        if(this==((BaseClass)obj)){
            return true;
        }else{
            return false;
        }
    }
}
