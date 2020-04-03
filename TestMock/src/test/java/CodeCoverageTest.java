import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CodeCoverageTest {

    ISayHello sayHello = new SayHello();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    //测试 sayHello(String who, int gender);
    @Test
    public void testSayHello1() {
        assertEquals(sayHello.sayHello("david", ISayHello.MALE),"hello Mr david");
        assertEquals(sayHello.sayHello("lucy", ISayHello.FEMALE),"hello Mrs lucy");
        thrown.expect(IllegalArgumentException.class);
        sayHello.sayHello("david", 3);
    }
    //测试 sayHello(String[] who, int[] gender)
    @Test
    public void testSayHello2() {
        String[] who = new String[] { "david", "lucy" };
        int[] gender = new int[] { ISayHello.MALE, ISayHello.FEMALE };
        List<String> result = sayHello.sayHello(who, gender);
        assertEquals(result.get(0),"hello Mr david");
        assertEquals(result.get(1),"hello Mrs lucy");


    }

}
