package Day3_100822;

public class T2_Muliptle_conditions {

    public static void main(String[] args) {
        //declare three variables
    int a, b, c;
    a = 2;
    b = 3;
    c = 4;

    //write a multiple conditional statements that covers when a+b < c, a+b > c, a+b = c
    if(a+b < c){
        System.out.println("a & b is less than c");
    } else if(a+b > c){
        System.out.println("a & b is greater than c");
    } else {
        System.out.println("a & b is equal to c");
    }//end of conditions
    }//end of main
}//end of class
