package rest;

import com.google.gson.Gson;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManager;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import utils.ApiDataCallable;
import utils.PuSelector;
import utils.URLReader;

/**
 * @author lam@cphbusiness.dk
 */
@Path("info")
public class DemoResource
{
    /**
     * file name of file containing api urls.
     */
    public static String fileName = "/META-INF/externalApis.properties";

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll()
    {
        return "{\"msg\":\"Hello anonymous\"}";
    }

    //Just to verify if the database is setup
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("all")
    public String allUsers()
    {
        EntityManager em = PuSelector.getEntityManagerFactory("pu").createEntityManager();
        try
        {
            List<User> users = em.createQuery("select user from User user").getResultList();

            return "[" + users.size() + "]";

        } finally
        {
            em.close();
        }

    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed("user")
    public String getFromUser()
    {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to User: " + thisuser + "\"}";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin()
    {
        String thisuser = securityContext.getUserPrincipal().getName();
        return "{\"msg\": \"Hello to (admin) User: " + thisuser + "\"}";
    }
    
    /**
     * Fetches data asynchronously from the urls specified.
     *      
     * @return JSON encoded string.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("fetch")    
    public String fetchFromApisAsync()
    {
        // Create executor service
        ExecutorService executorService = Executors.newCachedThreadPool();
        // Create collection to hold futures.
        List<Future<String>> futures = new ArrayList();
        // Create collection to hold result.
        List<String> result = new ArrayList();
        
        ArrayList<String> urls = URLReader.readUrls(DemoResource.fileName);
        // Iterate through urls, create anonymous callable, add it to executorservice and futures.
        for(String url : urls)
        {           
            futures.add((Future<String>) executorService.submit(new ApiDataCallable(url)));            
        }

        try
        {
            // Iterate through futures to assemble results.
            for(Future<String> future : futures)            
            {
                result.add(future.get());
            }
        }
        catch(Exception e)
        {
            // Q&D Store exception in result.             
            result.add(e.getMessage());
            e.printStackTrace();
        }
        
        return new Gson().toJson(result);
    }
}
