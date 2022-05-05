import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args){
        //Question1 Test
        System.out.println("Question 1");
        System.out.println(findNumberOfStrings("acagribcagriccagri","cagri",4,0,0));
        System.out.println(findNumberOfStrings("acagribcagriccagri","cagri",3,0,0));
        System.out.println(findNumberOfStrings("AcagriiBemirXemir","emir",1,0,0));
        System.out.println("Question 2");
        System.out.println(findItemNumberBetweenTwoNumbers(5,30));
        System.out.println(findItemNumberBetweenTwoNumbers(15,60));
        System.out.println(findItemNumberBetweenTwoNumbers(35,100));
        System.out.println("Question 3");
       test();
        findAll(new int[7],0);
        int[][] dizi=new int[4][4];
        int length=4,leftDirections=1,numberOfSnake=0,i=0;
        question6(dizi,length,16,leftDirections,numberOfSnake,i);
    }
    static List<int[]> list = new ArrayList<>();


    static boolean isContains(int[]arr){

        for(int i =0;i<list.size();i++){
            boolean flag = true;
            for(int j = 0;j<arr.length;j++){
                if(arr[j] != list.get(i)[j]) flag = false;
            }
            if(flag) return true;
        }
        return false;
    }
    static boolean itContains(int [][] temp){

        for(int i = 0; i< list1.size(); i++){
            boolean flag = true;
            for(int j = 0;j<temp.length;j++){
                for(int k = 0 ;k< temp[j].length;k++){
                    if(list1.get(i)[j][k] !=temp[j][k] ){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) return true;
        }

        return false;

    }
    static int[][] copyingArr(int[][] matrix){
        int [][] returnedValue = new int[matrix.length][matrix[0].length];
        int j=0,k=0;
        for(;j < matrix.length ; j++){
            for( ;k < matrix[j].length;k++){
                returnedValue[j][k] = matrix[j][k];
            }
        }
        return returnedValue;
    }
    static int[] hardCopy(int[]arr){
        int [] res = new int[arr.length];
        for(int i = 0;i< arr.length;i++)
            res[i] = arr[i];

        return res;
    }

    static boolean containsTreeOne(int[]arr){
        int a = 0;
        int c = 0;
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 0 && a < 3 && a!=0) return false;
            else if(arr[i] == 1){
                a++;
                c++;
            }
            else a = 0;
        }
        if(a < 3 && a !=0) return false;
        if(c == 0) return false;
        return true;
    }

    static void findAll(int[] arr , int curIdx){

        if(curIdx +2 >= arr.length){
            if(!isContains(arr) && containsTreeOne(arr)){
                for(int i = 0;i<arr.length;i++)
                    System.out.print(arr[i]);
                System.out.println("");
                list.add(hardCopy(arr));
            }


            return;
        }

        arr[curIdx] = 1;
        arr[curIdx+1] = 1;
        arr[curIdx+2] = 1;
        for(int i = 2;i+curIdx < arr.length;i++){
            arr[i+curIdx] = 1;
            findAll(arr,curIdx+i+2);
        }

        for(int i = curIdx;i<arr.length;i++)
            arr[i] = 0;
        findAll(arr,curIdx+1);


    }

    //Question 2 helper
    public static int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (target == nums[mid]) {
            return mid;
        }
        else if (target < nums[mid]) {
            return binarySearch(nums, left, mid - 1, target);
        }
        else if(target>nums[mid]&&nums[mid+1]>target){
            return mid+1;
        }

        else {
            return binarySearch(nums, mid + 1, right, target);
        }
    }
    //Question 2
    private static int findItemNumberBetweenTwoNumbers(int firstNumber,int secondNumber){
        int arr[] = {1, 3, 4, 7, 8, 10, 11, 13, 14,15,60,65,78,80,90,101};
        int n = arr.length;
        int firstIndex = binarySearch(arr, 0, n - 1, firstNumber);
        int secondIndex=binarySearch(arr,0,n-1,secondNumber);
         return secondIndex-firstIndex+1;
    }
    //Question 3
    public static  void Question3(int[] arr, int[]subset, int i, int n, int j, int target){
        if(i==n){
            int k=0, count=0;
            for(;k<j;++k){
                count+=subset[k]; }
            if(count==target){
                int a=0;
                System.out.println("Subset is : ");
                for(;a<j;++a){
                    System.out.print(subset[a]+" "); }
                System.out.println();
            }
            return;
        }
        Question3(arr,subset,i+1,n,j,target);
        subset[j] = arr[i];
        Question3(arr,subset,i+1,n,j+1,target);
    }
    public static void test(){
        int arr[] = {1,2,3,4,5,6,7,8};
        int[] temp1=new int[100];
        int n = arr.length;
        Question3(arr,temp1,0,n,0,8);
        System.out.println("///////////////////////////////////////");
        int arr1[] = {1,2,3,4,5,6,7,8,9,25,30,45};
        int[] temp=new int[100];
        int n1 = arr1.length;
        Question3(arr1,temp,0,n1,0,55);


    }

    // Question 1
    private static int findNumberOfStrings(String string, String substring, int count,int index,int times){
        if (string.length() == 0||index+substring.length() > string.length()){
            if(count>times){
                return -1; }
            return 0; }
        else{
            if(equals(string,substring,index)){
                ++times;
            }
            if(times==count){
                return index;
            }
            return findNumberOfStrings(string,substring,count,++index,times);
        }
    }
    //Question 1 Helper
    public static boolean equals(String str1,String str2,int index){
        int j,count=0;
        for(j=0;j<str2.length();++j){
            if(str1.charAt(j+index)==str2.charAt(j)){
                ++count;
            }
        }
        if(count==str2.length()){
            return true;
        }else{ return false;}
    }




    static ArrayList<int[][]> list1 = new ArrayList<>();


    static int count = 0;

    static public  void question6(int[][] temp, int length, int leftDirections
            , int numberOfSnake, int i , int j){
        if(leftDirections == 0){
            count++;
            if(!itContains(temp)){

                for(int z = 0;z<length;z++){
                    for(int k = 0;k<length;k++){
                        System.out.print(temp[z][k]+" ");

                    }
                    System.out.println();

                }
                System.out.println();
            }
            list1.add(copyingArr(temp));

        }

        if((i<0||j<0||i>=length )|| (j>= length ||temp[i][j] != 0)){
            return;
        }

        temp[i][j] = numberOfSnake;
        leftDirections--;
        if(leftDirections % length == 0){

            numberOfSnake+=1;
        }


        //Check all directions

        //Call recursive Functions
        question6(temp,length,
                leftDirections,numberOfSnake,i+1,j);
        question6(temp,length,
                leftDirections,numberOfSnake,i-1,j);
        question6(temp,length,
                leftDirections,numberOfSnake,i,j+1);
        question6(temp,length,
                leftDirections,numberOfSnake,i,j-1);

        temp[i][j] = 0;

    }


}
