
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void inputStudent() {
        Scanner input = new Scanner(System.in);

        ArrayList firstName = new ArrayList();
        ArrayList lastName = new ArrayList();
        ArrayList studentNumber = new ArrayList();
        ArrayList gradYear = new ArrayList();

        System.out.println("Student first name?");

        if (input.next() == "NONe") {

        }
        firstName.add(input.next());

        System.out.println("Student last name?");
        lastName.add(input.next());




    }

    public static void main(String[] args) {
        inputStudent();

    }

}
