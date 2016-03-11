/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import java.util.List;

/**
 *
 * @author kaspe
 */
public class JsonConverter
{

    static Gson gson = gson = new GsonBuilder().setPrettyPrinting().create();

    public static Person getPersonFromJson(String jsonString)
    {
        return gson.fromJson(jsonString, Person.class);
    }
    
    public static String getJsonFromPerson(Person p)
    {
        return gson.toJson(p, Person.class); 
    }
    
    public static String getJsonFromPersons(List<Person> persons)
    {
        return gson.toJson(persons, Person.class);
    }
}

