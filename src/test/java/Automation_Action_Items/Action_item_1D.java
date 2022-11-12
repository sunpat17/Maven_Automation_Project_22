package Automation_Action_Items;

public class Action_item_1D {
    public static void main(String[] args) {
        //declare a string array variable
        String[] Region;
        Region = new String[]{"NYC", "Chicago", "Austin", "Miami"};
        //declare and define linear array for regionCode
        int[] areaCode = new int[]{516,393,495,543};
        //iterate through all street number by while loop
        int C = 0;
        //now set the condition for while loop
        //linear array gets the count by using .length command
        while (C < areaCode.length){
            System.out.println("My Region is " + Region[C] + " and my area code is" + areaCode[C]);

        }//end of while loop
    }//end of main
}//end of class
