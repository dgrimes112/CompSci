import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
    
    String id;
    String name;
    String class1;
    String class2;
    String [] classData1;
    String [] classData2;
    Scanner scan= new Scanner(System.in);

    System.out.printf("Enter the Student's Id: ");
    id = scan.nextLine();
    System.out.printf("Enter the Student's full name: ");
    name = scan.nextLine();
    
    System.out.printf("\nEnter crn/credit hours for the first class(like 5665/3): ");
    class1 = scan.nextLine();
    System.out.printf("Enter crn/credit hours for the second class(like 5665/3): ");
    class2 = scan.nextLine();
    System.out.println("Thank you!\n\n");

    classData1 = class1.split("/");
    classData2 = class2.split("/");

    double total = (Float.parseFloat(classData1[1]) * 120.25) + (Float.parseFloat(classData2[1]) * 120.25) + 35.00;




    System.out.printf("Fee invoice prepared for: %s\n\n", name);
    System.out.println("\t\tSIMPLE COLLEGE");
    System.out.println("\t\tORLANDO FL 10101");
    System.out.println("\t\t*************************\n\n");
    System.out.printf("\t\tFee Invoice Prepared For:\n\t\t   [%s][%s]\n\n", name , id);
    System.out.println("\t\t1 Credit Hour = $120.25\n");
    System.out.println("\t\tCRN\tCREDIT HOURS");
    System.out.printf("\t\t%s\t%d\t\t    $%.2f\n",classData1[0], Integer.parseInt(classData1[1]),Float.parseFloat(classData1[1]) * 120.25  );
    System.out.printf("\t\t%s\t%d\t\t    $%.2f\n",classData2[0], Integer.parseInt(classData2[1]),Float.parseFloat(classData2[1]) * 120.25  );
    System.out.println("\t\t\tHealth & Id Fees    $35.00\n");
    System.out.println("\t\t----------------------------------------");
    System.out.printf("\t\t\tTotal Payments      $%.2f", total);




    }
}
