import ClassForTesting.BitCount;
import org.junit.Test;
import static junit.framework.Assert.*;

// this is class - tester
public class BitCountTest
{
    @Test
    public void test() throws Exception {
        BitCount bc = new BitCount();

        assertEquals(5, bc.countBits(1234));
        assertEquals(0, bc.countBits(0));
        assertEquals(1, bc.countBits(1));
    }
}
