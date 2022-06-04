package com.suntrust.bank;

import java.sql.SQLException;
import java.util.Scanner;

public class sunTrustBank {

    public sunTrustBank() {

    }

    // boolean to the control the do while loop
    boolean start = true;

    // suntrustmodel object
    sunTrustModel sunActive = new sunTrustModel();

    // scanner object
    Scanner scan = new Scanner(System.in);

    class customerCare{
        
    }

    class customerLogin{

    }

    // customer registration class
    class customerReg{

        Scanner scan = new Scanner(System.in);

        // class constructor
        customerReg() {

        }

        public void getDetails() {

            System.out.println("Enter your Firstname");
            sunActive.firstname = scan.nextLine();

            System.out.println("Enter your Lastname");
            sunActive.lastname = scan.nextLine();

            System.out.println("Enter your Email");
            sunActive.email = scan.nextLine();

            System.out.println("Enter your Address");
            sunActive.address = scan.nextLine();

            System.out.println("Enter your Occupation");
            sunActive.occupation = scan.nextLine();

            System.out.println("Enter your Marital Status");
            sunActive.marital_status = scan.nextLine();

            System.out.println("Enter your Phone Number");
            sunActive.phone_number = scan.nextLine();

            System.out.println("Enter your Password");
            sunActive.password = scan.nextLine();

        }

        public boolean regAccount() throws SQLException {

            boolean returnValue = false;
            if(sunActive.customerRegister() >= 1) {
                returnValue = true;
            }

            return returnValue;
        }
    }



    public void runApp() throws SQLException {

        do {
            System.out.println("Welcome to Sun Trust Bank");
            System.out.println("What action would you like to perform");
            System.out.println("Press \n 1 Customer Care Login \n 2 Customer Login \n 3 Open an Account \n 4 Exit");

            int firstOption = scan.nextInt();

            switch(firstOption) {
                case 1:
                    System.out.println("Customer Care Login");
                    start = false;
                    break;
                case 2:
                    System.out.println("Customer Login");
                    start = false;
                    break;
                case 3:
                    customerReg customerRegObj = new customerReg();
                    customerRegObj.getDetails();
                    if(customerRegObj.regAccount()) {

                        System.out.println("You have successfully opened an account with SunTrust Bank. \n Welcome to the fold");
                        System.exit(0);
                    }
                    break;
                case 4:
                    System.out.println("Thank you for banking with us");
                    start = false;
                    break;
                default:
                    System.out.println("Wrong option");
                    start = false;
                    break;
            }

        }while(start);
    }

    public static void main(String[] args) throws SQLException {

        sunTrustBank sunTrustBank = new sunTrustBank();
        sunTrustBank.runApp();
    }

}
