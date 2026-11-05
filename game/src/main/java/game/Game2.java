package game;

import game.hero.Hero;

public class Game2 {
    private Hero hero;

    public String heroSelected() {
        return hero.getName() + ":" + hero.say() + "";
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
