//David Grimes


import java.util.ArrayList; 

public class DriverClass
{
    public static void main(String[] args)
    {
        String fullName = "Erika T. Jones";
        String employeeNumber = "ej789";
        double payRate = 100.0, hoursWorked = 1.0;
        // TA will change the payrate and the hours worked to test your code
        Employee e;
        e = new Employee(fullName, employeeNumber, payRate, hoursWorked);
        System.out.println(e); // To Test your toString method
        e.printCheck(); // This prints the check of Erika T. Jones
        Company company = new Company();
        company.hire ( new Employee ("Saeed Happy", "sh895" , 2 , 200) );
        company.hire ( new Employee ("walid williams", "ab784" , 4 , 100) );
        System.out.println(company.hire ( new Employee ("walid williams", "ab784" , 4 , 100) ));
        company.hire (e);
        company.printCompanyInfo();
        company.printEmployees();
        //You may add as many employees to company as you want.
        //The TAs will add their own employees
        //Make sure that each employee of company has a unique employeeNumber
        company.printCheck("ac784");
        System.out.println( company.SearchByName("WaLiD WiLLiAms") );
        company.deleteEmployeesBySalary(94);
        company.reverseEmployees();
        company.printEmployees();
        System.out.println("Bye!");

        //^^^i rearranged the order of the some of the calls to show that each method works
    }
}
//____________________________
class Employee
{
    //Add the private attributes and the methods as mentioned above...
    private String fullName;
    private String employeeNumber;
    private double payRate;
    private double hoursWorked;

    public Employee(String fullName, String employeeNumber, double payRate, double hoursWorked)
    {
        this.fullName = fullName;
        this.employeeNumber = employeeNumber;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }
    
    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber)
    {
        this.employeeNumber = employeeNumber;
    }

    public double getPayRate()
    {
        return payRate;
    }

    public void setPayRate(double payRate)
    {
        this.payRate = payRate;
    }

    public double getHoursWorked()
    {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked)
    {
        this.hoursWorked = hoursWorked;
    }

    public double GrossPay()
    {
        return payRate * hoursWorked;
    }

    private double NetPay()
    {
        return GrossPay() * 0.94;
    }

    @Override public String toString()
    {
        return "[" + employeeNumber + "/" + fullName + ", " + hoursWorked + "Hours @ " + payRate + " per hour]";
    }

    public void printCheck ()
    {
        System.out.printf("--------------------------------------\n");
        System.out.printf("\tEmployee's Name: %s\n", fullName);
        System.out.printf("\tEmployee's Number: %s\n", employeeNumber);
        System.out.printf("\tHourly rate of pay: %.2f\n", payRate);
        System.out.printf("\tHours worked: %.2f\n\n", hoursWorked); 
        System.out.printf("\tTotal gross pay: $%.2f\n\n\t", GrossPay()); 
        System.out.println("Deductions");
        System.out.printf("\tTax(6 %%): $%.2f\n\n", GrossPay() * 0.06);
        System.out.printf("\tNet pay: $%.2f\n", NetPay());
        System.out.printf("--------------------------------------\n");        

    }
}
//____________________________
class Company
{
    private ArrayList<Employee> employeeList;
    private String companyName;
    private static String companyTaxId;
    //Add static Setters and Getters for companyTaxId. We assume that

    public static String getcompanyTaxId()
    {
        return companyTaxId;
    }
    public static void setcompanyTaxId(String companyTaxId)
    {
        Company.companyTaxId = companyTaxId;
    }
    //all companies share the same companyTaxId and that may change
    //Add Setter and Getter for the companyName
    public String getcompanyName()
    {
        return companyName;
    }
    public void setcompanyName(String companyName)
    {
        this.companyName = companyName;
    }
    //No need to add a Setter and Getter for employeeList
    public Company()
    {
        employeeList = new ArrayList<>();
        companyName = "People's Place";
        companyTaxId = "v1rtua7C0mpan1";
    }
    public boolean hire ( Employee employee )
    {
    //Add employee to employeeList
    //Note well that we can't add an employee whose employeeNumber already 
    //assigned to another employee. In that case, this method returns false.
    //This method returns true otherwise
        for (Employee element : employeeList)
        {
            
            if (element.getEmployeeNumber() == employee.getEmployeeNumber())
            {
                return false;
                
            }   
        }
            employeeList.add(employee);
            return true;
            }
    public void printCompanyInfo()
    {
    //This method prints the company name, the tax id and the current number
    //of employees
    //You may choose to print that any way you like!
        System.out.println("Company Name: " + companyName);
        System.out.println("Tax ID: " + companyTaxId);
        System.out.println("Number of Employees: " + employeeList.size());
    }
    public void printEmployees()
    {
    //This methods prints all employees (One employee per line)
    //Note that you already have toString in Employee
        for (Employee element : employeeList)
        {
            System.out.println(element.toString());
        }
    }
    public int countEmployees( double maxSalary )
    {
    //This method returns the number of employees paid less than maxSalary
        int count = 0;
        for (Employee element : employeeList)
        {
            if (element.GrossPay() < maxSalary)
            {
                count++;
            }
        }
        return count;
    }
    public boolean SearchByName (String fullName )
    {
    //This method returns true if fullName exists as an employee.
    //It returns false otherwise
    //this is a not a case sensitive search.

        for (Employee element : employeeList) 
        {
            if (element.getFullName().equalsIgnoreCase(fullName)) 
            {
                return true;
            }
        }
        return false;
    }
    public void reverseEmployees ()
    {
    //This method reverses the order in which the employees were added to 
    //the list. The last employee is swapped with the first employee, the 
    //second last with the second and so on..

        ArrayList<Employee> temp = new ArrayList<> ();
        for (int i = employeeList.size() - 1; i >= 0; i--)
        {
            temp.add(employeeList.get(i));
        }
        employeeList = temp;
    }
    public void deleteEmployeesBySalary (double targetSalary )
    {
    //This method deletes all employees who are paid targetSalary as a net salary

        employeeList.removeIf(element -> ((element.GrossPay() * .94) == targetSalary));

    }
    public void printCheck ( String employeeNumber)
    {
    //This method prints the check of the employee whose employee number is
    //employeeNumber. It prints NO SUCH EMPLOYEE EXISTS if employeeNumber is 
    //not a registered employee number.
        for (Employee element : employeeList)
        {
            
            if (element.getEmployeeNumber() == employeeNumber) 
            {
                element.printCheck();
                return;
                
            }
        }
        System.out.println("NO SUCH EMPLOYEE EXISTS");
    }
}//end of class Company