import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
 
        ArrayList<String> firstName = new ArrayList<String>();
        ArrayList<String> lastName = new ArrayList<String>();
        ArrayList<Integer> studentNumber = new ArrayList<Integer>();
        ArrayList<Integer> gradYear = new ArrayList<Integer>();
        ArrayList<Integer> marks = new ArrayList<Integer>();
         
        for (;;) {
        	System.out.println("What do you want to do? \n add - add student info \n view - view all student info \n average - calculate class average \n login - retrieve Google login \n exit");
            String response = input.next();
             
             
            if (response.equals("add")) {
            	System.out.println("How many students do you want to input? ");
                int students = input.nextInt();
                 
                studentInfo:
                for (int i = 1; i <= students; i++) {
         	       System.out.println("Student first name?");
         	       String firstN = input.next();
         	        
         	       if (firstN.equals("none")) {
         	    	   break studentInfo;
         	       } else {
         	    	   firstName.add(firstN);
         	    	   System.out.println("Student last name?");
         	    	   lastName.add(input.next());
         	    	   
         	    	   System.out.println("Student number?");
         	    	   studentNumber.add(input.nextInt());
         	    	   System.out.println("Student graduation year?");
         	    	   gradYear.add(input.nextInt());
         	        }	
                 }
             }
            
             if (response.equals("view")) {
                 int length = firstName.size();
                 System.out.println("First Name \t Last Name \t Student # \t Grad Year");
                 
                 for (int i = 0; i < length; i++) {
                     String first = firstName.get(i);
                     String last = lastName.get(i);
                     int sNum = studentNumber.get(i);
                     int gYear = gradYear.get(i);

                     System.out.println(first + "\t \t" + last + "\t\t" + sNum + "\t\t" + gYear);
               }
             }
            
             if (response.equals("input marks")) {
              System.out.println("How many marks do you want to input? ");
              int numberMarks = input.nextInt();
              
              for (int i = 0; i <= numberMarks; i++) {
                System.out.print("Enter mark: ");
                  marks.add(input.nextInt());
              }

             }
             
             if (response.equals("average")) {
               int sum = 0;
               
               for (int i = 0; i < marks.size(); i++) {
                 sum = sum + marks.get(i);
               }
               
               double average = sum / marks.size();
               System.out.println("The class average is " + average);
               
             }
            
            if (response.equals("login")) {
                System.out.println("To retrieve Google login info, please enter the following information:");
                
                //retrieving user information for google login
                System.out.print("Student's first name: ");
                String fName = input.next();
                System.out.print("Student's last name: ");
                String lName = input.next();
                System.out.print("Student number:");
                String studentNum = input.next();
                System.out.print("Student's graduation year:");
                String gradYr = input.next();

                System.out.println(" ");

                //putting together google login
                String email = fName + "." + lName + gradYr.substring(2, 4) + "@ycdsbk12.ca";
                String password = fName.substring(0, 1).toUpperCase() + lName.substring(0, 1).toLowerCase() + studentNum;

                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
            }
                     
             if (response.equals("exit")) {
            	 System.exit(0);
             }
        }   
    }
}
