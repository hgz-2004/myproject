import game.hero.Hero;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:applicationContext.xml" })
public class SpringTest {

    //请补充注解1
    @Resource(name = "caocao")
    private Hero herol;

    //请补充注解2
    @Resource(name = "hanxin")
    private Hero hanxin;

    @Test
    public void testGetHerol() {
        assertEquals("曹操", herol.getName());
    }

    @Test
    public void testGetHanxin() {
        assertEquals("韩信", hanxin.getName());
    }

    public void setHerol(Hero herol) {
        this.herol = herol;
    }

    public void setHanxin(Hero hanxin) {
        this.hanxin = hanxin;
    }
}
