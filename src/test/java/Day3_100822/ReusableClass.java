package Day3_100822;

public class ReusableClass {

//create a void method that will add two numbers and execute the print statement
    public static void addTwoNumbers(int a, int b){
        int result = a+b;
        System.out.println("The result is " + result);
    }//end of addTwoNumbers

//create a return method that will add two numbers and return the result from the print statemnet
    public static int returnTwoNumbers(int a, int b){
        int result = a+b;
        System.out.println("The return result is " + result);
        return result;
    }//end of returnTwoNumbers

}//end of java class
