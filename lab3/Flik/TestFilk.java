import static org.junit.Assert.*;

import org.junit.Test;

public class TestFilk {
    @Test
    public void testFilk(){
        int a = 10;
        int b =10;
        int c = 20;
        boolean res1 = Flik.isSameNumber(a, b);
        boolean res2 = Flik.isSameNumber(a, c);
        assertTrue(res1);
        assertTrue(!res2);
    }
}
