/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistent.restaurant.reservation.system;
import java.util.Scanner;
/**
 *
 * @author ABC
 */
public class userThread extends Thread{
    
    public userThread()
    {
        
    }
    
    public void run()
    {
        try
        {
            Database db = new Database();

            String name;
            String password;

            Scanner sc=new Scanner(System.in);
            System.out.println("Enter your name:");
            name =sc.nextLine();
            System.out.println("Enter your password:");
            password =sc.nextLine();

            if(db.check(name, password))
            {
                System.out.println(db.getType(name));
            }
            
            String type = db.getType(name);
            if(type.matches("client"))
            {
                db.makeReservation();
            }
            else if(type.matches("manager"))
            {
                System.out.println("\nShowing Log Data:  \n\n");
                db.getLog();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
    }
    
}
