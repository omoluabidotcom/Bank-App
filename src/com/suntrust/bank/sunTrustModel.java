package com.suntrust.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class sunTrustModel {

    public  sunTrustModel() {

    }

    // database fields
    long id;
    String firstname;
    String lastname;
    String email;
    String password;
    String address;
    String occupation;
    String marital_status;
    String phone_number;
    String balance;

    // Beta features
    String meansOfIdentification;
    String nextOfKinName;
    String nextOfKinAddress;
    String nextOfKinNumber;
    String accountNumber;


    private final String url = "jdbc:mysql://localhost:3306/fk_fintech?useSSL=false";
    private final String user = "root";
    private final  String pword = "";

    private final static String REG_NEW_CUSTOMER = "INSERT INTO fk_customers(firstname, lastname, email, address, occupation," +
            "marital_status, phone_number, password) VALUES(?,?,?,?,?,?,?,?)";
    private final static String DELETE_CUSTOMER = "DELETE FROM fk_customers WHERE id = ?";
    private final static String UPDATE_CUSTOMER = "UPDATE fk_customers SET firstname=?, lastname=?, email=?, address=?" +
            "occupation=?, marital_status=?, phone_number=? WHERE id=?";
    private final static String READ_ALL_CUSTOMER = "SELECT firstname, lastname, email, address, occupation, marital_status," +
            "phone_number, balance FROM fk_customers";
    private final static String LOGIN = "SELECT firstname, lastname, email, address, occupation, marital_status, phone_number, " +
            "balance FROM fk_customer WHERE email=? AND password=?";
    private final static String DEPOSIT = "UPDATE fk_customers SET balance=? WHERE id=?";
    private final static String WITHDRAW = "UPDATE fk_customers SET balance=? WHERE id=?";


    public Connection connectDB() {

        Connection connection = null;
        try{
            connection = DriverManager.getConnection(url, user, pword);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public int customerRegister() throws SQLException {

        Connection connection = connectDB();
        PreparedStatement preparedstatement = connection.prepareStatement(REG_NEW_CUSTOMER);

        preparedstatement.setString(1, firstname);
        preparedstatement.setString(2, lastname);
        preparedstatement.setString(3, email);
        preparedstatement.setString(4, address);
        preparedstatement.setString(5, occupation);
        preparedstatement.setString(6, marital_status);
        preparedstatement.setString(7, phone_number);
        preparedstatement.setString(8, password);

        int rs = preparedstatement.executeUpdate();
        return rs;
    }

    public  void customerLogin() {

    }

    public void deposit() {

    }

    public void withdraw() {

    }

    public void transfer() {

    }

    public void deleteCustomer() {

    }

    public void updateCustomer() {

    }

    public void readAllCustomer() {


    }


//    "CREATE TABLE IF NOT EXISTS fk_customers(
//    id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
//    firstname varchar(120) NOT NULL,
//    lastname varchar(120) NOT NULL,
//    email varchar(120) NOT NULL,
//    address varchar(256) NOT NULL,
//    occupation varchar(60) NOT NULL,
//    marital_status varchar(20) NOT NULL,
//    phone_number varchar(256) NOT NULL,
//    password varchar(40) NOT NULL,
//    balance int DEFAULT(0));"

}
