package Review;

import java.util.ArrayList;

public class Review_1005 {
    public static void main(String[] args) {

        //string
        String[] cars = new String[]{"BMW","Nissan","Ferrari","Lamborghini","McLaren"};
        ArrayList<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("917-233-9493");
        phoneNumbers.add("917-233-2333");
        phoneNumbers.add("917-233-3483");
        phoneNumbers.add("917-233-9422");
        phoneNumbers.add("917-233-3744");
        int s = 0;
        System.out.println("cars:");
        while(s< cars.length){
            System.out.println(cars[s]);
            s++;
        }//end of while loop



        System.out.println("phone numbers:");
        for(int i = 0; i< phoneNumbers.size(); i++ ){
            System.out.println(phoneNumbers.get(i));
        }//end of for loop


    }//end of main


}//end of review class
