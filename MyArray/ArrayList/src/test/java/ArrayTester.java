import ClassForTesting.ArrayList;
import org.junit.Test;
import static junit.framework.Assert.assertEquals;

public class ArrayTester {

    ArrayList arrayList = new ArrayList();

    @Test
    public void test() throws Exception {
        testAdd(arrayList);
        testGet(arrayList);
        testDelete(arrayList);
    }

    @SuppressWarnings("unchecked")
    void testAdd(ArrayList arrayList) throws Exception {
        arrayList.add(5);
        arrayList.add(3);
        arrayList.add(8);
    }

    void testGet(ArrayList arrayList) throws Exception {
        assertEquals(5, arrayList.getById(0));
        assertEquals(3, arrayList.getById(1));
        assertEquals(8, arrayList.getById(2));
    }

    void testDelete(ArrayList arrayList) throws Exception {
        arrayList.removeById(0);
        arrayList.removeById(1);
        arrayList.removeById(2);

        assertEquals(null, arrayList.getById(0));
        assertEquals(null, arrayList.getById(1));
        assertEquals(null, arrayList.getById(2));
    }
}
