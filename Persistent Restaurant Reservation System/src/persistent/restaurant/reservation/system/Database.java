/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistent.restaurant.reservation.system;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author ABC
 */
public class Database {
    Connection con;
    public Database()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/restaurant", "root", "deutrium2");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void insert(String name, String password, String type)
    {
        try
        {
            PreparedStatement preparedStatement = con.prepareStatement("insert into restaurant.account(name, password,type) values( '" + name + "' , '" + password + "' , '" + type + "' );");
            preparedStatement .executeUpdate();
            
            String timestamp = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss").format(new Date());
            PreparedStatement preparedStatement1 = con.prepareStatement("insert into restaurant.log(description, time) values(\"Member being inserted into the database\", '"+ timestamp +"' );");
            preparedStatement1.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void select()
    {
        try
        {
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM account");
        
        while (rs.next()){
   
            // Correct!
            int value1 = rs.getInt(1);
            String value2 = rs.getString(2);
            String value4 = rs.getString(4);
            System.out.println("Id: " + value1 + "\nName: " + value2 + "\nType :" + value4 + "\n");
         }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    //function for authenticating username and password
    public boolean check(String name, String password)
    {
        boolean x = false;
        try
        {
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM account");
        
        while (rs.next()){
   
            // Correct!
            int value1 = rs.getInt(1);
            String value2 = rs.getString(2);
            String value3 = rs.getString(3);
            if(value2.matches(name) && value3.matches(password))
            {
                System.out.println("Successfully logged in as: " + value2);
                x = true;
                break;
            }
         }
        
        if(x == false)
        {
            System.out.println("Incorrect username or password!");
        }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        return x;
    }
    
    //function for returning the type of user
    public String getType(String name)
    {
        String type = null;
        try
        {
             Statement statement = con.createStatement();
             ResultSet rs = statement.executeQuery("SELECT type FROM account where name = '" + name + "' ;");
             rs.next();
             if (rs.getString(1) != null)
             type = rs.getString(1);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        return type;
    }
    //function for making reservation for the  clinet
    public void makeReservation()
    {
        try
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Make a reservation!");
            System.out.println("Enter time:");
            String time =sc.nextLine();               
            System.out.println("Enter table:");
            String table =sc.nextLine();
            System.out.println("Enter number of members:");
            int members = sc.nextInt();
            
            PreparedStatement preparedStatement = con.prepareStatement("insert into restaurant.reservation(time, bookTable,number) values( '" + time + "' , '" + table + "' , '" + members + "' );");
            preparedStatement .executeUpdate();
            
            String timestamp = new SimpleDateFormat("yyyy-MM-dd.HH:mm:ss").format(new Date());
            PreparedStatement preparedStatement1 = con.prepareStatement("insert into restaurant.log(description, time) values(\"Reservation being made by a client member\", '"+ timestamp +"' );");
            preparedStatement1.executeUpdate();
            
            System.out.println("Reservation done!");
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    }
    
    
    //function for getting the log data for the manager
    public void getLog()
    {
        try
        {
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM log");
        
        while (rs.next()){
   
            
            String value2 = rs.getString(2);
            String value3 = rs.getString(3);
           
            System.out.println("Description: " + value2 + "\nTime: " + value3);
         }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
 
    
}
