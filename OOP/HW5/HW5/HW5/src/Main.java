import java.io.*; 
import java.util.*;

public class Main
{
    public static void main(String[] args) throws Exception
    {   
        Scanner scan = new Scanner(new File("C:\\Repos\\CompSci\\OOP\\HW5\\HW5\\HW5\\src\\lec.txt"));
        Scanner input = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new File("lecturesOnly.txt"));
        int count = 0;
        while(scan.hasNextLine())
        {
            String line = scan.nextLine();
            String[] arr = line.split(",");
            try
            {
                if( arr[4].compareToIgnoreCase("Online") == 0)
                {
                count++;
                }
            }
            catch(Exception e)
            {
            }
        }
        System.out.println("- Number of online classes: " + count);
        System.out.print("- Enter a classroom: ");
        String inputClass = input.nextLine();
        System.out.print("   - The classes held in " + inputClass + " are: \n");
        scan = new Scanner(new File("C:\\Repos\\CompSci\\OOP\\HW5\\HW5\\HW5\\src\\lec.txt"));
        while(scan.hasNextLine())
        {
            String line = scan.nextLine();
            String[] arr = line.split(",");
            try
            {
                if(inputClass.equalsIgnoreCase(arr[1]) || inputClass.compareToIgnoreCase(arr[5]) == 0)
                {
                    System.out.print("\t- " + arr[0] + "\n");
                }
            }
            catch(Exception e)
            {
            }
        }
        scan = new Scanner(new File("C:\\Repos\\CompSci\\OOP\\HW5\\HW5\\HW5\\src\\lec.txt"));
        pw.println("Online Lectures:");
        while(scan.hasNextLine())
        {
            String line = scan.nextLine();
            String[] arr = line.split(",");
            try
            {
                if(arr[4].compareToIgnoreCase("Online") == 0)
                {
                    pw.println(line);
                }
            }
            catch(Exception e)
            {
            }
        }
        pw.println("\nLectures with No Lab:");
        scan = new Scanner(new File("C:\\Repos\\CompSci\\OOP\\HW5\\HW5\\HW5\\src\\lec.txt"));
        while(scan.hasNextLine())
        {
            String line = scan.nextLine();
            String[] arr = line.split(",");
            try
            {
                if(arr[6].compareToIgnoreCase("No") == 0)
                {
                    pw.println(line);
                }
            }
            catch(Exception e)
            {
            }
        }

        System.out.println("- lecturesOnly.txt is created!\n- Goodbye!");

        scan.close();
        pw.close();
        input.close();



    }
}
