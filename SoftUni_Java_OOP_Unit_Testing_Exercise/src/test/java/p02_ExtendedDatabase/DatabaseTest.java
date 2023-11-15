package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    private Database db;
    private static final Person[] people = {
            new Person(1,"Pesho"),
            new Person(2,"Gosho"),
            new Person(3,"Mimi")};


    @Before
    public void setUp() throws OperationNotSupportedException {
        db = new Database(people);
    }

    @Test
    public void testConstructorWithCorrectParams(){
       assertArrayEquals(people, db.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorsWithMoreThan16ElementsShouldThrow() throws OperationNotSupportedException {
        db = new Database(new Person[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithoutElementsShouldThrow() throws OperationNotSupportedException {
        db = new Database(new Person[0]);
    }

    @Test
    public void testAddingPeople() throws OperationNotSupportedException {
        Person exp = new Person(4, "Mimi");

        db.add(exp);

        Person actual = db.getElements()[db.getElements().length - 1];

        assertEquals(exp, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddingPeopleWithNullShouldThrow() throws OperationNotSupportedException {
        db.add(null);
    }

    @Test
    public void testRemoving() throws OperationNotSupportedException {
        db.remove();

        assertEquals(2, db.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemovingThrows() throws OperationNotSupportedException {
        for (int i = 0; i < 4; i++) {
            db.remove();
        }
    }

    @Test
    public void testFindingByUsername() throws OperationNotSupportedException {
        Person exp = people[2];
        Person actual = db.findByUsername("Mimi");

        assertEquals(exp, actual);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameNullThrow() throws OperationNotSupportedException {
        db.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByNameNonExistentThrows() throws OperationNotSupportedException {
        db.findByUsername("Peter");
    }


}