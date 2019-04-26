/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Claus
 */
public class DemoResourceJUnitTest
{
    
    public DemoResourceJUnitTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    @Test
    public void testFetchFromApisAsync()
    {
        // Arrange
        DemoResource dr = new DemoResource();

        // Act.
        String result = dr.fetchFromApisAsync();

        // Assert
//        System.out.println("result: " + result);
        Assert.assertTrue(result != "");
    }
    
    @Test
    public void testFetchFromApis()
    {
        // Arrange
        DemoResource dr = new DemoResource();

        // Act.
        String result = dr.fetchFromApis();

        // Assert
//        System.out.println("result: " + result);
        Assert.assertTrue(result != "");
    }
    
}
