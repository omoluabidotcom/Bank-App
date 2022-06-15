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

        // class constructor
        public customerCare() {

        }

        public  void confirmDelete() throws SQLException {

            if (sunActive.deleteCustomer()>=1) {

                System.out.println("Customer delete success");
            } else {

                System.out.println("Something went wrong. \nUnable to perform customer deletion at the moment, inform IT of error");
            }
        }

        public  void  confirmUpdate() throws SQLException {

            if (sunActive.updateCustomer()>=1) {

                System.out.println("Customer update success");
            } else {

                System.out.println("Something went wrong. \nUnable to perform customer update at the moment, inform IT of error");
            }
        }

        public void readAllCustomers() {


        }

    }

    class customerLogin{

        // class constructor
        public customerLogin() {

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

        public void getWithdrawal() {

            System.out.println("Enter amount you want to withdraw");
            sunActive.extraBalance = scan.nextLong();
        }

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
            System.out.println("\nWelcome to Sun Trust Bank");
            System.out.println("What action would you like to perform");
            System.out.println("Press \n 1 Customer Care Login \n 2 Customer Login \n 3 Open an Account \n 4 Exit");

            int firstOption = scan.nextInt();

            switch(firstOption) {

                case 1:
                    System.out.println("\nWelcome Customer Care Attendant");
                    System.out.println("What action would you like to perform for the Customer");
                    System.out.println("Press \n 1 To delete a Customer \n 2 TO update a Customer detail \n");

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
                            // back switch that is why no code is here
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
