package com.suntrust.bank;

import java.sql.SQLException;
import java.util.Scanner;

public class sunTrustBank {

    // class constructor
    public sunTrustBank() {

    }

    // control for do while loop
    boolean start = true;

    // suntrustmodel object
    sunTrustModel sunActive = new sunTrustModel();

    // scanner object
    Scanner scan = new Scanner(System.in);

    class customerCare{
        
    }

    class customerLogin{

        // class constructor
        public  customerLogin() {

        }

        Scanner scan = new Scanner(System.in);

        public  void getDetails() {

            System.out.println("Enter your Email");
            sunActive.email = scan.nextLine();

            System.out.println("Enetr your Password");
            sunActive.password = scan.nextLine();
        }

        public boolean loginCustomer() throws SQLException {

            boolean returnValue = false;
            if(sunActive.customerLogin()) {

                System.out.println("Welcome to your dashboard Mr "+sunActive.firstname+" "+sunActive.lastname);
                System.out.println("Address: "+sunActive.address);
                System.out.println("Occupation: "+sunActive.occupation);
                System.out.println("Phone Number: " + sunActive.phone_number);
                System.out.println("Balance: " + sunActive.balance);
                // System.out.println(sunActive.id);
                returnValue = true;
            }
            return returnValue;

        }

        public void getDeposit() {

            System.out.println("Enter amount to be deposit");
            sunActive.extraBalance = scan.nextLong();
        }

        public void confirmDeposit() throws SQLException {

            if(sunActive.deposit() >= 1) {

                System.out.println("Money deposited to your Account \n Your Balance is " + sunActive.balance);
            } else {

                System.out.println("Unable to perform deposit at the moment, please try again later");
            }
        }

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
                    customerLogin customerLoginObj = new customerLogin();
                    customerLoginObj.getDetails();
                    if (!customerLoginObj.loginCustomer()) {

                        System.out.println("Wrong Email or Password entered \nTry Again");
                        System.exit(0);
                    }
                    System.out.println("\n");

                    System.out.println("What action would you like to perform");
                    System.out.println("Press \n 1 Deposit \n 2 Withdraw \n 3 Back \n 4 Exit");

                    int secondOption = scan.nextInt();

                    switch (secondOption) {
                        case 1:
                            customerLoginObj.getDeposit();
                            sunActive.extraBalance = sunActive.extraBalance + Long.valueOf(sunActive.balance);
                            sunActive.balance = String.valueOf(sunActive.extraBalance);
                            customerLoginObj.confirmDeposit();
                            break;

                        case 2:
                            System.out.println();
                            break;

                        case 3:
                            break;

                        case 4:
                            System.out.println("Thank you for Banking with us.");
                            start = false;
                            break;

                        default:
                            System.out.println("Wrong option Login again");
                            break;
                    }
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
                    System.out.println("Wrong option try again");
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
