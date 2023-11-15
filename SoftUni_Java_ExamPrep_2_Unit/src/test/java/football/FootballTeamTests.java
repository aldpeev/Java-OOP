package football;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {
    FootballTeam footballTeam;
    private static final String VALID_NAME = "Pesho";
    private static final int VACANT_POSITIONS = 3;

    private static final Footballer footballer1 = new Footballer("Gosho");
    private static final Footballer footballer2 = new Footballer("Mimi");

//    @Before
//    public void setUp(){
//
//
//        footballTeam = new FootballTeam()
//    }

    @Test
    public void testConstructorWithValidData(){
        footballTeam = new FootballTeam(VALID_NAME,VACANT_POSITIONS);

        String expName = footballTeam.getName();
        int expVacantPos = footballTeam.getVacantPositions();

        assertEquals(expName, VALID_NAME);
        assertEquals(expVacantPos, VACANT_POSITIONS);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructWithNullName(){
        footballTeam = new FootballTeam(null, VACANT_POSITIONS);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructWithEmptyName(){
        footballTeam = new FootballTeam(" ", VACANT_POSITIONS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructWithInvalidVacant(){
        footballTeam = new FootballTeam(VALID_NAME, -1);
    }

    @Test
    public void testAddingFootballers(){
        footballTeam = new FootballTeam(VALID_NAME,VACANT_POSITIONS);
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);

        int actual = footballTeam.getCount();
        int exp = 2;

        assertEquals(exp, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingFootballersThrowsMoreThanAccepted(){
        footballTeam = new FootballTeam(VALID_NAME,VACANT_POSITIONS);
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer2);
    }

    @Test
    public void testRemovingFootballer(){
        footballTeam = new FootballTeam(VALID_NAME,VACANT_POSITIONS);
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);

        footballTeam.removeFootballer(footballer1.getName());

        int expSize = 1;
        int actualSize = footballTeam.getCount();

        assertEquals(expSize, actualSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovingMissingFootballerThrows(){
        footballTeam = new FootballTeam(VALID_NAME,VACANT_POSITIONS);
        footballTeam.removeFootballer("Mesho");
    }

    @Test
    public void testFootballersForSale(){
        footballTeam = new FootballTeam(VALID_NAME,VACANT_POSITIONS);

        footballTeam.addFootballer(footballer1);

        Footballer expected = footballTeam.footballerForSale(footballer1.getName());

        assertEquals(expected.isActive(), false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleWithNullThrows(){
        footballTeam = new FootballTeam(VALID_NAME,VACANT_POSITIONS);
        footballTeam.footballerForSale("Pesho");
    }


}















































