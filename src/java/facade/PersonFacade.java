/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author kaspe
 */
public class PersonFacade implements IPersonFacade
{

    Gson gson = gson = new GsonBuilder().setPrettyPrinting().create();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExercisesREST_JAX-RS_MANDAG_PART2PU");
    EntityManager em;

    public Person addPerson(Person p)
    {
        em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }
        finally
        {
            em.close();
        }
        return p;
    }

    @Override
    public Person deletePerson(int id)
    {
        em = emf.createEntityManager();
        try
        {
            Person p = em.find(Person.class, id);
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }
    }

    public Person getPerson(int id)
    {
        em = emf.createEntityManager();
        try
        {
            Person p = em.find(Person.class, id);
            return p;
        }
        finally
        {
            em.close();
        }
    }

    public List<Person> getPersons()
    {
        em = emf.createEntityManager();
        try
        {
            Query query = em.createNamedQuery("Person.findAll", Person.class);
            List<Person> persList = query.getResultList();
            return persList;
        }
        finally
        {
            em.close();
        }
    }

    public Person editPerson(Person p)
    {
        em = emf.createEntityManager();
        try
        {
            Person pers = em.find(Person.class, p.getId());
            pers.setId(p.getId());
            pers.setfName(p.getfName());
            pers.setlName(p.getlName());
            pers.setPhone(p.getPhone());
            em.getTransaction().begin();
            em.persist(pers);
            em.getTransaction().commit();
            return pers;
        }
        finally
        {
            em.close();
        }
    }

}
