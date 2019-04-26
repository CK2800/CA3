/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittest;

import entity.UserFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import rest.DemoResource;
import testutils.TestUtils;
import utils.ApiData;
import utils.PuSelector;
import utils.URLReader;

/**
 *
 * @author Claus
 */
public class TestApiData
{
    public TestApiData()
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
    public void apiDataReceived() throws Exception
    {
        // Arrange
        String url = "https://swapi.co/api/people/4";
        String response;
        // Act
        response = ApiData.getData(url);
//        System.out.println("Rsponse from " + url + ": " + response);

        // Assert
        Assert.assertTrue(response != null);
    }    
}
