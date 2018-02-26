import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
    	
    	Scanner input = new Scanner(System.in);
 
        ArrayList<String> firstName = new ArrayList<String>();
        ArrayList<String> lastName = new ArrayList<String>();
        ArrayList<Integer> studentNumber = new ArrayList<Integer>();
        ArrayList<Integer> gradYear = new ArrayList<Integer>();
        int[] marks = new int[]{10,20,15,25,16,60,100};
         
        for (;;) {
        	System.out.println("What do you want to do? \n inStudent - add student info \n view - view all student info \n average - calculate class average \n Login - retrieve Google login \n exit");
            String response = input.next();
             
             
            if (response.equals("inStudent")) {
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
            	 System.out.println(firstName);
            	 System.out.println(lastName);
            	 System.out.println(studentNumber);
            	 System.out.println(gradYear);
             }
             
             if (response.equals("average")) {
               int sum = 0;
               
               for (int i = 0; i < marks.length; i++){
                 sum = sum + marks[i];
               }
               
               double average = sum / marks.length;
               System.out.println("The class average is " + average);
               
             }
               
             
             if (response.equals("exit")) {
            	 System.exit(0);
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
        }   
    }

}
