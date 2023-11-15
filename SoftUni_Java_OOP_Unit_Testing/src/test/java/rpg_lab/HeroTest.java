package rpg_lab;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HeroTest {

    private Hero hero;
    private Weapon weapon;

    @Before
    public void setUp() throws Exception {
        weapon = Mockito.mock(Weapon.class);
        hero = new Hero("Pesho", weapon);
    }

    @Test
    public void testGainsXpWhenAttackAndTargetDies() {
        Target facade = Mockito.mock(Target.class);

        Mockito.when(facade.isDead()).thenReturn(true);

        int exp = 10;

        Mockito.when(facade.giveExperience()).thenReturn(exp);

        hero.attack(facade);


        assertEquals(exp, hero.getExperience());


    }
}