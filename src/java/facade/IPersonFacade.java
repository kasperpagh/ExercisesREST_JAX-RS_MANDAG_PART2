/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import java.util.List;

/**
 *
 * @author kaspe
 */
public interface IPersonFacade
{

    public Person addPerson(Person p);

    public Person deletePerson(int id);

    public Person getPerson(int id);

    public List<Person> getPersons();

    public Person editPerson(Person p);
}
