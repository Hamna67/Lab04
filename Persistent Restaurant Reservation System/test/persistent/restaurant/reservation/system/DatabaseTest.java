/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistent.restaurant.reservation.system;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ABC
 */
public class DatabaseTest {
    
    public DatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class Database.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        String name = "";
        String password = "";
        String type = "";
        Database instance = new Database();
        instance.insert(name, password, type);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of select method, of class Database.
     */
    @Test
    public void testSelect() {
        System.out.println("select");
        Database instance = new Database();
        instance.select();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of check method, of class Database.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        String name = "Hamna";
        String password = "Zahid";
        Database instance = new Database();
        boolean expResult = true;
        boolean result = instance.check(name, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Database.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        String name = "Hamna";
        Database instance = new Database();
        String expResult = "client";
        String result = instance.getType(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of makeReservation method, of class Database.
     */
    @Test
    public void testMakeReservation() {
        System.out.println("makeReservation");
        Database instance = new Database();
        instance.makeReservation();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getLog method, of class Database.
     */
    @Test
    public void testGetLog() {
        System.out.println("getLog");
        Database instance = new Database();
        instance.getLog();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
