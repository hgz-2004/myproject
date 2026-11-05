import game.Game2;
import game.hero.Baiqi;
import game.hero.CustomHero;
import game.hero.Zhangfei;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class SpringContainerTest {
    ApplicationContext ac;

    @Before
    public void prepareSpringContainer() {
        ac=new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testBaiqi() {
        Game2 g1=new Game2();
        g1.setHero(ac.getBean("baiqi", Baiqi.class));
        assertEquals("白起:"+"曾经，我也是个普通人。",g1.heroSelected());
    }

    @Test
    public void testZhangfei() {
        Game2 g1=new Game2();
        g1.setHero(ac.getBean("zhangfei", Zhangfei.class));
        assertEquals("张飞:"+"俺也一样",g1.heroSelected());
    }
}
