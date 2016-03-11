/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utils.JsonConverter;

/**
 *
 * @author kaspe
 */
public class JsonTests
{

    static Gson gson = gson = new GsonBuilder().setPrettyPrinting().create();

    public JsonTests()
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
    public void testJsonFromPerson()
    {
        Person test = new Person("test", "test", "test");
        String jsonRepresentation = gson.toJson(test);

        assertEquals(JsonConverter.getJsonFromPerson(test), jsonRepresentation);
    }

    @Test
    public void testPersonFromJson()
    {
        Person test = new Person("test", "test", "test");
        String jsonRepresentation = gson.toJson(test);

        System.out.println("her er json: " + jsonRepresentation);
        Person test2 = JsonConverter.getPersonFromJson(jsonRepresentation);
        assertEquals(test.getfName(), test2.getfName());
        assertEquals(test.getlName(), test2.getlName());
        assertEquals(test.getPhone(), test2.getPhone());

    }
}
