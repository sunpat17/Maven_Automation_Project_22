package Automation_Action_Items;

import java.util.ArrayList;

public class Action_Item_1B {

    public static void main(String[] args) {

    //decare and define an ArrayList of pokemon
        ArrayList<String> pokemon = new ArrayList<>();
    //now add the values for pokemon array
        pokemon.add("Pikachu");
        pokemon.add("Charmander");
        pokemon.add("Squirtle");
        pokemon.add("Bulbasuar");
        //get all the count of the pokemon list
        System.out.println("Pokemon count: " + pokemon.size());
        //get Charmander from the pokemon list
        System.out.println("Pokemon: " + pokemon.get(1));

    }//end of main
}//end of class
