package game.hero;

public class Zhangfei implements Hero{
    @Override
    public String getName() {
        return "张飞";
    }

    @Override
    public String say() {
        return "俺也一样";
    }
}
