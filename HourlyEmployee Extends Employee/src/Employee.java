/*Phil Beechler
March 22, 2019
Module 5B Lab Assignment
Create HourlyEmployee class that extends  Employee
Sources used: (1) Class Slides
*/
import java.util.Scanner;
public abstract class Employee {

    String fName, lName, eID, streetAdd, city, state;

    //constructor method for Employee
    public Employee(String fName, String lName, String eID, String streetAdd, String city, String state){
        this.fName = fName;
        this.lName = lName;
        this.eID = eID;
        this.streetAdd = streetAdd;
        this.city = city;
        this.state = state;
    }
    //get-set methods below for attributes only held by Employee
    public void setfName(String fName) { this.fName = fName;}
    public String getfName() { return fName; }

    public void setlName(String lName) {this.lName = lName;}
    public String getlName(){ return lName; }

    public void seteID(String eID) { this.eID = eID; }
    public String geteID(){ return eID; }

    public void setStreetAdd(String streetAdd){ this.streetAdd = streetAdd; }
    public String getStreetAdd() { return streetAdd; }

    public void setCity(String city){ this.city = city; }
    public String getCity() { return city; }

    public void setState(String state){ this.state = state; }
    public String getState(){ return state; }

    public abstract double earnings(double hoursWorked, double hourlyRate);
}
class HourlyEmployee extends Employee{
    double hourlyRate, hoursWorked, earnings;

    //constructor for HourlyEmployee
    public HourlyEmployee(double hourlyRate, double hoursWorked, String fName, String lName, String eID, String streetAdd, String city, String state){
        super(fName, lName, eID, streetAdd, city, state);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    //get-set methods for HourlyEmployee methods
    public void setHourlyRate(double hourlyRate) {this.hourlyRate = hourlyRate;}
    public double getHourlyRate() { return hourlyRate;}

    public void setHoursWorked(double hoursWorked){ this.hoursWorked = hoursWorked;}
    public double getHoursWorked(){ return hoursWorked; }

    public double earnings(double hoursWorked, double hourlyRate){
        return hoursWorked*hourlyRate;
    }
    public String toString(){
        /*
            toString method to create pretty outputs like this:
            Employee Name:
            Address:
            City State
            Hourly Rate
            Hours Worked       Earnings: $
         */
        return("Employee Name: "+super.getfName()
                +" "
                +super.getlName()
                +"\n"
                +"Employee ID: "+super.geteID()
                +"\n"
                +"Employee Address: "
                +super.getStreetAdd()
                +"\n"
                +super.getCity()
                +" "
                +super.getState()
                +"\n"
                +"Employee Hourly Rate: "+this.getHourlyRate()
                +"\n"
                +"Hours Worked: "+this.getHoursWorked()
                +" "
                +"Earnings: $"+String.format("%.2f",(this.earnings(this.getHoursWorked(),this.getHourlyRate()))));
    }
}
class Test{
    //test class to interact with HourlyEmployee Objects
    public static void main(String[] args){
        double hourlyRate, hoursWorked;
        Scanner input = new Scanner(System.in);
        String fName, lName, eID, streetAdd, city, state;
        HourlyEmployee[] employees = new HourlyEmployee[2]; //create array of employee objects
        System.out.println("Let's set up your two new employees. Please enter their information when prompted.");
        for(int x = 0; x < 2; x++){ //for loop to substantiate two employees
            System.out.println("What is the employee's first name?");
            fName = input.nextLine();
            System.out.println("What is the employee's last name?");
            lName = input.nextLine();
            System.out.println("Please enter the employee ID.");
            eID = input.nextLine();
            System.out.println("Enter their street address.");
            streetAdd  = input.nextLine();
            System.out.println("What city?");
            city = input.nextLine();
            System.out.println("Now the state please.");
            state = input.nextLine();
            System.out.println("What's their hourly rate?");
            hourlyRate = input.nextDouble();
            System.out.println("How many hours worked?");
            hoursWorked = input.nextDouble();
            input.nextLine();
            employees[x] = new HourlyEmployee(hourlyRate, hoursWorked, fName, lName, eID, streetAdd, city, state);
            employees[x].earnings(hoursWorked,hourlyRate); //set earnings with rate/hours worked
        }
        /*Splits up and gets toString method for the two employees
         */
        System.out.println();
        System.out.println("Employee One:");
        System.out.println(employees[0].toString());
        System.out.println();
        System.out.println("Employee Two:");
        System.out.println(employees[1].toString());
    }
}
