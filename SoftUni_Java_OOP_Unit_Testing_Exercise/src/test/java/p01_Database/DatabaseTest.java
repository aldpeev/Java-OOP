package p01_Database;

import junit.framework.TestCase;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertArrayEquals;

public class DatabaseTest {
    private Database database;
    private static final Integer[] validData = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

//    public void setUp() throws OperationNotSupportedException {
//        database = new Database(data);
//    }


    @Test
    public void testConstructor() throws OperationNotSupportedException {
        Database db = new Database(validData);
        assertArrayEquals(validData, db.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsBiggerLength() throws OperationNotSupportedException {
        new Database(new Integer[17]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithZeroElements() throws OperationNotSupportedException {
        new Database();
    }

    @Test
    public void testAddMethodIfAddsCorrectly() throws OperationNotSupportedException {
        Database database = new Database(1, 2);

        Integer[] exp = {1, 2, 3};

        database.add(3);

        assertArrayEquals(exp, database.getElements());

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodWithNullParameter() throws OperationNotSupportedException {
        Database db = new Database(1);
        db.add(null);

    }



}