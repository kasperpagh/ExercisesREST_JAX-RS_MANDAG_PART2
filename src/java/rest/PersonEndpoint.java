/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import exceptions.CouldNotPutOrDeleteException;
import exceptions.DataMissingException;
import exceptions.PersonNotFoundException;
import facade.PersonFacade;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author kaspe
 */
@Path("person")
public class PersonEndpoint
{

    @Context
    private UriInfo context;
    Gson gson;
    PersonFacade pf;

    public PersonEndpoint()
    {
        gson = new GsonBuilder().setPrettyPrinting().create();
        pf = new PersonFacade();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPerson(@PathParam("id") String id) throws PersonNotFoundException
    {
        int a = Integer.parseInt(id);
        Person found = pf.getPerson(a);
        if (found == null)
        {
            throw new PersonNotFoundException("No person with provided id found");
        }

        return gson.toJson(found);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons()
    {
        return gson.toJson(pf.getPersons());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createPerson(String JsonPerson) throws DataMissingException
    {
        Person p = gson.fromJson(JsonPerson, Person.class);
        if (p == null)
        {
            throw new DataMissingException("First Name or Last Name is missing");

        }
        else if ((p.getPhone() == null) || (p.getfName() == null) || (p.getlName() == null))
        {
            throw new DataMissingException("First Name or Last Name is missing");
        }
        else
        {
            pf.addPerson(p);
        }
    }

    //Virker hvis man i sit json objekt ligger id ind som første field!
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void updatePerson(String jsonPerson) throws CouldNotPutOrDeleteException, DataMissingException
    {
        Person p = gson.fromJson(jsonPerson, Person.class);

        if (p == null)
        {
            throw new CouldNotPutOrDeleteException("Could not delete/edit. No person with provided id exists");
        }
        else if ((p.getPhone() == null) || (p.getfName() == null) || (p.getlName() == null))
        {
            throw new DataMissingException("First Name or Last Name is missing");
        }
        else
        {
            pf.editPerson(p);
        }

    }

    @DELETE
    @Path("/{id}")
    public void deletePerson(@PathParam("id") String id) throws CouldNotPutOrDeleteException
    {
        int a = Integer.parseInt(id);
        Person p = pf.getPerson(a);
        if (p == null)
        {
            throw new CouldNotPutOrDeleteException("Could not delete/edit. No person with provided id exists");
        }
        pf.deletePerson(a);
    }

}
