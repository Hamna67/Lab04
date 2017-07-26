/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistent.restaurant.reservation.system;

/**
 *
 * @author ABC
 */

//user class for storing the name and password of users
public class User {
    private String name;
    private String password;
    private String type;
    
    User(String n, String p, String t)
    {
        name = n;
        password = p;
        type = t;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String getType()
    {
        return type;
    }
}
