package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    private Dummy dummy;
    private Dummy deadDummy;
    private static final int HEALTH = 100;
    private static final int EXPERIENCE = 100;
    private static final int ATTACK_POINTS = 10;
    private static final int DEAD_DUMMY_HEALTH = 0;

    @Before
    public void setUp(){
        dummy = new Dummy(HEALTH, EXPERIENCE);
        deadDummy = new Dummy(DEAD_DUMMY_HEALTH,EXPERIENCE);
    }

    @Test
    public void testAttackGetHealth(){
        dummy.takeAttack(ATTACK_POINTS);

        int exp = HEALTH - ATTACK_POINTS;

        assertEquals(exp,dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackDeadDummy(){
        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test
    public void testGiveExpIfDead(){
        assertEquals(EXPERIENCE, deadDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testGiveExpIfAlive(){
        dummy.giveExperience();
    }
}