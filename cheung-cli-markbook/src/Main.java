import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    @SuppressWarnings("resource")
	public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<String> firstName = new ArrayList<String>();
        ArrayList<String> lastName = new ArrayList<String>();
        ArrayList<Integer> studentNumber = new ArrayList<Integer>();
        ArrayList<Integer> grade = new ArrayList<Integer>();
        ArrayList<Integer> marks = new ArrayList<Integer>();

        for (;;) {
            System.out.println("\n What do you want to do? \n 1. add student info \n 2. remove a specific student \n 3. view all student info \n 4. input marks \n 5. calculate class average \n 6. retrieve Google login \n exit");
            String response = input.next();


            if (response.equals("1")) {
                System.out.println("To exit input, enter \"exit\" for first name");
                System.out.print("How many students do you want to input? ");
                int students = input.nextInt();

                addStudent(students, firstName, lastName, studentNumber, grade);
            }

            if (response.equals("2")) {
                removeStudent(firstName, lastName, studentNumber, grade, marks);
            }

            if (response.equals("3")) {
                viewInfo(firstName, lastName, studentNumber, grade, marks);
            }

            if (response.equals("4")) {
                addMark(marks);
            }

            if (response.equals("5")) {
            	getAndPrintAvg(marks);
            }

            if (response.equals("6")) {
                getLogin();
            }

            if (response.equals("exit")) {
                exit();
            }
        }

    }

    public static void addStudent(int students, ArrayList<String> firstName, ArrayList<String> lastName, ArrayList<Integer> studentNumber, ArrayList<Integer> grade) {

        Scanner input= new Scanner(System.in);

        studentInfo:
        for (int i = 1; i <= students; i++) {
            System.out.println("For student " + (i) + ": ");
            System.out.print("Student first name?");
            String firstN = input.next();

            if (firstN.equals("exit")) {
                break studentInfo;
            } else {
                firstName.add(firstN);
                System.out.print("Student last name?");
                lastName.add(input.next());

                System.out.print("Student number?");
                studentNumber.add(input.nextInt());
                System.out.print("Student grade?");
                grade.add(input.nextInt());
            }
        }
    }

    public static void removeStudent(ArrayList<String> firstName, ArrayList<String> lastName, ArrayList<Integer> studentNumber, ArrayList<Integer> grade, ArrayList<Integer> marks) {
        Scanner input = new Scanner(System.in);

        System.out.print("What is the student number of the student?");
        int sNumber = input.nextInt();

        int length = studentNumber.size();

        StudentRemoval:
        for (int i = 0; i < length; i++) {
            if (sNumber == studentNumber.get(i)) {
                firstName.remove(i);
                lastName.remove(i);
                studentNumber.remove(i);
                grade.remove(i);

                break StudentRemoval;
            }
        }
    }

    public static void viewInfo(ArrayList<String> firstName, ArrayList<String> lastName, ArrayList<Integer> studentNumber, ArrayList<Integer> grade, ArrayList<Integer> marks) {
    	if (firstName.isEmpty()) {
        	System.out.println("You haven't input any information.");
        } else {
        	int length = firstName.size();
        	String mark = "N/A";
        	
        	System.out.println("Students without any marks will be indicated by N/A");
        	System.out.println("First Name \t Last Name \t Student # \t Grade \t\t Marks");
        	
        	for (int i = 0; i < length; i++) {
            	String first = firstName.get(i);
                String last = lastName.get(i);
                int sNumber = studentNumber.get(i);
                int gradeNumber = grade.get(i);
                
                if (!marks.isEmpty()) {
                	mark = marks.get(i).toString(); 
                }
                
                System.out.println(first + "\t\t " + last + "\t\t " + sNumber + "\t\t " + gradeNumber + "\t\t " + mark);
            }
        }
    }

    public static void addMark(ArrayList<Integer> marks) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many marks do you want to input? ");
        int numberMarks = input.nextInt();

        for (int i = 1; i <= numberMarks; i++) {
            System.out.print("Enter mark " + i + " : ");
            marks.add(input.nextInt());
        }
    }
    
    public static void getAndPrintAvg(ArrayList<Integer> marks) {
    	int sum = 0;

        for (int i = 0; i < marks.size(); i++) {
            sum = sum + marks.get(i);
        }

        double average = sum / marks.size();
        System.out.println("The class average is " + average);

    }

    public static void getLogin() {
    	Scanner input = new Scanner(System.in); 
    	
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

    public static void exit() {
        System.exit(0);
    }

}
