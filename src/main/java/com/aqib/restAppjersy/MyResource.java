package com.aqib.restAppjersy;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.Entity.Student;
@Path("myresource")
public class MyResource {
    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_HTML)
    public String getIt() {
        return "<html><body><h1>This is my fist jersey resourcse</h1></body></html>";
    }
    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response home() {
//        return "{id:1,name:'ali',class:'mcs'}";
    	Student s= new Student(1,"Ali");
    	 return Response.status(200).entity(s).build();
    }
    @GET
    @Path("/jsonData")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return "{id:1,name:'ali',class:'mcs'}";
    }
    @POST
    @Path("/save-student")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addStudent(Student s) throws URISyntaxException 
    {
        if(s == null){
            return Response.status(400).entity("Please add employee details !!").build();
        }
         
        if(s.getName() == null) {
            return Response.status(400).entity("Please provide the employee name !!").build();
        }
        return Response.status(200).entity(s).build();
    }
}
