package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class AxeTest {
    private Axe axe;
    private Axe brokenAxe;
    private Dummy target;
    private static final int ATTACK = 10;
    private static final int DURABILITY = 10;
    private static final int HEALTH_TARGET = 100;
    private static final int EXPERIENCE_TARGET = 10;


    @Before
    public void setUp(){
        axe = new Axe(ATTACK, DURABILITY);
        target = new Dummy(HEALTH_TARGET,EXPERIENCE_TARGET);
        brokenAxe = new Axe(ATTACK,0);
    }

    @Test
    public void testAttackIfLoosesDurability(){
        axe.attack(target);

        int expDurability = DURABILITY - 1;

        assertEquals(expDurability,axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackWithBrokenAxe(){
        brokenAxe.attack(target);
    }



}



























