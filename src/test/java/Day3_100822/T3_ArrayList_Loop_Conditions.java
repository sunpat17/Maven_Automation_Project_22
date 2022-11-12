package Day3_100822;

import java.util.ArrayList;

public class T3_ArrayList_Loop_Conditions {

    public static void main(String[] args) {
    //<> refers to anchor
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Canada");
        countries.add("Bangladesh");
        countries.add("India");
        countries.add("Australia");

    //using for loop to iterate through countries list and print out only the country is USA or Australia
    for(int i=0; i < countries.size(); i++){
        //two equal will compare the values from right and left side
        //whereas one equal use to set a value for a variable
        //single = is to assign value
        //double == is to compare values
        if(countries.get(i) == "USA"){
            System.out.println("Country is USA. And index i is " + i);
        } else if(countries.get(i) == "Australia"){
            System.out.println("Country is Australia. And index i is " + i);
        }

        //To block a code you use /* and end it with */
        //using OR(||) operator you can write both/multiple conditions on one if statement
        /*
        if(countries.get(i) == "USA" || countries.get(i) == "Australia") {
            System.out.println("Country is " + countries.get(i) + "  And index i is " + i);
        }
        */


    }//end of for loop
    }//end of main
}//end of class
