package game;

import game.hero.Baiqi;

public class Game1 {
    private Baiqi baiqi;

    public String heroSelected() {
        return baiqi.getName() + ":" + baiqi.say() + "";
    }

    public void setHero(Baiqi baiqi) {
        this.baiqi = baiqi;
    }
}
