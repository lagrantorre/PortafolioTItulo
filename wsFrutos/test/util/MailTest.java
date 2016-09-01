/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert
 */
public class MailTest {
    
    public MailTest() {
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
     * Test of recuperarMail method, of class Mail.
     */
    @Test
    public void testRecuperarMail() {
        System.out.println("recuperarMail");
        int rut = 17069097;
        Mail instance = new Mail();
        boolean expResult = true;
        boolean result = instance.recuperarMail(rut);
        assertEquals(expResult, result);
    }
    
}
