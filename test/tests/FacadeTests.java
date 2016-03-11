/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import entity.Person;
import facade.PersonFacade;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kaspe
 */
public class FacadeTests
{

    PersonFacade pf = new PersonFacade();

    public FacadeTests()
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
    public void testAdd_AndGet_AndDelete_AndEdit_Person()
    {
        //test af get og add
        Person bob = new Person("test1", "test2", "test3");
        pf.addPerson(bob);
        Person bob2 = pf.getPerson(bob.getId());
        //Her kan jeg ikke bruge assertEqual(bob,bob2) da de to objekter blot har ens attributer, ikke samme location i memory (som den tester efter).
        assertEquals(bob.getfName(), bob2.getfName());
        assertEquals(bob.getlName(), bob2.getlName());
        assertEquals(bob.getPhone(), bob2.getPhone());
        
        
        //test af DELETE
        pf.deletePerson(1);
        assertTrue(pf.getPersons().isEmpty());
        
        //test af PUT
        Person bobPut = new Person("test4", "test5", "test6");
        pf.addPerson(bobPut);
        Person edited = new Person("editet","editet","editet");
        edited.setId(bobPut.getId());
        pf.editPerson(edited);
        pf.deletePerson(2);        
    }

}
