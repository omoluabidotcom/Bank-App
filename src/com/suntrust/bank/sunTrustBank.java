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

    // customercare class, allows customer care attendant to login, delete customer and update customer details
    class customerCare{

        // class constructor
        public customerCare() {

        }

        // method to ascertain deletion
        public  void confirmDelete() throws SQLException {

            if (sunActive.deleteCustomer()>=1) {

                System.out.println("Customer delete success");
            } else {

                System.out.println("Something went wrong. \nUnable to perform customer deletion at the moment, inform IT department of error");
            }
        }

        // method to ascertain update
        public  void  confirmUpdate() throws SQLException {

            if (sunActive.updateCustomer()>=1) {

                System.out.println("Customer update success");
            } else {

                System.out.println("Something went wrong. \nUnable to perform customer update at the moment, inform IT department of error");
            }
        }

        // method to confirm customer data fetch
        public void readAllCustomers() throws SQLException {

            sunActive.readAllCustomer();
        }

    }

    // customer login
    class customerLogin{

        // class constructor
        public customerLogin() {

        }

        // scanner object
        Scanner scan = new Scanner(System.in);

        // methods for collecting customers details
        public  void getDetails() {

            System.out.println("Enter your Email");
            sunActive.email = scan.nextLine();

            System.out.println("Enetr your Password");
            sunActive.password = scan.nextLine();
        }

        // method to login customer
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

        // method to set deposit value to a field
        public void getDeposit() {

            System.out.println("Enter amount to be deposit");
            sunActive.extraBalance = scan.nextLong();
        }

        // method to confirm deposit
        public void confirmDeposit() throws SQLException {

            if(sunActive.deposit() >= 1) {

                System.out.println("Money deposited to your Account \n Your Balance is " + sunActive.balance);
            } else {

                System.out.println("Unable to perform deposit at the moment, please try again later");
            }
        }

        // methods to set withdrawal field
        public void getWithdrawal() {

            System.out.println("Enter amount you want to withdraw");
            sunActive.extraBalance = scan.nextLong();
        }

        // method to confirm withdraw
        public void confirmWithdraw() throws SQLException {

            if(sunActive.withdraw() >= 1) {

                System.out.println("Withdrawal successful");
            } else {

                System.out.println("Unable to perform withdrawal at the moment, please try again later");
            }
        }

    }

    // customer registration class
    class customerReg{

        // scanner object
        Scanner scan = new Scanner(System.in);

        // class constructor
        customerReg() {

        }

        // method to assign values to fields for customer bank registration
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

        // method to perform the bank registration
        public boolean regAccount() throws SQLException {

            boolean returnValue = false;
            if(sunActive.customerRegister() >= 1) {
                returnValue = true;
            }

            return returnValue;
        }
    }


    // method to run bank application
    public void runApp() throws SQLException {

        do {
            System.out.println("\nWelcome to Sun Trust Bank");
            System.out.println("What action would you like to perform");
            System.out.println("Press \n 1 Customer Care Login \n 2 Customer Login \n 3 Open an Account \n 4 Exit");

            int firstOption = scan.nextInt();

            switch(firstOption) {

                case 1:
                    System.out.println("\nWelcome Customer Care Attendant");
                    System.out.println("What action would you like to perform for the Customer");
                    System.out.println("Press \n 1 To delete a Customer \n 2 To update a Customer detail \n 3 To read all " +
                            "Customers details \n 4 Back \n 5 Exit");

                    customerCare customerCareObj = new customerCare();
                    int secondOption = scan.nextInt();

                    switch (secondOption) {
                        case 1:
                            System.out.println("Enter the id of customer to be deleted");
                            sunActive.id = String.valueOf(scan.nextLong());
                            customerCareObj.confirmDelete();
                            break;
                        case 2:
                            System.out.println("Enter correct customer firstname");
                            scan.nextLine();
                            sunActive.firstname = scan.nextLine();
                            System.out.println("Enter correct customer lastname");
                            sunActive.lastname = scan.nextLine();
                            System.out.println("Enter correct customer email");
                            sunActive.email = scan.nextLine();
                            System.out.println("Enter correct customer address");
                            sunActive.address = scan.nextLine();
                            System.out.println("Enter correct customer occupation");
                            sunActive.occupation = scan.nextLine();
                            System.out.println("Enter correct customer marital status");
                            sunActive.marital_status = scan.nextLine();
                            System.out.println("Enter correct customer phone number");
                            sunActive.phone_number = scan.nextLine();
                            System.out.println("Enter Customer id");
                            sunActive.id = scan.nextLine();
                            customerCareObj.confirmUpdate();
                            break;
                        case 3:
                            System.out.println("List of Customers according to id");
                            customerCareObj.readAllCustomers();
                            break;
                        case 4:
                            // back
                            break;
                        case 5:
                            System.out.println("Thank you for Banking with us");
                            start = false;
                        default:
                            System.out.println("Wrong option try again");
                            break;
                    }
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

                    int thirdOption = scan.nextInt();

                    switch (thirdOption) {
                        case 1:
                            customerLoginObj.getDeposit();
                            sunActive.extraBalance = sunActive.extraBalance + Long.valueOf(sunActive.balance);
                            sunActive.balance = String.valueOf(sunActive.extraBalance);
                            customerLoginObj.confirmDeposit();
                            break;

                        case 2:
                            customerLoginObj.getWithdrawal();
                            if (sunActive.extraBalance > Long.valueOf(sunActive.balance)) {

                                System.out.println("Insufficient balanace");
                            } else {

                                sunActive.withdrawalFund = Long.valueOf(sunActive.balance);
                                sunActive.withdrawalFund = sunActive.withdrawalFund - sunActive.extraBalance;
                                sunActive.balance = String.valueOf(sunActive.withdrawalFund);
                                customerLoginObj.confirmWithdraw();
                            }
                            break;

                        case 3:
                            // back
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

    // psvm
    public static void main(String[] args) throws SQLException {

        // application run
        sunTrustBank sunTrustBank = new sunTrustBank();
        sunTrustBank.runApp();
    }

}
