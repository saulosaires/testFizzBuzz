package com.serviceflow.resources;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;

import com.serviceflow.resources.FizzBuzzResource;

import static org.junit.Assert.assertEquals;

public class FizzBuzzResourceTest extends JerseyTest {

	private static final String PATH="fizzbuzz";
	private static final String NUMBER="number";
	
	
    @Override
    protected Application configure() {
        return new ResourceConfig(FizzBuzzResource.class);
    }

    
    @Test
    public void testFizz() {
    	
    	Integer num_3=3;
    	Integer num_6=3;
    	Integer num_9=3;
    	
         Response response3 = target().queryParam(NUMBER, num_3).path(PATH).request().get(Response.class);
         Response response6 = target().queryParam(NUMBER, num_6).path(PATH).request().get(Response.class);
         Response response9 = target().queryParam(NUMBER, num_9).path(PATH).request().get(Response.class);
         
         String fizz_3 =response3.readEntity(String.class);
         String fizz_6 =response6.readEntity(String.class);
         String fizz_9 =response9.readEntity(String.class);
         
        assertEquals(FizzBuzzResource.FIZZ, fizz_3);
        assertEquals(FizzBuzzResource.FIZZ, fizz_6);
        assertEquals(FizzBuzzResource.FIZZ, fizz_9);
        
        
    }
    
    @Test
    public void testBuzz() {
    	
    	Integer num_5=5;
    	Integer num_10=10;
    	Integer num_20=20;
    	
         Response response5  = target().queryParam(NUMBER, num_5).path(PATH).request().get(Response.class);
         Response response10 = target().queryParam(NUMBER, num_10).path(PATH).request().get(Response.class);
         Response response20 = target().queryParam(NUMBER, num_20).path(PATH).request().get(Response.class);
         
         String fizz_5 =response5.readEntity(String.class);
         String fizz_10 =response10.readEntity(String.class);
         String fizz_20 =response20.readEntity(String.class);
         
        assertEquals(FizzBuzzResource.BUZZ, fizz_5);
        assertEquals(FizzBuzzResource.BUZZ, fizz_10);
        assertEquals(FizzBuzzResource.BUZZ, fizz_20);
        
        
    }
    /**
     * 15 is divided by both 3 and 5 , but the order is fizz and then buzz
     * **/
    @Test
    public void testFizzBeforeBuzz() {
    	
    	Integer num_15=15;

    	
         Response response15  = target().queryParam(NUMBER, num_15).path(PATH).request().get(Response.class);
           
         String fizz_15 =response15.readEntity(String.class);
          
        assertEquals(FizzBuzzResource.FIZZ, fizz_15);
         
        
    }
    
    @Test
    public void testInvalidNumber() {
    	
    	Integer num1=0;
    	Integer num2=-1;
    	Integer num3=null;
    	
         Response response1 = target().queryParam(NUMBER, num1).path(PATH).request().get(Response.class);
         Response response2 = target().queryParam(NUMBER, num2).path(PATH).request().get(Response.class);
         Response response3 = target().queryParam(NUMBER, num3).path(PATH).request().get(Response.class);
         
         String num_1 =response1.readEntity(String.class);
         String num_2 =response2.readEntity(String.class);
         String num_3 =response3.readEntity(String.class);
         
         int status_1=response1.getStatus();
         int status_2=response2.getStatus();
         int status_3=response3.getStatus();
         
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(),status_1);
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(),status_2);
        assertEquals(Response.Status.BAD_REQUEST.getStatusCode(),status_3);       
        
        assertEquals(FizzBuzzResource.INVALID_NUMBER, num_1);
        assertEquals(FizzBuzzResource.INVALID_NUMBER, num_2);
        assertEquals(FizzBuzzResource.INVALID_NUMBER, num_3);
        
        
    }
    
    @Test
    public void testNotFizzNotBuzz() {
    	
    	Integer num_7=7;
    	Integer num_8=8;
    	Integer num_11=11;
    	Integer num_13=13;
    	
         Response response7 = target().queryParam(NUMBER, num_7).path(PATH).request().get(Response.class);
         Response response8 = target().queryParam(NUMBER, num_8).path(PATH).request().get(Response.class);
         Response response11 = target().queryParam(NUMBER, num_11).path(PATH).request().get(Response.class);
         Response response13 = target().queryParam(NUMBER, num_13).path(PATH).request().get(Response.class);

         
         String resp_7  =response7.readEntity(String.class);
         String resp_8  =response8.readEntity(String.class);
         String resp_11 =response11.readEntity(String.class);
         String resp_13 =response13.readEntity(String.class);
         
        assertEquals(7, Integer.parseInt(resp_7));
        assertEquals(8, Integer.parseInt(resp_8));
        assertEquals(11,Integer.parseInt(resp_11));
        assertEquals(13,Integer.parseInt(resp_13));
        
        
    } 
    
    
}
