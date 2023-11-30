/* Final Project
 * David Grimes
 */

import java.io.*;
import java.util.*;


public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        ArrayList<Person> ppl = new ArrayList<>(100);
        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(new File("report.txt"));



        System.out.println("Welcome to my Personal Management Program\n");

        int choice = 0;
        while(choice != 8)
        {
            System.out.println("What would you like to do?");
            System.out.printf("1. Enter the information a faculty\n" + //
                               "2. Enter information of a student\n" + //
                               "3. Enter the information of a staff member\n" + //
                               "4. Print faculty information\n" + //
                               "5. Print tuition invoice\n" + //
                               "6. Print the information of a staff member\n" + //
                               "7. Delete a person\n" + //
                               "8. Exit Program\n" + //
                               "   Enter your choice: ");
            boolean bool = false;
            while(bool == false)
            {
                try
                {
                    choice = Integer.parseInt(input.nextLine());
                    if(choice >= 1 && choice <= 8)
                    {
                        bool = true;
                    }
                    else
                    {
                       throw new Exception();
                    }
                }
                catch(Exception e)
                {
                    System.out.printf("Please enter a number between 1 and 8:");
                }
            }
            System.out.printf("\n");
            if(choice == 1)
            {
                String name = "";
                String id = "";
                String department = "";
                String rank = "";
                System.out.println("Enter the faculty info:");
                System.out.printf("Name: ");
                name = input.nextLine();
                System.out.printf("ID: ");
                bool = false;
                while(bool == false)
                {
                    try
                    {
                        id = input.nextLine();
                        id = id.toLowerCase();
                        if (id.length() != 6)
                        {
                            throw new Exception();
                        }
                        else if(Character.isLetter(id.charAt(0)) == false || Character.isLetter(id.charAt(1)) == false)
                        {
                            throw new Exception();
                        }
                        else if(Character.isDigit(id.charAt(2)) == false || Character.isDigit(id.charAt(3)) == false || Character.isDigit(id.charAt(4)) == false || Character.isDigit(id.charAt(5)) == false)
                        {
                            throw new Exception();
                        }
                        else
                        {
                            for (Person p : ppl)
                            {
                                if(p.getId().equals(id))
                                {
                                    throw new CopyException();
                                }
                            }
                            bool = true;
                        }
                    }   
                    catch(CopyException e)
                    {
                        System.out.println("\n" + e.getMessage());
                        System.out.println("Exit or try again?");
                        System.out.printf("1. Exit\n2. Try a different ID\n");
                        System.out.printf("Enter your choice: ");
                        boolean bool2 = false;
                        while(bool2 == false)
                        {
                            try
                            {
                                int choice2 = Integer.parseInt(input.nextLine()); 
                                if(choice2 == 1)
                                {
                                    System.exit(0);
                                }
                                else if(choice2 == 2)
                                {
                                    System.out.printf("\nID: ");
                                    bool2 = true;
                                }
                                else
                                {
                                    throw new Exception();
                                }
                            }
                            catch(Exception e2)
                            {
                                System.out.println("Please enter 1 or 2: ");
                            }
                        }
                    } 
                    catch(Exception e)
                    {
                        System.out.printf("Please enter a valid ID: ");
                    }
                    
                }
                System.out.printf("Rank: ");
                bool = false;
                while(bool == false)
                {
                    try
                    {
                    rank = input.nextLine();
                    if(rank.equalsIgnoreCase("Professor") == true || rank.equalsIgnoreCase("Adjunct") == true)
                    {
                        bool = true;
                        rank = rank.toLowerCase();
                        rank = rank.substring(0, 1).toUpperCase() + rank.substring(1);
                    }
                    else
                    {
                        throw new Exception();
                    }
                    }
                    catch(Exception e)
                    {
                        System.out.printf("Please enter a valid Rank: ");
                    }
                }
                System.out.printf("Department: ");
                bool = false;
                while(bool == false)
                {
                    try
                    {
                    department = input.nextLine();
                    if(department.equalsIgnoreCase("Engineering") == true || department.equalsIgnoreCase("English") == true || department.equalsIgnoreCase("Mathematics") == true)
                    {
                        bool = true;
                        department = department.toLowerCase();
                        department = department.substring(0, 1).toUpperCase() + department.substring(1);
                    }
                    else
                    {
                        throw new Exception();
                    }
                    }
                    catch(Exception e)
                    {
                        System.out.printf("Please enter a valid Department: ");
                    
                    }

                }
                System.out.printf("\nFaculty member added!\n\n");
                Faculty faculty = new Faculty(name, id, department, rank);
                ppl.add(faculty);
                
            } 
            if(choice == 2)
            {
                String name = "";
                String id = "";
                double gpa = 0.0;
                int hours = 0;
                System.out.println("Enter the student info:");
                System.out.printf("Name: ");
                name = input.nextLine();
                System.out.printf("ID: ");
                bool = false;
                while(bool == false)
                {
                    try
                    {
                        id = input.nextLine();
                        id = id.toLowerCase();
                        if (id.length() != 6)
                        {
                            throw new Exception();
                        }
                        else if(Character.isLetter(id.charAt(0)) == false || Character.isLetter(id.charAt(1)) == false)
                        {
                            throw new Exception();
                        }
                        else if(Character.isDigit(id.charAt(2)) == false || Character.isDigit(id.charAt(3)) == false || Character.isDigit(id.charAt(4)) == false || Character.isDigit(id.charAt(5)) == false)
                        {
                            throw new Exception();
                        }
                        else
                        {
                            for (Person p : ppl)
                            {
                                if(p.getId().equals(id))
                                {
                                    throw new CopyException();
                                }
                            }
                            bool = true;
                        }
                    }   
                    catch(CopyException e)
                    {
                        System.out.println("\n" + e.getMessage());
                        System.out.println("Exit or try again?");
                        System.out.printf("1. Exit\n2. Try a different ID\n");
                        System.out.printf("Enter your choice: ");
                        boolean bool2 = false;
                        while(bool2 == false)
                        {
                            try
                            {
                                int choice2 = Integer.parseInt(input.nextLine()); 
                                if(choice2 == 1)
                                {
                                    System.exit(0);
                                }
                                else if(choice2 == 2)
                                {
                                    System.out.printf("\nID: ");
                                    bool2 = true;
                                }
                                else
                                {
                                    throw new Exception();
                                }
                            }
                            catch(Exception e2)
                            {
                                System.out.println("Please enter 1 or 2: ");
                            }
                        }
                    } 
                    catch(Exception e)
                    {
                        System.out.printf("Please enter a valid ID: ");
                    }
                }
                System.out.printf("GPA: ");
                bool = false;
                while(bool == false)
                {
                    try
                    {
                        gpa = Double.parseDouble(input.nextLine());
                        if(gpa >= 0.0 && gpa <= 4.0)
                        {
                            bool = true;
                        }
                        else
                        {
                            throw new Exception();
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.printf("Please enter a valid GPA between 0 and 4: ");
                    }
                }
                System.out.printf("Credit Hours: ");
                bool = false;
                while(bool == false)
                {
                    try
                    {
                        hours = Integer.parseInt(input.nextLine());
                        if(hours >= 0)
                        {
                            bool = true;
                        }
                        else
                        {
                            throw new Exception();
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.printf("Please enter a valid number of credit hours: ");
                    }
                }
                System.out.printf("\nStudent added!\n\n");
                Student student = new Student(name, id, gpa, hours);
                ppl.add(student);
            } 
            if(choice == 3)
            {
                String name = "";
                String id = "";
                String department = "";
                String status = "";
                System.out.println("Enter the staff info:");
                System.out.printf("Name: ");
                name = input.nextLine();
                System.out.printf("ID: ");
                bool = false;
                while(bool == false)
                {
                    try
                    {
                        id = input.nextLine();
                        id = id.toLowerCase();
                        if (id.length() != 6)
                        {
                            throw new Exception();
                        }
                        else if(Character.isLetter(id.charAt(0)) == false || Character.isLetter(id.charAt(1)) == false)
                        {
                            throw new Exception();
                        }
                        else if(Character.isDigit(id.charAt(2)) == false || Character.isDigit(id.charAt(3)) == false || Character.isDigit(id.charAt(4)) == false || Character.isDigit(id.charAt(5)) == false)
                        {
                            throw new Exception();
                        }
                        else
                        {
                            for (Person p : ppl)
                            {
                                if(p.getId().equals(id))
                                {
                                    throw new CopyException();
                                }
                            }
                            bool = true;
                        }
                    }   
                    catch(CopyException e)
                    {
                        System.out.println("\n" + e.getMessage());
                        System.out.println("Exit or try again?");
                        System.out.printf("1. Exit\n2. Try a different ID\n");
                        System.out.printf("Enter your choice: ");
                        boolean bool2 = false;
                        while(bool2 == false)
                        {
                            try
                            {
                                int choice2 = Integer.parseInt(input.nextLine()); 
                                if(choice2 == 1)
                                {
                                    System.exit(0);
                                }
                                else if(choice2 == 2)
                                {
                                    System.out.printf("\nID: ");
                                    bool2 = true;
                                }
                                else
                                {
                                    throw new Exception();
                                }
                            }
                            catch(Exception e2)
                            {
                                System.out.println("Please enter 1 or 2: ");
                            }
                        }
                    } 
                    catch(Exception e)
                    {
                        System.out.printf("Please enter a valid ID: ");
                    }
                }
                System.out.printf("Status, Enter P for Part-time or F for Full-time: ");
                bool = false;
                while(bool == false)
                {
                    try
                    {
                        status = input.nextLine();
                        if(status.equalsIgnoreCase("F") == true || status.equalsIgnoreCase("P") == true)
                        {
                            bool = true;
                            if(status.equalsIgnoreCase("F") == true)
                            {
                                status = "Full-Time";
                            }
                            else
                            {
                                status = "Part-Time";
                            }

                        }
                        else
                        {
                            throw new Exception();
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.printf("Please enter a valid Status: ");
                    }
                }
                System.out.printf("Department: ");
                bool = false;
                while(bool == false)
                {
                    try
                    {
                    department = input.nextLine();
                    if(department.equalsIgnoreCase("Engineering") == true || department.equalsIgnoreCase("English") == true || department.equalsIgnoreCase("Mathematics") == true)
                    {
                        bool = true;
                        department = department.toLowerCase();
                        department = department.substring(0, 1).toUpperCase() + department.substring(1);
                    }
                    else
                    {
                        throw new Exception();
                    }
                    }
                    catch(Exception e)
                    {
                        System.out.printf("Please enter a valid Department: ");
                    
                    }

                }
                System.out.printf("\nStaff member added!\n\n");
                Staff staff = new Staff(name, id, department, status);
                ppl.add(staff);

            }
            if(choice == 4)
            {
                String id = "";
                boolean found = false;
                System.out.printf("Faculty ID: ");
                bool = false;
                while(bool == false)
                {
                    try
                    {
                        id = input.nextLine();
                        id = id.toLowerCase();
                        if (id.length() != 6)
                        {
                            throw new Exception();
                        }
                        else if(Character.isLetter(id.charAt(0)) == false || Character.isLetter(id.charAt(1)) == false)
                        {
                            throw new Exception();
                        }
                        else if(Character.isDigit(id.charAt(2)) == false || Character.isDigit(id.charAt(3)) == false || Character.isDigit(id.charAt(4)) == false || Character.isDigit(id.charAt(5)) == false)
                        {
                            throw new Exception();
                        }
                        else
                        {
                            for (Person p : ppl)
                            {
                                if(p.getId().equals(id))
                                {
                                    if(p instanceof Student)
                                    {
                                        throw new WrongClassException("Student", "Faculty");
                                    }
                                    if(p instanceof Staff)
                                    {
                                        throw new WrongClassException("Staff", "Faculty");
                                    }
                                    else
                                    {
                                        bool = true;
                                        found = true;
                                    }

                                }
                            }
                            if(found == false)
                            {
                                throw new NotFoundException();
                            }
                        }
                    }
                    catch(WrongClassException e)
                    {
                        System.out.println("\n" + e.getMessage());
                        System.out.println("Exit or try again?");
                        System.out.printf("1. Exit\n2. Try a different ID\n");
                        System.out.printf("Enter your choice: ");
                        boolean bool2 = false;
                            while(bool2 == false)
                            {
                                try
                                {
                                    int choice2 = Integer.parseInt(input.nextLine()); 
                                    if(choice2 == 1)
                                    {
                                        System.exit(0);
                                    }
                                    else if(choice2 == 2)
                                    {
                                        System.out.printf("\nID: ");
                                        bool2 = true;
                                    }
                                    else
                                    {
                                        throw new Exception();
                                    }
                                }
                                catch(Exception e2)
                                {
                                    System.out.println("Please enter 1 or 2: ");
                                }
                            }
                        
                    }
                    catch(NotFoundException e)
                    {
                        System.out.println("\n" + e.getMessage());
                        System.out.println("Exit or try again?");
                        System.out.printf("1. Exit\n2. Try a different ID\n");
                        System.out.printf("Enter your choice: ");
                        boolean bool2 = false;
                        while(bool2 == false)
                        {
                            try
                            {
                                int choice2 = Integer.parseInt(input.nextLine()); 
                                if(choice2 == 1)
                                {
                                    System.exit(0);
                                }
                                else if(choice2 == 2)
                                {
                                    System.out.printf("\nID: ");
                                    bool2 = true;
                                }
                                else
                                {
                                    throw new Exception();
                                }
                            }
                            catch(Exception e2)
                            {
                                System.out.println("Please enter 1 or 2: ");
                            }
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("Please enter a valid ID: ");
                    }
                }
                for(Person p : ppl)
                {
                    if(p.getId().equals(id))
                    {
                        System.out.printf("\n");
                        p.print();
                        System.out.printf("\n");
                        break;
                    }

                }
            }
            if(choice == 5)
            {
                String id = "";
                boolean found = false;
                System.out.printf("Student ID: ");
                bool = false;
                while(bool == false)
                {
                    try
                    {

                        id = input.nextLine();
                        id = id.toLowerCase();
                        if (id.length() != 6)
                        {
                            throw new Exception();
                        }
                        else if(Character.isLetter(id.charAt(0)) == false || Character.isLetter(id.charAt(1)) == false)
                        {
                            throw new Exception();
                        }
                        else if(Character.isDigit(id.charAt(2)) == false || Character.isDigit(id.charAt(3)) == false || Character.isDigit(id.charAt(4)) == false || Character.isDigit(id.charAt(5)) == false)
                        {
                            throw new Exception();
                        }
                        else
                        {
                            for (Person p : ppl)
                            {
                                if(p.getId().equals(id))
                                {
                                    if(p instanceof Faculty)
                                    {
                                        throw new WrongClassException("Faculty", "Student");
                                    }
                                    if(p instanceof Staff)
                                    {
                                        throw new WrongClassException("Staff", "Student");
                                    }
                                    else
                                    {
                                        bool = true;
                                        found = true;
                                    }

                                }
                                
                            }
                            if(found == false)
                            {
                                throw new NotFoundException();
                            }
                        }
                    }
                    catch(WrongClassException e)
                    {
                        System.out.println("\n" + e.getMessage());
                        System.out.println("Exit or try again?");
                        System.out.printf("1. Exit\n2. Try a different ID\n");
                        System.out.printf("Enter your choice: ");
                        boolean bool2 = false;
                            while(bool2 == false)
                            {
                                try
                                {
                                    int choice2 = Integer.parseInt(input.nextLine()); 
                                    if(choice2 == 1)
                                    {
                                        System.exit(0);
                                    }
                                    else if(choice2 == 2)
                                    {
                                        System.out.printf("\nID: ");
                                        bool2 = true;
                                    }
                                    else
                                    {
                                        throw new Exception();
                                    }
                                }
                                catch(Exception e2)
                                {
                                    System.out.println("Please enter 1 or 2: ");
                                }
                            }
                        
                    }
                    catch(NotFoundException e)
                    {
                        System.out.println("\n" + e.getMessage());
                        System.out.println("Exit or try again?");
                        System.out.printf("1. Exit\n2. Try a different ID\n");
                        System.out.printf("Enter your choice: ");
                        boolean bool2 = false;
                        while(bool2 == false)
                        {
                            try
                            {
                                int choice2 = Integer.parseInt(input.nextLine()); 
                                if(choice2 == 1)
                                {
                                    System.exit(0);
                                }
                                else if(choice2 == 2)
                                {
                                    System.out.printf("\nID: ");
                                    bool2 = true;
                                }
                                else
                                {
                                    throw new Exception();
                                }
                            }
                            catch(Exception e2)
                            {
                                System.out.println("Please enter 1 or 2: ");
                            }
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("Please enter a valid ID: ");
                    }
                }
                for(Person p : ppl)
                {
                    if(p.getId().equals(id))
                    {
                        System.out.printf("\n");
                        p.print();
                        System.out.printf("\n");
                        break;
                    }

                }    
            }
            if(choice == 6)
            {
                String id = "";
                boolean found = false;
                System.out.printf("Staff ID: ");
                bool = false;
                while(bool == false)
                {
                    try
                    {
                        id = input.nextLine();
                        id = id.toLowerCase();
                        if (id.length() != 6)
                        {
                            throw new Exception();
                        }
                        else if(Character.isLetter(id.charAt(0)) == false || Character.isLetter(id.charAt(1)) == false)
                        {
                            throw new Exception();
                        }
                        else if(Character.isDigit(id.charAt(2)) == false || Character.isDigit(id.charAt(3)) == false || Character.isDigit(id.charAt(4)) == false || Character.isDigit(id.charAt(5)) == false)
                        {
                            throw new Exception();
                        }
                        else
                        {
                            for (Person p : ppl)
                            {
                                if(p.getId().equals(id))
                                {
                                    if(p instanceof Faculty)
                                    {
                                        throw new WrongClassException("Faculty", "Staff");
                                    }
                                    if(p instanceof Student)
                                    {
                                        throw new WrongClassException("Student", "Staff");
                                    }
                                    else
                                    {
                                        bool = true;
                                        found = true;
                                    }

                                }
                            }
                            if(found == false)
                            {
                                throw new NotFoundException();
                            }
                        }
                    }
                    catch(WrongClassException e)
                    {
                        System.out.println("\n" + e.getMessage());
                        System.out.println("Exit or try again?");
                        System.out.printf("1. Exit\n2. Try a different ID\n");
                        System.out.printf("Enter your choice: ");
                        boolean bool2 = false;
                            while(bool2 == false)
                            {
                                try
                                {
                                    int choice2 = Integer.parseInt(input.nextLine()); 
                                    if(choice2 == 1)
                                    {
                                        System.exit(0);
                                    }
                                    else if(choice2 == 2)
                                    {
                                        System.out.printf("\nID: ");
                                        bool2 = true;
                                    }
                                    else
                                    {
                                        throw new Exception();
                                    }
                                }
                                catch(Exception e2)
                                {
                                    System.out.println("Please enter 1 or 2: ");
                                }
                            }
                        
                    }
                    catch(NotFoundException e)
                    {
                        System.out.println("\n" + e.getMessage());
                        System.out.println("Exit or try again?");
                        System.out.printf("1. Exit\n2. Try a different ID\n");
                        System.out.printf("Enter your choice: ");
                        boolean bool2 = false;
                        while(bool2 == false)
                        {
                            try
                            {
                                int choice2 = Integer.parseInt(input.nextLine()); 
                                if(choice2 == 1)
                                {
                                    System.exit(0);
                                }
                                else if(choice2 == 2)
                                {
                                    System.out.printf("\nID: ");
                                    bool2 = true;
                                }
                                else
                                {
                                    throw new Exception();
                                }
                            }
                            catch(Exception e2)
                            {
                                System.out.println("Please enter 1 or 2: ");
                            }
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("Please enter a valid ID: ");
                    }
                }
                for(Person p : ppl)
                {
                    if(p.getId().equals(id))
                    {
                        System.out.printf("\n");
                        p.print();
                        System.out.printf("\n");
                        break;
                    }

                }

            }
            if(choice == 7)
            {
                String id = "";
                System.out.printf("Enter the Id of the person you want to delete: ");
                bool = false;
                while(bool == false)
                {
                    try
                    {
                        id = input.nextLine();
                        id = id.toLowerCase();
                        boolean found = false;
                        if (id.length() != 6)
                        {
                            throw new Exception();
                        }
                        else if(Character.isLetter(id.charAt(0)) == false || Character.isLetter(id.charAt(1)) == false)
                        {
                            throw new Exception();
                        }
                        else if(Character.isDigit(id.charAt(2)) == false || Character.isDigit(id.charAt(3)) == false || Character.isDigit(id.charAt(4)) == false || Character.isDigit(id.charAt(5)) == false)
                        {
                            throw new Exception();
                        }
                        else
                        {
                            for (Person p : ppl)
                            {
                                if(p.getId().equals(id))
                                {
                                    bool = true;
                                    found = true;
                                }
                            }
                        }
                        if(found == false)
                        {
                            throw new NotFoundException();
                        }
                    }
                    catch(NotFoundException e)
                    {
                        System.out.println("\n" + e.getMessage());
                        System.out.println("Exit or try again?");
                        System.out.printf("1. Exit\n2. Try a different ID\n");
                        System.out.printf("Enter your choice: ");
                        boolean bool2 = false;
                        while(bool2 == false)
                        {
                            try
                            {
                                int choice2 = Integer.parseInt(input.nextLine()); 
                                if(choice2 == 1)
                                {
                                    System.exit(0);
                                }
                                else if(choice2 == 2)
                                {
                                    System.out.printf("\nID: ");
                                    bool2 = true;
                                }
                                else
                                {
                                    throw new Exception();
                                }
                            }
                            catch(Exception e2)
                            {
                                System.out.println("Please enter 1 or 2: ");
                            }
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println("Please enter a valid ID: ");
                    }
                }
                for(Person p : ppl)
                {
                    if(p.getId().equals(id))
                    {
                        ppl.remove(p);
                        System.out.println("Person deleted!\n");
                        break;
                    }

                }
            }
            if(choice == 8)
            {
                break;
                
            }  
        
        }
        System.out.printf("Would you like to create a report? (Y/N): ");
        boolean bool = false;
        while(bool == false)
        {
            try
            {
            String repo = input.nextLine();
            if(repo.equalsIgnoreCase("y") == true)
            {
                bool = true;
                output.println("\t\tReport Created on " + new Date() + "\n\t\t**********************\n\n\n");
                output.println("\tFaculty Members" + "\n\t-------------");
                int i = 1;
                for(Person p :ppl)
                {
                    if(p instanceof Faculty)
                    {
                        output.printf("\t   %d. %s\n", i, p.getName());
                        output.printf("\t   ID: %s\n", p.getId());
                        output.printf("\t   %s,%s\n",((Faculty)p).getRank(),((Faculty)p).getDepartment());
                        output.printf("\n");
                        i++;
                    }
                }
                output.println("\tStaff Members" + "\n\t-------------");
                i = 1;
                for(Person p :ppl)
                {
                    if(p instanceof Staff)
                    {
                        output.printf("\t   %d. %s\n", i, p.getName());
                        output.printf("\t   ID: %s\n", p.getId());
                        output.printf("\t   %s,%s\n",((Staff)p).getStatus(),((Staff)p).getDepartment());
                        output.printf("\n");
                        i++;
                    }
                }
                System.out.printf("Would like to sort your students by descending gpa or name (1 for gpa, 2 for name): ");
                boolean bool2 = false;
                while(bool2 == false)
                {
                    try
                    {
                        int sort = Integer.parseInt(input.nextLine());
                        int j = 1;
                        if(sort == 1)
                        {    
                            try{
                            Collections.sort(ppl, new GpaCompare());
                            }
                            catch(Exception e)
                            {
                                System.out.println("Error");
                            }
                            output.println("\tStudents" + "\n\t--------");
                            for(Person p : ppl)
                            {
                                if(p instanceof Student)
                                {
                                    output.printf("\t   %d. %s\n", j, p.getName());
                                    output.printf("\t   ID: %s\n", p.getId());
                                    output.printf("\t   GPA: %.2f\n", ((Student)p).getGpa());
                                    output.printf("\t   Credit Hours: %d\n", ((Student)p).getHours());
                                    output.printf("\n");
                                    j++;   
                                }
                            }
                            System.out.println("Report created!");
                            bool2 = true;

                        }
                        else if(sort == 2)
                        {
                            try
                            {
                            Collections.sort(ppl, new NameCompare());
                            }
                            catch(Exception e)
                            {
                                System.out.println("Error");
                            }
                            for(Person p : ppl)
                            {
                                if(p instanceof Student)
                                {
                                    output.printf("\t   %d. %s\n", j, p.getName());
                                    output.printf("\t   ID: %s\n", p.getId());
                                    output.printf("\t   GPA: %.2f\n", ((Student)p).getGpa());
                                    output.printf("\t   Credit Hours: %d\n", ((Student)p).getHours());
                                    output.printf("\n");
                                    j++;   
                                }
                            }
                            System.out.println("Report created!");
                            bool2 = true;

                        }
                        else
                        {
                            throw new Exception();
                        }
                     
                    }
                    catch(Exception e)
                    {
                        System.out.printf("Please enter  1 or 2: ");
                    }
                }
            }
            else if(repo.equalsIgnoreCase("n") == true)
            {
                bool = true;
            }
            else
            {
                throw new Exception();
            }
            }
            catch (Exception e)
            {
                System.out.printf("Please enter y or n: ");
            }
        }
        System.out.println("Goodbye!");


        output.close();
        input.close();
    }
}
//---------------------------
class GpaCompare implements Comparator<Person>
{
    public int compare(Person p1, Person p2)
    {
        if(p1 instanceof Student && p2 instanceof Student)
        {
            if(((Student)p1).getGpa() > ((Student)p2).getGpa())
            {
                return -1;
            }
            else if(((Student)p1).getGpa() < ((Student)p2).getGpa())
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            return 0;
        }
    }

}

class NameCompare implements Comparator<Person>
{
    public int compare(Person p1, Person p2)
    {
        if(p1 instanceof Student && p2 instanceof Student)
        {
            return p1.getName().compareTo(p2.getName());
        }
        else
        {
            return 0;
        }
    }
}

//---------------------------
class CopyException extends Exception
{
    public CopyException()
    {
        super("ID already exists.");
    }
}
class NotFoundException extends Exception
{
    public NotFoundException()
    {
        super("ID not found.");
    }
}
class WrongClassException extends Exception
{
    public WrongClassException(String a, String t)
    {
        System.out.printf("That id belongs to a %a, not a %s\n", a, t);
    }
}
//---------------------------
abstract class Person
{
    private String name;
    private String id;
    public Person()
    {
        name = "";
        id = "";
    } 
    public Person(String name, String id)
    {
        this.name = name;
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public String getId()
    {
        return id;
    }
    public abstract void print();

}
//---------------------------
abstract class Employee extends Person
{
    private String Department;
    public Employee()
    {
        super();
        Department = "";
    }
    public Employee(String name, String id, String Department)
    {
        super(name, id);
        this.Department = Department;
    }
    void setDepartment(String Department)
    {
        this.Department = Department;
    }
    String getDepartment()
    {
        return Department;
    }
    
    public abstract void print();
}
//---------------------------
class Student extends Person
{
    private double gpa;
    private int hours;
    private double tuition;

    public Student (String name, String id, double gpa, int hours)
    {
        super(name, id);
        this.gpa = gpa;
        this.hours = hours;
        this.tuition = (236.45 * hours);
    }
    public Student()
    {
        super();
        gpa = 0.0;
        hours = 0;
        tuition = 0.0;
    }

    public void setGpa(double gpa)
    {
        this.gpa = gpa;
    }

    public void setHours(int hours)
    {
        this.hours = hours;
    }

    public double getGpa()
    {
        return gpa;
    }

    public int getHours()
    {
        return hours;
    }

    public void setTuition(double tuition)
    {
        this.tuition = tuition;
    }

    public double getTuition()
    {
        return tuition;
    }

    public void print()
    {
        System.out.println("-------------------------------------");
        System.out.printf("%s\t%s\n", getName(), getId());
        System.out.println("Credit Hours: " + getHours() + " ($236.45/credit hour)");
        System.out.println("Fees: $52");
        if(gpa >= 3.85)
        {
            System.out.printf("Total Payment (after discount): $%.2f\t($%.2f discount applied)\n", getTuition() * .75, getTuition() * .25);
        }
        else
        {
            System.out.printf("Total Payment (after discount): $%.2f\t($%d discount applied)\n", getTuition(), 0);
        }
        System.out.println("-------------------------------------");
    }
}
//---------------------------
class Faculty extends Employee
{
    private String rank;
    
    public Faculty()
    {
        super();
        rank = "";
    }

    public Faculty(String name, String id, String Department, String rank)
    {
        super(name, id, Department);
        this.rank = rank;
    }
    
    void setRank(String rank)
    {
        this.rank = rank;
    }

    String getRank()
    {
        return rank;
    }

    public void print()
    {
        System.out.println("-------------------------------------");
        System.out.printf("%s\t%s\n", getName(), getId());
        System.out.printf("%s Department,%s\n", getDepartment(), getRank());
        System.out.println("-------------------------------------");
    }
}
//---------------------------
class Staff extends Employee
{
    private String status;

    public Staff()
    {
        super();
        status = "";
    }

    public Staff(String name, String id, String Department, String status)
    {
        super(name, id, Department);
        this.status = status;
    }

    void setStatus(String status)
    {
        this.status = status;
    }

    String getStatus()
    {
        return status;
    }


    public void print()
    {
        System.out.println("-------------------------------------");
        System.out.printf("%s\t%s\n", getName(), getId());
        System.out.printf("%s Department,%s\n", getDepartment(), getStatus());
        System.out.println("-------------------------------------");
       
    }
}