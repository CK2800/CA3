/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Utility class to fetch data from an api.
 * @author Claus
 */
public class ApiData
{
    /**
     * Connects to the provided api url, reads the json response and returns it.
     * @param apiurl The URL of the API to connect to.
     * @return String containing a single line of json from the response or null.
     * @throws MalformedURLException
     * @throws IOException 
     */
    public static String getData(String apiurl) throws MalformedURLException, IOException
    {
        // Create URL object and open connection.
        URL url = new URL(apiurl);        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Set request method to GET
        connection.setRequestMethod("GET");
        // Set request headers.
        connection.setRequestProperty("User-Agent", "server"); // no need to specify actual device.
        connection.setRequestProperty("Accept", "application/json;charset=UTF-8"); // we want json returned and we understand UTF-8 
        
        // Read from the input stream of the connection.
        Scanner scanner = new Scanner(connection.getInputStream());
        
        String jsonResult = null;
        if (scanner.hasNext())
            jsonResult = scanner.nextLine(); // doable, since the json result is a single line.
        scanner.close();
//        System.out.println("JSON Received: " + jsonResult);
        return jsonResult;
    }    
}
