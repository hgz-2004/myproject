package game.hero;

public class CustomHero implements Hero{
    private String name;
    private String slogan;

    public CustomHero() {}

    public CustomHero(String name,String slogan){
        this.name=name;
        this.slogan=slogan;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String say() {
        return slogan;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
}
