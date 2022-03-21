import java.util.ListIterator;

public class Buildings extends Playground {

    private String owner;


    public Buildings() {


    }
    @Override
    public void setCheckPosition(int checkPos) {
        super.setCheckPosition(checkPos);
    }

    @Override
    public int getCheckPosition() {
        return super.getCheckPosition();
    }

    public String getOwner() {return owner;}

    public void setOwner(String owner) {this.owner = owner;}

    @Override
    public int getPosition() {
        return super.getPosition();
    }

    @Override
    public void setPosition(int Position) {
        super.setPosition(Position);
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
    public Street getOurStreet() {
        return super.getOurStreet();
    }

    @Override
    public void setOurStreet(Street ourStreet) {
        super.setOurStreet(ourStreet);
    }

    @Override
    public boolean equals(Object obj) {
        Buildings temp= (((Buildings)obj));
        if(this.getSide()==temp.getSide()&&this.position==temp.position&&
                this.getLength()==temp.getLength()&&this.getHeight()==temp.getHeight()&&this.owner==temp.owner&&this.getOurStreet()==temp.getOurStreet()){
            return true;
        }else{
            return false;
        }
    }

}
