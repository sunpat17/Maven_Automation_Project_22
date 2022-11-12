package Automation_Action_Items;
import java.util.ArrayList;

public class Action_item_1C {
    public static void main(String[] args) {
        //declare and define the arrayList for country
        ArrayList<String> country = new ArrayList<>();
        country.add("Britian");
        country.add("France");
        country.add("Spain");
        country.add("Germany");

        //declare and define the arryalist for countryCode
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(10101);
        countryCode.add(20202);
        countryCode.add(30303);
        countryCode.add(40404);

        ////call for loop to print out all zip code values from the array list
        for(int i=0; i < country.size(); i++){
        //print out the country and the countryCode.
            System.out.println("My country is: " + country.get(i) + " " + "and my country code is" + " " + countryCode.get(i));

        }//end of for loop
    }//end of main
}//end of class
