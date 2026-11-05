import game.hero.Hero;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class SpringInjectionTest {
    ApplicationContext ac;

    @Before
    public void prepareSpringContainer() {
        ac=new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testConstrucInjection() {
        Hero hanxin=(Hero)ac.getBean("hanxin");
        assertEquals("韩信:必将百倍奉还",hanxin.getName()+":"+hanxin.say());
    }

    @Test
    public void testSetterInjection() {
        Hero caocao=(Hero)ac.getBean("caocao");
        assertEquals("曹操:周公吐哺，天下归心",caocao.getName()+":"+caocao.say());
    }
}
