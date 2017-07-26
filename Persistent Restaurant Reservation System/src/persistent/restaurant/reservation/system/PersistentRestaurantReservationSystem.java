/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistent.restaurant.reservation.system;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author ABC
 */
public class PersistentRestaurantReservationSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        User u1 = new User("Hamna","Zahid","client");
        User u2 = new User("ABC", "hello","manager");
       
        Database db = new Database();
        //db.insert(u1.getName(),u1.getPassword(),u1.getType());
        //db.insert(u2.getName(),u2.getPassword(),u2.getType());
        
        //db.select();
       
       
        Thread user1 = new userThread();
        user1.start();
        
        //Thread user2 = new userThread();
        //user2.start();
    }
    
}
