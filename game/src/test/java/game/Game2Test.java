package game;

import game.hero.Baiqi;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Game2Test {

    @Test
    public void testHero() {
        Game2 game2 = new Game2();
        game2.setHero(new Baiqi());
        assertEquals("白起:" + "曾经，我也是个普通人。", game2.heroSelected());
    }
}
