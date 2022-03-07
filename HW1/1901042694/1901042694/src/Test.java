import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("-------------------- Welcome ---------------------"
                + "\n <-- Design and Implementing a city planning ");

        boolean flag=true;
        int choice;
        Street TimesStreet= new Street();
        TimesStreet.setLength(50);
        Market market1=new Market(0,0,0,0,"",0,0,TimesStreet);
        Playground playground1=new Playground();
        House house1=new House();
        Office office1=new Office();
        int secondChoice;

        boolean flag1=true;
        while (flag){
            System.out.println("1-) Add your building to the street");
            System.out.println("2-) Remove your building from the street");
            System.out.println("3-) View your street");
            System.out.println("4-) Quick Example");
            System.out.println("5-) Exit");
            System.out.println("Enter a value");
            secondChoice=getInt("First Menu Choice ");
                if(secondChoice>=1&&secondChoice<=4){
                    if(secondChoice==1){
                        while(flag1){
                            System.out.println("1-) Add a Market ");
                            System.out.println("2-) Add a Office");
                            System.out.println("3-) Add a House");
                            System.out.println("4-) Add a Playground");
                            System.out.println("5-) Exit");
                            choice=getInt("Second Menu ");
                            if(choice==5){
                                flag1=false;
                            }
                            else if(!(choice>=1&&choice<=4&&choice!=5)){
                                System.out.println("You need to enter between 1 and 5");
                            }else{
                                int length,height,position,side;
                                String owner;
                                System.out.println("Enter Length ");
                                length=getInt("Length ");
                                System.out.println("Enter weight ");
                                height=getInt("Weight ");
                                System.out.println("Enter position ");
                                position=getInt("Position ");
                                System.out.println("Enter side ");
                                side=getInt("Side ");
                                while (!(side>=1&&side<=2)){
                                    System.out.println("You need to enter 1 or 2 ");
                                    side=getInt("Side ");
                                }
                                try {
                                    if(choice<=3){
                                        System.out.println("Enter owner");
                                        owner=getString("Owner ");
                                        if(choice==1){
                                            int openTime,closeTime;
                                            System.out.println("Enter open time");
                                            openTime=getInt("Open Time ");
                                            System.out.println("Enter close time");
                                            closeTime=getInt("Close Time");
                                            market1.setHeight(height);
                                            market1.setLength(length);
                                            market1.setOwner(owner);
                                            market1.setPosition(position);
                                            market1.setSide(side);
                                            market1.setOpenningTime(openTime);
                                            market1.setClosingTime(closeTime);
                                            TimesStreet.add(market1);

                                        }
                                       else if(choice==2){
                                            String jobType;
                                            System.out.println("Enter a job type");
                                            jobType=getString("Job Type ");
                                            office1.setJobType(jobType);
                                            office1.setHeight(height);
                                            office1.setLength(length);
                                            office1.setOwner(owner);
                                            office1.setPosition(position);
                                            office1.setSide(side);
                                            TimesStreet.add(office1);
                                        }
                                        else {
                                            System.out.println("Enter number of rooms");
                                            int numberOfRooms;
                                            numberOfRooms=getInt("Number of rooms");
                                            house1.setHeight(height);
                                            house1.setLength(length);
                                            house1.setOwner(owner);
                                            house1.setPosition(position);
                                            house1.setSide(side);
                                            house1.setNumberOfRooms(numberOfRooms);
                                            TimesStreet.add(house1);
                                        }
                                    }else{
                                        playground1.setHeight(height);
                                        playground1.setLength(length);
                                        playground1.setPosition(position);
                                        playground1.setSide(side);
                                        TimesStreet.add(playground1);
                                    }
                                }catch (Exception e){
                                    System.out.println(e.getLocalizedMessage());
                                }

                            }
                        }

                    }
                    else if(secondChoice==2){
                        int item;
                        item=getInt("Deleted Value ");
                        try {
                            TimesStreet.delete(item);
                        }catch (Exception e){
                                System.out.println(e.getLocalizedMessage());
                        }
                    }else if(secondChoice==3){
                        TimesStreet.View();
                    }else if(secondChoice==4){
                        QuickExample();
                    }
                }else if(secondChoice==5){
                   System.out.println("Goodbye ...");
                    flag=false;
                    break;
                }else{
                    System.out.println("You need to enter between 1 and 5");
                    secondChoice=getInt("Second Choice ");
                }

        }


    }

    private static void QuickExample() {
        Street LakeStreet = new Street();
        LakeStreet.setLength(50);

        try {

            House house1=new House(5,5,10,"Cagri Yilmaz","Blue",0,1,LakeStreet);
            LakeStreet.add(house1);
            LakeStreet.add(new House(10,10,10,"Emir Yilmaz","Yellow",10,1,LakeStreet));
            House house2=new House(5,5,10,"Furkan Yilmaz","Blue",0,1,LakeStreet);
            LakeStreet.add(new House(16,10,10,"Onur Akbay","Red",10,2,LakeStreet));
            LakeStreet.add(new House(20,10,10,"Gokhan Digircibasi","Yellow",20,1,LakeStreet));
            LakeStreet.add(new Office("Pharmacy",10,10,"Omer Faruk Istemihan",17,1,LakeStreet));
            LakeStreet.add(new Market(8,20,10,10,"Atakan Yilmaz",35,2,LakeStreet));

            if(house1.equals(house2)){
                System.out.println("The same");
            }


           LakeStreet.View();
           LakeStreet.delete(3);
           LakeStreet.View();

        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }


    }

    @SuppressWarnings("resource")
    public static int getInt(String intVal) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(intVal);
        int flag = -1;
        while (flag == -1) {
            try {
                flag = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Wrong input. Try Again");
                scanner.nextLine();
            }
        }
        return flag;
    }
    @SuppressWarnings("resource")
    public static String getString(String str) {
        System.out.print(str);
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine();
        return temp;
    }

}
