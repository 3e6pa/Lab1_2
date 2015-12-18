package vectors;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anla1215
 */
public class LinkedListVectorTest {

    public LinkedListVectorTest() {
    }

    @Before
    public void setUp() {

    }

    @Test
    public void testAddArray_doubleArr() {
        System.out.println("Check method addArray(double[])");

        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        LinkedListVector instance = new LinkedListVector();
        instance.addArray(m);

        boolean isPass = true;
        for (int i = 0; i < instance.size(); i++) {
            if (instance.getValue(i) != m[i]) {
                isPass = false;
                break;
            }
        }
        assertTrue(isPass);
    }

    @Test
    public void testAddArray_Vector() {
        System.out.println("Check method addArray(Vector)");

        double[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        Vector m = new LinkedListVector();
        m.addArray(data);

        m.show();
        LinkedListVector instance = new LinkedListVector();
        instance.addArray(m);

        boolean isPass = true;
        for (int i = 0; i < instance.size(); i++) {
            if (instance.getValue(i) != m.getValue(i)) {
                isPass = false;
                break;
            }
        }
        assertTrue(isPass);
    }

    @Test
    public void testAddFirst1() {
        System.out.println("addFirst1");
        double value = 0.0;
        double expResult = 0.0;
        LinkedListVector instance = new LinkedListVector();
        instance.addFirst(value);
        assertEquals(expResult, instance.getValue(0), 0.0);
    }

    @Test
    public void testAddFirst2() {
        System.out.println("addFirst2");
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double value = 0.0;
        LinkedListVector instance = new LinkedListVector();
        instance.addArray(m);
        int size = instance.size();
        instance.addFirst(value);
        boolean isPass = true;
        if ((instance.getValue(0) != value) || (size != instance.size())) {
            isPass = false;
        }
        assertTrue(isPass);
        //   fail("The test case is a prototype.");
    }

    @Test
    public void testAddLast1() {
        System.out.println("addLast1");
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double value = 0.0;
        LinkedListVector instance = new LinkedListVector();
        instance.addArray(m);
        int size = instance.size();
        instance.addLast(value);
        boolean isPass = true;
        if ((instance.getValue(instance.size() - 1) != value) || (size == instance.size())) {
            isPass = false;
        }
        assertTrue(isPass);
        // fail("The test case is a prototype.");
    }

    @Test
    public void testAddLast2() {
        System.out.println("addLast2");
        double value = 0.0;
        LinkedListVector instance = new LinkedListVector();
        instance.addLast(value);
        boolean isPass = true;
        if (instance.getValue(instance.size() - 1) != value) {
            isPass = false;
        }
        assertTrue(isPass);
        // fail("The test case is a prototype.");
    }

    @Test
    public void testAdd() {
        System.out.println("add value = 0.0, index = 5 ");
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double value = 0.0;
        int index = 5;
        LinkedListVector instance = new LinkedListVector();
        instance.addArray(m);
        instance.show();
        int size = instance.size();
        instance.add(value, index);
        boolean isPass = true;
        if ((instance.getValue(index) != value) || (instance.size() == size)) {
            isPass = false;

        }
        instance.show();
        assertTrue(isPass);

        //  fail("The test case is a prototype.");
    }

    @Test
    public void testShow() {
        System.out.println("show");
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        LinkedListVector instance = new LinkedListVector();
        instance.addArray(m);
        instance.show();
        // fail("The test case is a prototype.");
    }

    @Test
    public void testGetValue() {
        System.out.println("getValue");
        int index = 0;
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        LinkedListVector instance = new LinkedListVector();
        double expResult = 1.0;
        instance.addArray(m);
        double result = instance.getValue(index);
        System.out.println("expResult = " + expResult + ", result = " + result);
        assertEquals(expResult, result, 0.0);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testRemoveLast() {
        System.out.println("removeLast");
        LinkedListVector instance = new LinkedListVector();
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        instance.addArray(m);
        int size = instance.size();
        instance.show();
        instance.removeLast();
        instance.show();
        boolean isPass = true;
        if (size == instance.size()) {
            isPass = false;
        }
        assertTrue(isPass);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testRemove() {
        int index = 8;
        System.out.println("remove index = " + index);
        LinkedListVector instance = new LinkedListVector();
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        instance.addArray(m);
        double value = instance.getValue(6);
        instance.remove(index);
        instance.show();
        boolean isPass = true;
        if (instance.getValue(index) == value) {
            isPass = false;
        }
        assertTrue(isPass);
        // fail("The test case is a prototype.");
    }

    @Test
    public void testRemoveFirst() {
        System.out.println("removeFirst");
        LinkedListVector instance = new LinkedListVector();
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        instance.addArray(m);
        instance.show();
        double value = instance.getValue(0);
        int size = instance.size();
        instance.removeFirst();
        instance.show();
        boolean isPass = true;
        if ((instance.getValue(0) == value) && (size == instance.size())) {
            isPass = false;
        }
        assertTrue(isPass);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testSize() {
        System.out.println("size");
        LinkedListVector instance = new LinkedListVector();
        double[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        instance.addArray(m);
        instance.show();
        int expResult = 9;
        int result = instance.size();
        System.out.println("expResult = " + expResult + " result = " + result);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testMaxSize() {
        System.out.println("maxSize");
        Vector m = new LinkedListVector();
        Vector n = new LinkedListVector();
        double[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double[] b = {1, 2, 3, 4, 5, 6, 7, 8};
        n.addArray(a);
        m.addArray(b);
        LinkedListVector instance = new LinkedListVector();
        int expResult = 9;
        int result = instance.maxSize(m, n);
        System.out.println("expResult = " + expResult + " result = " + result);
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testMinSize() {
        System.out.println("minSize");
        Vector m = new LinkedListVector();
        Vector n = new LinkedListVector();
        double[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double[] b = {1, 2, 3, 4, 5, 6, 7, 8};
        n.addArray(b);
        m.addArray(a);
        LinkedListVector instance = new LinkedListVector();
        int expResult = 8;
        int result = instance.minSize(m, n);
        assertEquals(expResult, result);
        System.out.println("expResult = " + expResult + " result = " + result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testCompare() {
        System.out.println("compare");
        Vector m = new LinkedListVector();
        Vector n = new LinkedListVector();
        double[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double[] b = {1, 2, 3, 4, 5, 6, 7, 8};
        n.addArray(b);
        m.addArray(a);
        LinkedListVector instance = new LinkedListVector();
        int expResult = 0;
        int result = instance.compare(m, n);
        System.out.println("expResult = " + expResult + " result = " + result);
        assertEquals(expResult, result);
        // fail("The test case is a prototype.");
    }

    /*  @Test
    public void testToString() {
        System.out.println("toString");
        LinkedListVector instance = new LinkedListVector();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

 /*   @Test
    public void testHashCode() {
        System.out.println("hashCode");
        LinkedListVector instance = new LinkedListVector();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }*/
    @Test
    public void testEquals() {
        System.out.println("equals");
        Vector m = new LinkedListVector();
        LinkedListVector instance = new LinkedListVector();
        double[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        m.addArray(a);
        instance.addArray(m);
        boolean expResult = false;
        boolean result = instance.equals(m);
        assertEquals(expResult, result);
        // fail("The test case is a prototype.");
    }

    @Test
    public void testClone() throws Exception {
        Vector clon = new LinkedListVector();
        Vector etalon = new LinkedListVector();
        double[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        etalon.addArray(a);
        Object result = etalon.clone();
        clon = (LinkedListVector) result;
        clon.show();
        etalon.add(105, 5);
        clon.show();
        boolean isPass = true;
        if (clon == etalon) {
            isPass = false;
        }
        assertTrue(isPass);
        // fail("The test case is a prototype.");
    }
    /**/
}
