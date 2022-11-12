package Review;

public class Review_10122022 {
    public static void main(String[] args) {
        //define automation stirng variable
        String Subjectline = "Automation_AI101";

    //As a professor I would like to see the action item number
    //might be useful to use split method
    //how could you grab the number portion of the second part of the string
    //expected result should be 05

        //String[] splitSubjectline = Subjectline.split("");
        //System.out.println("result: " + splitSubjectline[13] + splitSubjectline[14]);



        //split the string
        String[] splitMessageArray = Subjectline.split("_");
        //take the second string from the array then grab the number only
        String actionItemNumber = splitMessageArray[1].substring(2);
        //print out John to the console
        System.out.println("The action number item is " + actionItemNumber);

    }//end of main
}//end of java class
